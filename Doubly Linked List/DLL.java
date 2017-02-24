public class DLL<T> {
  DLLNode<T> head = null, tail = null;
  public void insertAtHead(T t) {
    head = new DLLNode<T>(t, head);
    if (head.next == null) 
      tail = head;
    else head.next.prev = head;
  }
  public void print() {
    for (DLLNode<T> p = head; p != null; p = p.next)
      System.out.print(p.info + " ");
    System.out.println();
  }
  public T deleteFromTail() {
    if (head == null)
      return null;
    T t = tail.info;
    tail = tail.prev;
    if (tail == null) 
      head = null;
    else tail.next = null;
    return t;
  }
}