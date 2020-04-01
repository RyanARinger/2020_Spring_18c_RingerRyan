package stackqueuedequeue;

import java.util.LinkedList;


public class Queue<T> {
    private LinkedList<T> data;
    
    public Queue(){
        this.data = new LinkedList();
    }
    
    public void enqueue(T d){
        this.data.add(d);
    }
    
    public T dequeue(){
        int itr = 0;
        T d = this.data.get(itr);
        this.data.remove(itr);
        return d;
    }
}
