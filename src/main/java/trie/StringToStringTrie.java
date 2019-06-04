package trie;


public class StringToStringTrie extends StringKeyTrie<String> {
    public StringToStringTrie() {
        clear();
    }

    @Override
    public void clear() {
        rootNode = new Node<>();
        size = 0;
    }
}
