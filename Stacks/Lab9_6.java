class Lab9_6 {
    <T> void printStack(Stack<T> s) {
        Stack<T> t = new Stack<>();
        while (!s.isEmpty()) {
            t.push(s.pop());
            System.out.print(t.topEl() + " ");
        }
        System.out.println();   
        while (!t.isEmpty()) 
            s.push(t.pop());
    }
        
    public static void main(String[] arg) {
        //Stack<int> s = new Stack<>();
        Stack<Integer> s = new Stack<>();
        System.out.println(s);
        s.push(10);
        System.out.println(s);        
        s.push(20);
        System.out.println(s);        
        s.push(30);
        System.out.println(s); 
        
        Lab9_6 lab = new Lab9_6();
        lab.printStack(s);
        System.out.println(s); 
                
        System.out.println(s.pop() + "| " + s); 
        System.out.println(s.pop() + "| " + s);
        System.out.println(s.pop() + "| " + s);
        System.out.println(s.pop() + "| " + s);        
    }
}