import org.junit.Test;
import trie.StringTrieTree;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrieTest1 {
    @Test(timeout = 1000)
    public void functionTest1() {
        StringTrieTree tree = new StringTrieTree();
        tree.put("1", "a");
        assertTrue(tree.containsKey("1"));
        assertThat(tree.size(), is(1));
        assertThat(tree.get("1"), is("a"));
    }
    @SuppressWarnings("OverwrittenKey")
    @Test(timeout = 1000)
    public void keyDuplicatedTest1() {
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
    @Test(timeout = 1000)
    public void returnsKeySetTest1() {
        StringTrieTree tree = new StringTrieTree();
        tree.put("1", "a");
        tree.put("2", "b");
        assertThat(tree.size(), is(2));
        Set<String> strings = tree.keySet();
        assertThat(strings.size(), is(2));
        assertTrue(strings.contains("1"));
        assertTrue(strings.contains("2"));
    }
    @Test(timeout = 1000)
    public void returnsValuesTest1() {
        StringTrieTree tree = new StringTrieTree();
        tree.put("1", "a");
        tree.put("2", "b");
        assertThat(tree.size(), is(2));
        Collection<String> values = tree.values();
        assertThat(values.size(), is(2));
        assertTrue(values.contains("a"));
        assertTrue(values.contains("b"));
    }
    @Test(timeout = 1000)
    public void returnsEntrySetTest1() {
        StringTrieTree tree = new StringTrieTree();
        tree.put("1", "a");
        tree.put("2", "b");
        assertThat(tree.size(), is(2));
        Set<Map.Entry<String, String>> entries = tree.entrySet();
        assertThat(entries.size(), is(2));
        assertTrue(entries.contains(new AbstractMap.SimpleEntry<>("1", "a")));
        assertTrue(entries.contains(new AbstractMap.SimpleEntry<>("2", "b")));
    }
}
