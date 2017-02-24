class Lab9_15 {
  public static void main(String[] a) {
    DLL<Integer> dll = new DLL<Integer>();
    dll.insertAtHead(10);
    dll.print();    
    dll.insertAtHead(20);
    dll.print();
    dll.insertAtHead(30);
    dll.print();
    System.out.print(dll.deleteFromTail() + "| ");
    dll.print();
    System.out.print(dll.deleteFromTail() + "| ");
    dll.print();
    System.out.print(dll.deleteFromTail() + "| ");
    dll.print();
    System.out.print(dll.deleteFromTail() + "| ");
    dll.print();    
  }
}
    