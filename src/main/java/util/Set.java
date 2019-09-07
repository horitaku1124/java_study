package util;

public class Set<V> {
    class SetNode {
        public SetNode next;
        public V value;

        public SetNode(V value) {
            this.value = value;
        }
    }
    private SetNode start = null;
    private SetNode last = null;
    private int _size = 0;


    private SetNode findNode(V value) {
        SetNode current = start;

        while (current != null) {
            if (value.equals(current.value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public int size() {
        return this._size;
    }

    public boolean contains(V value) {
        return findNode(value) != null;
    }

    /**
     * <ul>
     *     <li>100  :  976us</li>
     *     <li>200  :  406us</li>
     *     <li>500  :  1.5ms</li>
     *     <li>1k   :  4.3ms</li>
     *     <li>2k   :  4.6ms</li>
     *     <li>5k   :   28ms</li>
     * </ul>
     * @param value value to store
     */
    public void add(V value) {
        SetNode exists = findNode(value);
        if (exists != null) {
            exists.value = value;
            return;
        }
        if (start == null) {
            start = new SetNode(value);
            last = start;
        } else {
            last.next = new SetNode(value);
            last = last.next;
            last.value = value;
        }
        _size++;
    }
}
