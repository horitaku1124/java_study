import static java.lang.System.out;

public class BoxTest5 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    double[] primitive = new double[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- double[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Double[] classes = new Double[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Double[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = (double) i;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Double[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
}
