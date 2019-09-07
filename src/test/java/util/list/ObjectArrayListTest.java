package util.list;

import org.junit.Test;
import util.ObjectArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ObjectArrayListTest {
    @Test
    public void test1() {
        ObjectArrayList<Integer> list = new ObjectArrayList<>();
        assertThat(list.size(), is(0));
        list.add(1);
        assertThat(list.size(), is(1));
        list.add(2);
        list.add(2);
        list.add(3);
        assertThat(list.size(), is(4));

        assertThat(list.get(0), is(1));
        assertThat(list.get(1), is(2));
        assertThat(list.get(2), is(2));
        assertThat(list.get(3), is(3));
    }

    @Test
    public void add_performanceTest() {
        int[] nums = {100, 500, 1_000, 5_000, 10_000, 50_000, 100_000};
        for (int num: nums) {
//            System.out.println("N=" + num);

            long started = System.nanoTime();
            ObjectArrayList<Integer> list = new ObjectArrayList<>();
            for (int i = 0;i < num;i++) {
                list.add(i);
            }
            long stopped = System.nanoTime();
            double elapse = stopped - started;
            System.out.format("N=%12d - %,15.0fns\n", num, elapse);
            assertThat(list.size(), is(num));
        }
    }
}
