package stackqueuedequeue;

import java.util.ArrayList;


public class Stack<T> {
    private ArrayList<T> data;
    
    public Stack(){
        this.data = new ArrayList();
    }
    
    public void push(T d){
        this.data.add(d);
    }
    
    public T pop(){
        T v = this.data.get(this.data.size()-1);
        this.data.remove(this.data.size()-1);
        return v;
    }
}
