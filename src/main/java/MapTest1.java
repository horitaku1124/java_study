import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class MapTest1 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;

  public static void main(String[] args) {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();

    Map<String, String> map = new HashMap<>();
    for (int i = 0;i < NUM;i++) {
      map.put(String.valueOf(i), "A" + i);
    }
    System.gc();
    afterUse = memoryUsed();

    div = afterUse - beforeUse;
    out.println(" -- String[] set 10digit -- ");
    out.println(div);
    out.println((double)div / map.size());
  }
}
