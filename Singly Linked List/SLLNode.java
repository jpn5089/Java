public class SLLNode<T> {
  T info;
  SLLNode<T> next;
  public SLLNode() {
    next = null;
  }
  public SLLNode (T t) {
    this(t, null);
    //info = t;
    //next = null;
  }
  public SLLNode(T t, SLLNode<T> p) {
    info = t;
    next = p;
  }

}
  