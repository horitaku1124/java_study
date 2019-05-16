import java.util.HashMap;
import java.util.Map;

public class JavaTest1 {
  public static void main(String[] args) {
    Runtime runtime = Runtime.getRuntime();
    long beforeUse = runtime.totalMemory() - runtime.freeMemory();
    Map map = new HashMap();
    for (int i = 0;i < 100000;i++) {
      map.put(i, i);
    }
    long afterUse = runtime.totalMemory() - runtime.freeMemory();
    long div = afterUse - beforeUse;
    System.out.println(div);
    System.out.println((double)div / map.size());
  }
}
