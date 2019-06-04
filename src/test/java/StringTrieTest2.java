import org.junit.Before;
import org.junit.Test;
import trie.StringToStringTrie;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringTrieTest2 {
    private StringToStringTrie tree;

    @Before
    public void setup() {
        tree = new StringToStringTrie();
    }

    @Test(timeout = 1000)
    public void findByPrefixTest1() {
        tree.put("a", "1");
        tree.put("ab", "10");
        tree.put("abc", "100");
        tree.put("b", "2");
        tree.put("bc", "20");

        assertThat(tree.size(), is(5));
        Set<Map.Entry<String, String>> aSet = tree.findByPrefix("a");
        assertThat(aSet.size(), is(3));
        assertThat(aSet, hasItems(
                new AbstractMap.SimpleEntry("a", "1"),
                new AbstractMap.SimpleEntry("ab", "10"),
                new AbstractMap.SimpleEntry("abc", "100")
        ));
    }
    @Test(timeout = 1000)
    public void findByPrefixTest2() {
        tree.put("a", "1");
        tree.put("ab", "10");
        tree.put("abc", "100");
        tree.put("b", "2");
        tree.put("bc", "20");
        tree.put("baa", "20");

        assertThat(tree.findByPrefix("a").size(), is(3));
        assertThat(tree.findByPrefix("ab").size(), is(2));
        assertThat(tree.findByPrefix("abc").size(), is(1));
        assertThat(tree.findByPrefix("abcd").size(), is(0));
        assertThat(tree.findByPrefix("c").size(), is(0));

    }

}
