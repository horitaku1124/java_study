package trie;

import java.util.*;
import java.util.stream.Collectors;

public class StringTrieTree extends TrieTree<String, String> {
    private int size;
    static class Node {
        char nextKey;
        String value;
        ArrayList<Node> list = new ArrayList<>();
    }

    private Node rootNode;
    public StringTrieTree() {
        rootNode = new Node();
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public String get(Object key) {
        if (key instanceof String) {
            String key1 = (String)key;

            Node current = rootNode;
            for (int i = 0;i < key1.length();i++) {
                char c = key1.charAt(i);

                boolean childFound = false;
                for (Node child: current.list) {
                    if (child.nextKey == c) {
                        current = child;
                        childFound = true;
                        break;
                    }
                }
                if (!childFound) {
                    return null;
                }
            }
            return current.value;
        } else {
            return null;
        }
    }

    @Override
    public String put(String key, String value) {
        Node current = rootNode;
        boolean keyCreated = false;
        for (int i = 0;i < key.length();i++) {
            char c = key.charAt(i);

            boolean found = false;
            for (Node child: current.list) {
                if (child.nextKey == c) {
                    current = child;
                    found = true;
                    break;
                }
            }
            if (!found) {
                Node newNode = new Node();
                newNode.nextKey = c;
                current.list.add(newNode);
                current = newNode;
                keyCreated = true;
            }
        }
        current.value = value;

        if (keyCreated) {
            size++;
        }
        return null;
    }

    @Override
    public String remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {

    }

    @Override
    public void clear() {
        rootNode = new Node();
        size = 0;
    }

    private void findKeys(Stack<Character> keyStack, Node node, Set<String> keys) {
        keyStack.push(node.nextKey);
        if (node.value != null) {
            String key1 = keyStack.stream().map(String::valueOf).collect(Collectors.joining(""));
            keys.add(key1);
        }
        for (Node child: node.list) {
            findKeys(keyStack, child, keys);
        }
        keyStack.pop();
    }

    @Override
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        Stack<Character> keyStack = new Stack<>();
        rootNode.list.forEach(node -> {
            findKeys(keyStack, node, keys);
        });
        return keys;
    }

    @Override
    public Collection<String> values() {
        Set<String> keySets =  keySet();
        List<String> values = new ArrayList<>();
        for (String key: keySets) {
            values.add(get(key));
        }
        return values;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        Set<String> keySets = keySet();
        Set<Entry<String, String>> sets = new HashSet<>();
        for (String key: keySets) {
            sets.add(new AbstractMap.SimpleEntry<>(key, get(key)));
        }
        return sets;
    }
}
