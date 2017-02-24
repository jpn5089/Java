public class DLLNode<T> {
  public T info; //field
  public DLLNode<T> next, prev; //field
  public DLLNode(T t, DLLNode<T> n, DLLNode<T> p) { //4 constructors
    info = t;
    next = n;
    prev = p;    
  }
  public DLLNode(T t, DLLNode<T> n) {
    this(t, n, null);    
  }
  
  public DLLNode(T t) {
    this(t, null, null);
  }
  
  public DLLNode() {
    this(null, null, null);
  }
}