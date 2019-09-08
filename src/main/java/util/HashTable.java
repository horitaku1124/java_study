package util;


public class HashTable<K, V> {
  static class TableNode<K, V> {
    TableNode<K, V> next;
    K key;
    V value;

    TableNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
  private TableNode<K, V>[] valueTable;
  private static final int HashSize = 1024;
  private int size;
  public HashTable() {
    valueTable = new TableNode[HashSize];
    size = 0;
  }

  private int hash(K key) {
    return key.hashCode() % HashSize;
  }

  private TableNode<K, V> findNode(K key) {
    int hash = hash(key);
    TableNode<K, V> current = valueTable[hash];
    if (current == null) {
      return null;
    }
    while (true) {
      if (current.key.equals(key)) {
        return current;
      }
      if (current.next == null) {
        break;
      }
      current = current.next;
    }
    return null;
  }

  /**
   *
   * <ul>
   *     <li>100  :  766us</li>
   *     <li>500  :  448us</li>
   *     <li>1k   :  1.1ms</li>
   *     <li>5k   :  2.2ms</li>
   *     <li>10k  :   17ms</li>
   *     <li>50k  :  2.5ms</li>
   *     <li>100k :   52ms</li>
   *     <li>500k :   6.8s</li>
   * </ul>
   * <p>O(N^2)</p>
   *
   * @param key key of value to store
   * @param value value to store
   */
  public void put(K key, V value) {
    int hash = hash(key);
    if (valueTable[hash] == null) {
      valueTable[hash] = new TableNode<>(key, value);
      size++;
      return;
    }
    TableNode current = valueTable[hash];
    while (true) {
      if (current.key.equals(key)) {
        current.value = value;
        return;
      }
      if (current.next == null) {
        break;
      }
      current = current.next;
    }
    size++;
    current.next = new TableNode<>(key, value);
  }

  public V get(K key) {
    TableNode<K, V> current = findNode(key);
    if (current == null) {
      return null;
    }
    return current.value;
  }

  public int size() {
    return this.size;
  }

  public boolean containsKey(K key) {
    return findNode(key) != null;
  }
}
