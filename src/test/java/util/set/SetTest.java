package util.set;

import org.junit.Test;
import util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SetTest {
    @Test
    public void test1() {
        Set<String> set = new Set<>();
        assertThat(set.size(), is(0));
        assertThat(set.contains("a"), is(false));

        set.add("a");
        assertThat(set.contains("a"), is(true));
        assertThat(set.size(), is(1));
        assertThat(set.contains("b"), is(false));
        set.add("b");
        set.add("c");
        set.add("d");
        assertThat(set.size(), is(4));
        set.add("a");
        assertThat(set.size(), is(4));
        assertThat(set.contains("a"), is(true));
    }

    @Test
    public void add_performanceTest() {

        int[] nums = {100, 200, 500, 1_000, 2_000, 5_000, 10_000, 50_000};
        for (int num: nums) {
//            System.out.println("N=" + num);

            long started = System.nanoTime();
            Set<Integer> set = new Set<>();
            for (int i = 0;i < num;i++) {
                set.add(i);
            }
            long stopped = System.nanoTime();
            double elapse = stopped - started;
            double ns = elapse / num;
            System.out.format("N=%12d - %,15.0fns - %,15.2fns/N\n", num, elapse, ns);
            assertThat(set.size(), is(num));
        }
    }
}
