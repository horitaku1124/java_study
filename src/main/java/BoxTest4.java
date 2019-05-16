import static java.lang.System.out;

public class BoxTest4 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    float[] primitive = new float[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- float[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Float[] classes = new Float[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Float[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = (float) i;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Float[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
}
