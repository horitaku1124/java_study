import org.junit.Before;
import org.junit.Test;
import trie.StringToStringTrie;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StringTrieTest1 {
    private Map<String, String> tree;

    @Before
    public void setup() {
        tree = new StringToStringTrie();
    }

    @Test(timeout = 1000)
    public void functionTest1() {
        tree.put("1", "a");
        assertTrue(tree.containsKey("1"));
        assertThat(tree.size(), is(1));
        assertThat(tree.get("1"), is("a"));
    }

    @SuppressWarnings("OverwrittenKey")
    @Test(timeout = 1000)
    public void keyDuplicatedTest1() {
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
        tree.put("1", "a");
        tree.put("2", "b");
        assertThat(tree.size(), is(2));
        Set<Map.Entry<String, String>> entries = tree.entrySet();
        assertThat(entries.size(), is(2));
        assertTrue(entries.contains(new AbstractMap.SimpleEntry<>("1", "a")));
        assertTrue(entries.contains(new AbstractMap.SimpleEntry<>("2", "b")));
    }

    @Test(timeout = 1000)
    public void multiLengthTest1() {
        tree.put("1", "a");
        tree.put("11", "b");
        tree.put("1111", "c");
        assertThat(tree.size(), is(3));
        assertThat(tree.get("1"), is("a"));
        assertThat(tree.get("11"), is("b"));
        assertThat(tree.get("1111"), is("c"));
        Set<String> keys = tree.keySet();
        assertThat(keys.size(), is(3));
        assertThat(keys, hasItems("1", "11", "1111"));
    }

    @Test(timeout = 1000)
    public void multiByteTest1() {
        tree.put("あ", "a");
        tree.put("い", "b");
        tree.put("あいう", "c");
        assertThat(tree.size(), is(3));
        assertThat(tree.get("あ"), is("a"));
        assertThat(tree.get("い"), is("b"));
        assertThat(tree.get("あいう"), is("c"));
        Set<String> keys = tree.keySet();
        assertThat(keys.size(), is(3));
        assertThat(keys, hasItems("あ", "い", "あいう"));
    }

    @Test(timeout = 1000)
    public void removeTest() {
        tree.put("あ", "a");
        tree.put("い", "b");
        tree.put("a", "c");
        tree.put("abc", "ABC");
        assertThat(tree.size(), is(4));
        tree.remove("a");
        assertThat(tree.size(), is(3));
        assertThat(tree.containsKey("a"), is( false));
    }
}
