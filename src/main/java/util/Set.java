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
     *     <li>100  :  1.3ms  :   13us/N</li>
     *     <li>200  :  503us  :  2.5us/N</li>
     *     <li>500  :  922us  :  1.8us/N</li>
     *     <li>1k   :  3.9ms  :  3.9us/N</li>
     *     <li>2k   :  4.9ms  :  2.4us/N</li>
     *     <li>5k   :   32ms  :  3.9us/N</li>
     *     <li>10k  :  125ms  :   12us/N</li>
     *     <li>50k  :   3.1s  :   62us/N</li>
     * </ul>
     * <p>O(N)</p>
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
