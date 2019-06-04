package trie;

import java.util.*;
import java.util.stream.Collectors;

abstract public class StringKeyTrie<V> extends TrieTree<String, V> {
    static class Node<V> {
        char nextKey;
        V value;
        ArrayList<Node<V>> list = new ArrayList<>();
    }
    protected Node<V> rootNode;


    private void findKeys(Stack<Character> keyStack, Node<V> node, Set<String> keys) {
        keyStack.push(node.nextKey);
        if (node.value != null) {
            String key1 = keyStack.stream().map(String::valueOf).collect(Collectors.joining(""));
            keys.add(key1);
        }
        for (Node<V> child: node.list) {
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
    public boolean containsKey(Object key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        if (key instanceof String) {
            String key1 = (String)key;

            Node<V> current = rootNode;
            for (int i = 0;i < key1.length();i++) {
                char c = key1.charAt(i);

                boolean childFound = false;
                for (Node<V> child: current.list) {
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
    public V put(String key, V value) {
        Node<V> current = rootNode;
        boolean keyCreated = false;
        for (int i = 0;i < key.length();i++) {
            char c = key.charAt(i);

            boolean found = false;
            for (Node<V> child: current.list) {
                if (child.nextKey == c) {
                    current = child;
                    found = true;
                    break;
                }
            }
            if (!found) {
                Node<V> newNode = new Node<>();
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
    public V remove(Object key) {
        if (key instanceof String) {
            String key1 = (String)key;

            Node<V> current = rootNode;
            for (int i = 0;i < key1.length();i++) {
                char c = key1.charAt(i);

                boolean childFound = false;
                for (Node<V> child: current.list) {
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
            V value = current.value;
            current.value = null;
            size--;
            return value;
        } else {
            return null;
        }
    }
}
