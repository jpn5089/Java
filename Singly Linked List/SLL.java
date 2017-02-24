public class SLL<T> {
  protected SLLNode<T> head, tail;
  SLL() {
    head = tail = null;
  }
  
  public void insertAtHead(T t) {
    head = new SLLNode<T>(t,head);
    if (tail == null)
      tail = head;
  }
  public void insertAtTail(T t) {
    if (head == null)
      head = tail = new SLLNode<T>(t);
    else {
      tail.next = new SLLNode<T>(t);
      tail = tail.next;
      
    }
  }
  public T deleteFromHead() {
    if (head == null) //if list is empty; 
      return null;
    T t = head.info;
    head = head.next;
    if (head == null) // last and only node is being deleted;
      tail = null;
    return t;
  }
  
  public T deleteFromTail() {
    if (head == null) //if list is empty; 
      return null;
    T t = tail.info;
    if (head == tail) //if there is only one node;
      head = tail = null;
    else {
      SLLNode<T> p = head;
      for ( ; p.next.next != null; p = p.next)
        ;
      p.next = null;
      tail = p;      
    }
    return t;
  }
  
  public void print() {
    for (SLLNode<T> t = head; t != null; t = t.next)
      System.out.print(t.info + " ");
    System.out.println(); 
  }
  public boolean equal(SLL<T> lst) {
    SLLNode<T> t1 = head, t2 = lst.head;
    for ( ; t1 != null && t2 != null;
         t1 = t1.next, t2 = t2.next)
      if (!t1.info.equals(t2.info))
      return false;
    if (t1 == null & t2 == null)
      return true;
    return false;
    
  }
  
}
