import org.junit.Test;
import trie.StringTrieTree;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrieTest1 {
    @Test(timeout = 1000)
    public void Test1() {
        StringTrieTree tree = new StringTrieTree();
        tree.put("1", "a");
        assertTrue(tree.containsKey("1"));
        assertThat(tree.size(), is(1));
        assertThat(tree.get("1"), is("a"));
    }
    @Test(timeout = 1000)
    public void Test2() {
        StringTrieTree tree = new StringTrieTree();
        tree.put("1", "a");
        tree.put("2", "b");
        tree.put("2", "c");
        assertThat(tree.size(), is(2));
        assertThat(tree.get("1"), is("a"));
        assertThat(tree.get("2"), is("c"));
        assertTrue(tree.containsKey("1"));
        assertTrue(tree.containsKey("2"));
        assertFalse(tree.containsKey("3"));
    }
}
