package maps;

import com.carrotsearch.sizeof.RamUsageEstimator;

import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.out;

public class TreeMapTest2 {
  private static long memoryUsed() {
    Runtime runtime = Runtime.getRuntime();
    return runtime.totalMemory() - runtime.freeMemory();
  }

  private static final int NUM = 100_000;
  private static Map<String, String> map;

  public static void main(String[] args) {
    long beforeUse, afterUse, div;
    beforeUse = memoryUsed();

    map = new TreeMap<>();
    for (int i = 0;i < NUM;i++) {
      map.put(String.valueOf(i), "A" + i);
    }
    System.gc();
    afterUse = memoryUsed();

    div = afterUse - beforeUse;
    out.println(" -- String[] set 10digit -- ");
    out.println(div);
    out.println((double)div / map.size());
    out.println(RamUsageEstimator.sizeOf(map));
  }
}
