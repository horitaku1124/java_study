import static java.lang.System.out;

public class StringTest1 {
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
      ary[i] = "";
    }

    afterUse = memoryUsed();

    div = afterUse - beforeUse;
    out.println(" -- String[] set empty -- ");
    out.println(div);
    out.println((double)div / ary.length);

    for (int i = 0;i < NUM;i++) {
      ary[i] = new String();
    }

    afterUse = memoryUsed();

    div = afterUse - beforeUse;
    out.println(" -- String[] set new String -- ");
    out.println(div);
    out.println((double)div / ary.length);
  }
}
