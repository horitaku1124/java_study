package util;

public class ObjectArrayList<R> {
  private static final int DefaultCapacity = 5;
  private Object[] internal;
  private int size;
  private int capacity;
  public ObjectArrayList(int n) {
    capacity = n;
    internal = new Object[capacity];
  }
  public ObjectArrayList() {
    this(DefaultCapacity);
  }

  /**
   *
   * <ul>
   *     <li>100  :  560us</li>
   *     <li>500  :   58us</li>
   *     <li>1k   :   68us</li>
   *     <li>5k   :  345us</li>
   *     <li>10k  :  485us</li>
   *     <li>50k  :  2.5ms</li>
   *     <li>100k :  3.1ms</li>
   *     <li>100k :   28ms</li>
   * </ul>
   * <p>O(N)</p>
   *
   * @param v value to store
   */
  public void add(R v) {
    if (size == capacity) {
      int cap = capacity * 2;
      Object[] newInternal = new Object[cap];
      if (size >= 0) {
        System.arraycopy(internal, 0, newInternal, 0, size);
      }
      internal = newInternal;
      capacity = cap;
    }
    internal[size++] = v;
  }

  public R get(int i) {
    return (R) internal[i];
  }
  public int size() {
    return size;
  }
  public void set(int i, R value) {
    internal[i] = value;
  }
  public boolean contains(R key) {
    for(int i = 0;i < size;i++) {
      if (internal[i].equals(key)) {
        return true;
      }
    }
    return false;
  }

  public void clear() {
    size = 0;
    capacity = DefaultCapacity;
    internal = new Object[DefaultCapacity];
  }
}
