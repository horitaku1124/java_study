import static java.lang.System.out;

public class BoxTest3 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    compareLong();
  }

  public static void compareLong() {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    long[] primitive = new long[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- long[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);


    beforeUse = memoryUsed();
    Long[] classes = new Long[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Long[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = (long) i;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Long[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
}
