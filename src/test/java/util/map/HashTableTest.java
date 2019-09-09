package util.map;

import org.junit.Test;
import util.HashTable;
import util.ObjectArrayList;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HashTableTest {
    @Test
    public void test1() {
        Object key = "abc";
        System.out.println(key.hashCode());
        int h;
        int hash = (h = key.hashCode()) ^ h >>> 16;
        System.out.println(h >>> 16);
        System.out.println(hash);

    }
    @Test
    public void test2() {
        HashMap<String, String> map = new HashMap<>();
        map.put("abc", "ok");

        System.out.println(map.get("abc"));
    }

    @Test
    public void test3() {
        HashTable<String, Integer> map = new HashTable<>();
        assertThat(map.size(), is(0));
        map.put("a", 1);
        assertThat(map.size(), is(1));
        assertThat(map.get("a"), is(1));
        map.put("b", 2);
        assertThat(map.get("a"), is(1));
        assertThat(map.get("b"), is(2));
        assertThat(map.size(), is(2));

        map.put("b", 3);
        assertThat(map.get("a"), is(1));
        assertThat(map.get("b"), is(3));
        assertThat(map.size(), is(2));
    }

    @Test
    public void test4() {
        HashTable<Integer, String> map = new HashTable<>();
        assertThat(map.size(), is(0));
        assertThat(map.containsKey(1), is(false));
        map.put(1, "A");
        assertThat(map.containsKey(1), is(true));
        assertThat(map.get(1), is("A"));
        map.put(2, "B");
        assertThat(map.containsKey(1), is(true));
        assertThat(map.containsKey(2), is(true));
        assertThat(map.get(1), is("A"));
        assertThat(map.get(2), is("B"));
    }
    @Test
    public void performance() {
        int[] nums = {100, 500, 1_000, 5_000, 10_000, 50_000, 100_000, 500_000};
        for (int num: nums) {
            long started = System.nanoTime();
            HashTable<Integer, String> map = new HashTable<>();
            for (int i = 0;i < num;i++) {
                map.put(i, String.valueOf(i));
            }
            long stopped = System.nanoTime();
            double elapse = stopped - started;
            double ns = elapse / num;
            System.out.format("N=%12d - %,15.0fns - %,15.2fns/N\n", num, elapse, ns);
            assertThat(map.size(), is(num));
        }
    }
}
