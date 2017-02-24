class Lab9_8 {
  public static void main(String[] a) {
    SLL<Integer> sll = new SLL<>();
    sll.print();
    sll.insertAtHead(10);
    sll.print();
    sll.insertAtHead(20);
    sll.print();
    sll.insertAtHead(30);
    sll.print();
    
    SLL<Integer> sll2 = new SLL<>();
    sll2.insertAtTail(40);
    sll2.print();
    sll2.insertAtTail(50);
    sll2.print();
    sll2.insertAtTail(60);
    sll2.print();
    
    System.out.print(sll.deleteFromHead() + "| ");
    sll.print();
    System.out.print(sll.deleteFromHead() + "| ");
    sll.print();
    System.out.print(sll.deleteFromHead() + "| ");
    sll.print();
    System.out.print(sll.deleteFromHead() + "| ");
    sll.print();
    
    System.out.print(sll2.deleteFromTail() + "| ");
    sll2.print();
    System.out.print(sll2.deleteFromTail() + "| ");
    sll2.print();
    System.out.print(sll2.deleteFromTail() + "| ");
    sll2.print();
    System.out.print(sll2.deleteFromTail() + "| ");
    sll2.print();
    
  }
  
}
