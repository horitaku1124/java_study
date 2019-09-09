package util.pair;

import org.junit.Test;
import util.Pair;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PairTest {
    @Test
    public void test1() {
        Pair<Integer, Integer> pair = Pair.of(1, 2);
        assertThat(pair.getLeft(), is(1));
        assertThat(pair.getRight(), is(2));
    }
}
