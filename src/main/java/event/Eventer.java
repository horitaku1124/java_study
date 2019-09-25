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
        final List<Consumer> finishListener;
        public Commander(CommanderOption option) {
            this.commands = option.commands;
            this.stdoutReceivers = option.stdoutReceivers;
            this.stdErrorReceivers = option.stdErrorReceivers;
            this.finishListener = option.finishListener;
        }
        Thread mainThread;
        public void start() {
            start(true);
        }
        public void start(final boolean callFinish) {
            final List<Consumer<String>> stdoutReceivers = this.stdoutReceivers;
            final List<Consumer<String>> stdErrorReceivers = this.stdErrorReceivers;
            final List<Consumer> finishListener = this.finishListener;
            mainThread = new Thread(() -> {
                Process child;
                try {
                    child = Runtime.getRuntime().exec(commands);
                    BufferedReader stdin = new BufferedReader(new InputStreamReader(child.getInputStream()));
                    BufferedReader stderr = new BufferedReader(new InputStreamReader(child.getErrorStream()));

                    while(child.isAlive()) {
                        if(stdin.ready()) {
                            String line = stdin.readLine();
                            for (Consumer<String> a: stdoutReceivers) {
                                a.accept(line);
                            }
                        }
                        if(stderr.ready()) {
                            String line = stderr.readLine();
                            for (Consumer<String> a: stdErrorReceivers) {
                                a.accept(line);
                            }
                        }
                        Thread.sleep(100);
                    }
                    if (callFinish) {
                        for (Consumer a: finishListener) {
                            a.accept(null);
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            mainThread.start();
        }
        public void startAndWait() {
            start(false);
            while(mainThread.isAlive()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            for (Consumer a: finishListener) {
                a.accept(null);
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
            private List<Consumer> finishListener = new ArrayList<>();

            public CommanderOption addStdoutReceiver(Consumer<String> receiver) {
                this.stdoutReceivers.add(receiver);
                return this;
            }
            public CommanderOption addStdErrorReceiver(Consumer<String> stdErrorReceiver) {
                this.stdErrorReceivers.add(stdErrorReceiver);
                return this;
            }
            public CommanderOption addFinishListener(Consumer finishListener) {
                this.finishListener.add(finishListener);
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
                .addStdoutReceiver(s -> System.out.println("Con:" + s))
                .addFinishListener(s -> System.out.println("finish"))
                .build();
        ping.startAndWait();
    }
}
