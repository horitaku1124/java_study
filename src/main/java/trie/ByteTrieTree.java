package trie;

import java.util.*;
import java.util.stream.Collectors;

public class ByteTrieTree extends TrieTree<String, String> {
    static class Node {
        byte nextKey;
        String value;
        ArrayList<Node> list = new ArrayList<>();
    }

    private Node rootNode;
    public ByteTrieTree() {
        rootNode = new Node();
        size = 0;
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

        byte[] keyByte = key.getBytes();
        for (int i = 0;i < keyByte.length;i++) {
            byte c = keyByte[i];

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
    public void clear() {
        rootNode = new Node();
        size = 0;
    }

    private void findKeys(Stack<Byte> keyStack, Node node, Set<String> keys) {
        if (node.value != null) {
            keyStack.push(node.nextKey);
            String key1 = keyStack.stream().map(b -> new String(new byte[]{b})).collect(Collectors.joining(""));
            keys.add(key1);
        }
        for (Node child: node.list) {
            findKeys(keyStack, child, keys);
        }
        if (node.value != null) {
            keyStack.pop();
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        Stack<Byte> keyStack = new Stack<>();
        findKeys(keyStack, rootNode, keys);
        return keys;
    }
}
