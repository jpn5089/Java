import java.util.ArrayList; 
public class Stack<T> {
    // T pool = new T[100];
    private ArrayList<T> pool = new ArrayList<T>();
    public void push (T t) {
        pool.add(t);
    }
    public T pop() {
        if (isEmpty())
            return null;
        return pool.remove(pool.size()-1);
    }    
    public T topEl() {
        return pool.get(pool.size()-1);
    }
    public boolean isEmpty() {
        return pool.size() == 0;
    }
    public void clear() {
        pool.clear();
    }
    public String toString() {
        return pool.toString();
    }
}
