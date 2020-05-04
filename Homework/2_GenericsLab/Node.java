/*
 * Author:      Ryan Ringer
 * Created on:  April 5th, 2020
 * File:        Node.java
 * Purpose:     Node definition
 */
package doublylinkedlist;


public class Node <T>{
    private T data;
    Node next;
    Node prev;
    
    // null constructor
    public Node(){
        this.data = null;
        this.next = null;
        this.prev = null; 
    }
    // general constructors
    public Node(Node p, Node n){ //without data
        this.data = null;
        this.prev = p;
        this.next = n;
    }
    public Node(T d, Node p, Node n){ //with data
        this.data = d;
        this.prev = p;
        this.next = n;
    }
    
    public void setData(T d){
        this.data = d;
    }
    public T getData(){
        return this.data;
    }
}
    
