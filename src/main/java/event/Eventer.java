package event;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Eventer {
    static class Commander extends EventerBase {
        final String[] commands;
        final List<Consumer<String>> stdoutReceivers;
        final List<Consumer<String>> stdErrorReceivers;
        public Commander(CommanderOption option) {
            this.commands = option.commands;
            this.stdoutReceivers = option.stdoutReceivers;
            this.stdErrorReceivers = option.stdErrorReceivers;
        }
        public void start() {
            Process child;
            try {
                child = Runtime.getRuntime().exec(commands);
                BufferedReader stdin = new BufferedReader(new InputStreamReader(child.getInputStream()));
                BufferedReader stderr = new BufferedReader(new InputStreamReader(child.getErrorStream()));

                while(child.isAlive()) {
                    if(stdin.ready()) {
                        String line = stdin.readLine();
                        for (Consumer<String> a: this.stdoutReceivers) {
                            a.accept(line);
                        }
                    }
                    if(stderr.ready()) {
                        String line = stderr.readLine();
                        for (Consumer<String> a: this.stdErrorReceivers) {
                            a.accept(line);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        static class CommanderBuilder {
            public static CommanderOption commands(String... comm) {
                CommanderOption co = new CommanderOption();
                co.commands = comm;
                return co;
            }
        }
        static class CommanderOption {
            private String[] commands;
            private List<Consumer<String>> stdoutReceivers = new ArrayList<>();
            private List<Consumer<String>> stdErrorReceivers = new ArrayList<>();

            public CommanderOption addStdoutReceiver(Consumer<String> receiver) {
                this.stdoutReceivers.add(receiver);
                return this;
            }
            public CommanderOption addStdErrorReceiver(Consumer<String> stdErrorReceiver) {
                this.stdErrorReceivers.add(stdErrorReceiver);
                return this;
            }
            public Commander build() {
                Commander commander = new Commander(this);
                return commander;
            }
        }


    }
    public static void main(String[] args) {
        Commander ping = Commander.CommanderBuilder.commands("ping", "-c", "10", "127.0.0.1")
                .addStdoutReceiver(s ->   System.out.println("Con:" + s))
                .build();
        ping.start();
    }
}
