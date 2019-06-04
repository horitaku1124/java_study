package trie;

import java.util.*;

abstract public class TrieTree<K, V> implements Map<K, V> {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Collection<V> values() {
        Set<K> keySets = keySet();
        List<V> values = new ArrayList<>();
        for (K key: keySets) {
            values.add(get(key));
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<K> keySets = keySet();
        Set<Entry<K, V>> sets = new HashSet<>();
        for (K key: keySets) {
            sets.add(new AbstractMap.SimpleEntry<>(key, get(key)));
        }
        return sets;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends Entry<? extends K, ? extends V>> entries = m.entrySet();
        for (Entry<? extends K, ? extends V> entry: entries) {
            K key = entry.getKey();
            V value = entry.getValue();
            put(key, value);
        }
    }
}
