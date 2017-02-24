class Lab9_29 {
  public static void main(String[] a) {
    BST<Integer> bst = new BST<>();
    bst.insert(10);
    bst.insert(20);
    bst.insert(15);
    bst.insert(7);
    bst.insert(9);
    bst.print();
    System.out.println("");
    System.out.println(bst.search(20));
    System.out.println(bst.search(21));
    bst.inorder();
  }
}
  