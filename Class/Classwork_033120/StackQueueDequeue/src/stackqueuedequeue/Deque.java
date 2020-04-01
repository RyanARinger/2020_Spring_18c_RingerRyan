package stackqueuedequeue;

import java.util.LinkedList;

public class Deque {
    private LinkedList<Integer> data;
    
    public Deque(){
        this.data = new LinkedList();
    }
    
    public void addFirst(Integer d){
        this.data.addFirst(d);
    }
    public void addLast(Integer d){
        this.data.addLast(d);
    }
    public int removeFirst(){
        int itr = 0;
        Integer d = this.data.get(itr);
        this.data.remove(itr);
        return d;
        
    }
    public int removeLast(){
        int itr = this.data.size();
        Integer d = this.data.get(itr);
        this.data.remove(itr);
        return d;
    }
}
