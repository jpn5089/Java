class BSTNode<T extends Comparable<? super T>> {
  protected T el; 
  protected BSTNode<T> left, right;
  public BSTNode() { //zero argument constructor not created automatically if you have nonzero argument constructors
    left = right = null;
  }
  public BSTNode(T t) { //constructor
    this(t, null, null);
  }
  public BSTNode(T t, BSTNode<T> lt, BSTNode<T> rt) {
    el = t; 
    left = lt;
    right = rt;
  }
}
    