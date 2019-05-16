import static java.lang.System.out;

public class BoxTest1 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    compareBoolean();
    compareByte();
    compareShort();
    compareChar();
  }

  public static void compareBoolean() {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    boolean[] primitive = new boolean[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- boolean[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Boolean[] classes = new Boolean[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Boolean[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = true;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Boolean[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }

  public static void compareByte() {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    byte[] primitive = new byte[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- byte[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Byte[] classes = new Byte[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Byte[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = (byte)(i & 0xff);
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Byte[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
  public static void compareChar() {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    char[] primitive = new char[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- char[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Character[] classes = new Character[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Character[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = (char)i;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Character[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
  public static void compareShort() {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();
    short[] primitive = new short[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- short[] -- ");
    out.println(div);
    out.println((double)div / primitive.length);

    beforeUse = memoryUsed();
    Short[] classes = new Short[NUM];
    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Short[] unset -- ");
    out.println(div);
    out.println((double)div / classes.length);

    for (int i = 0;i < classes.length;i++) {
      classes[i] = (short)i;
    }

    afterUse = memoryUsed();
    div = afterUse - beforeUse;

    out.println(" -- Short[] set -- ");
    out.println(div);
    out.println((double)div / classes.length);
  }
}
