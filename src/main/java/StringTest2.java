import static java.lang.System.out;

public class StringTest2 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    String[] ary = new String[NUM];
    afterUse = memoryUsed();

    div = afterUse - beforeUse;
    out.println(" -- String[] unset -- ");
    out.println(div);
    out.println((double)div / ary.length);

    for (int i = 0;i < NUM;i++) {
      ary[i] = new String("0123456789");
    }

    afterUse = memoryUsed();

    div = afterUse - beforeUse;
    out.println(" -- String[] set 10digit -- ");
    out.println(div);
    out.println((double)div / ary.length);
  }
}
