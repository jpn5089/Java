class BST<T extends Comparable<? super T>> {
  BSTNode<T> root = null;
  BST() {
  }
  public void insert(T t) {
    BSTNode<T> p = root, prev = null;
    while (p != null) {
      prev = p;
      if (t.compareTo(p.el) < 0)
        p = p.left;
      else p = p.right;
    }
    if (root == null)
      root = new BSTNode<T>(t);
    else if (t.compareTo(prev.el) < 0)
      prev.left = new BSTNode<T>(t);
    else prev.right = new BSTNode<T>(t);
  }
  
  public T search(T t) {
    BSTNode<T> p = root;
    while (p != null) {
      //if (t.equals(p.el))
      if (t.compareTo(p.el) == 0)
        return p.el; //p refers to node so need p.el to refer to element part of it
      else if (t.compareTo(p.el) < 0)
        p = p.left;
      else p = p.right;
    }
    return null;
  }  
  
  public void print() {
    print(root, 0);
  }
  
  protected void print(BSTNode<T> p, int depth) {
    if (p != null) {
      print(p.right, depth + 1);
      for (int i = 1; i <= depth; i++) 
        System.out.print("   ");
      System.out.println(p.el);
      print(p.left,depth+1);       
    }
  }
  
  public void inorder() {
    inorder(root);
  }
  
  protected void inorder(BSTNode<T> p) {
    if (p != null) {
      inorder(p.left);
      System.out.print(p.el + " ");
      inorder(p.right);
    }
  }
}
