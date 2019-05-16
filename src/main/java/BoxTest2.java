import static java.lang.System.out;

public class BoxTest2 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    int[] primitive = new int[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- int[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Integer[] classes = new Integer[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Integer[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = i;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Integer[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
}
