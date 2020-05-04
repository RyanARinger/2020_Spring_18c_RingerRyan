/*
 * Author:      Ryan Ringer
 * Created on:  May 4th, 2020
 * File:        Deck2.java
 * Purpose:     Iterable Linked List WITHOUT List ADT
 */

package pkg4_iterableslab;

import java.util.Iterator;

public class Deck2<T> implements Iterable<T>{
    public class Node<T>{
        private T data;
        Node next;
        Node prev;
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
    private class DeckIterator<T> implements Iterator<T>{
        Node<T> place;
        
        public DeckIterator(Deck2 d){
            this.place = d.head;
        }
        
        @Override
        public boolean hasNext(){
            if(this.place.next != null){
                return true;
            }
            return false;
        }
        
        @Override
        public T next(){
            T el = this.place.getData();
            this.place = this.place.next;
            return el;
        }
    }
    
    Node head;
    Node tail;
    private int numNodes;
    
    public Deck2(){
        this.numNodes = 0;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new DeckIterator(this);
    }
    /**
     * Searches the list for a location using the Node object parameter's
     * 'data' field
     * 
     * @param n Node object to search for
     * @return integer location of element in list. 0 if object isn't found
     * within the list at the time of calling, and a -1 of the list is empty.
     */
    public int search(Node n){
        boolean done = false;
        int loc = 0;
        int c = 1;
        Node ticker = this.head;
        if(this.numNodes == 0){
            return -1;
        }
        while(ticker != null && !done){
            if(ticker.getData().equals(n.getData())){
                loc = c;
                done = true;
            }
            ticker = ticker.next;
            c++;
        }
        return loc;
    }
    
    /**
     * Takes a Node object 'n' and places it into the list at a given provided
     * location 'l,' or places it at the end, assuming that the given location
     * is larger than the size of the list at the time of calling.
     * 
     * @param el
     * @param l An integer that declares the desired location in list 
     * for the given Node object. May be overwritten if given location
     * exceeds list size.
     */
    public void add(T el, int l){
        int c = 1;
        Node<T> ticker = this.head;
//        Node<T> n = new Node(el, null, null);
        if(this.numNodes == 0){
            this.head = new Node(el, null, null);
            this.tail = this.head;
            this.numNodes++;
        }
        else if(l <= 1){
            this.head.prev = new Node(el, null, head);
            this.head = this.head.prev;
//            this.head.prev = n;
//            n.next = this.head;
//            this.head = n;
            this.numNodes++;
        }
        else if(this.numNodes < l){
            this.tail.next = new Node(el, this.tail, null);
            this.tail = this.tail.next;
            this.numNodes++;
        }
        else{
            while(c < l){
                ticker = ticker.next;
                c++;
            }
            ticker.prev = new Node(el, ticker.prev, ticker);
            ticker.prev.prev.next = ticker.prev;
//            ticker.prev.next = n;
//            n.prev = ticker.prev;
//            n.next = ticker;
//            ticker.prev = n;

//            ticker.next.prev = n;
//            n.next = ticker.next;
//            n.prev = ticker;
//            ticker.next = n;
            this.numNodes++;
        }
    }
    
    /**
     * Removes an element from the list by a Node object reference. Returns a 
     * boolean value determined by successful removal.
     * 
     * @param n Node object to search
     * 
     * @return True if reference was found and removed.
     * False if reference could not be found in the list. 
     */
    public boolean remove(Node n){
        Node ticker = this.head;
        if(this.head.getData() == null){
            return false;
        }
        if(this.head.getData().equals(n.getData())){
            
            this.head.next.prev = null;
            this.head = this.head.next;
            this.numNodes--;
        }
        else{
            
            while(ticker != null && !ticker.getData().equals(n.getData())){
                ticker = ticker.next;
            }
            if(ticker == null){
                return false;
            }
            else{
                ticker.prev.next = ticker.next;
                ticker.next.prev = ticker.prev;
                this.numNodes--;
            }
        }
        return true;
    }
    
    /**
     * Removes an element from the list using an index. Returns a boolean
     * value determined by successful removal.
     * 
     * @param e Element index to be removed
     * @return True if reference was found and removed.
     * False if reference could not be found in the list.
     */
    public boolean remove(int e){
        Node ticker;
        if(e > this.numNodes){
            return false;
        }
        if(e == 1 && this.numNodes == 1){
            this.head = new Node(null, null, null);
            this.numNodes--;
        }
        else if(e == 1){
            this.head.next.prev = null;
            this.head = this.head.next;
            this.numNodes--;
        }
        else if(e == this.numNodes){
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.numNodes--;
        }
        else if(e < (this.numNodes/2)){
            ticker = this.head;
                    
            for (int i = 1; i < e; i++) {
                ticker = ticker.next;
            }
            ticker.prev.next = ticker.next;
            ticker.next.prev = ticker.prev;
            this.numNodes--;
        }
        else{
            ticker = this.tail;
            
            for (int i = this.numNodes; i > e; i--) {
                ticker = ticker.prev;
            }
            ticker.prev.next = ticker.next;
            ticker.next.prev = ticker.prev;
            this.numNodes--;
        }
        return true;
    }
    
    /**
     * Determines if the list is empty. Returns a boolean.
     * 
     * @return True if list is empty. False if List has at leat one node. 
     */
    public boolean isEmpty(){
        if(this.numNodes == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Returns the number of nodes in the list as an integer
     * 
     * @return The number of nodes as an integer. 
     */
    public int size(){
        return this.numNodes;
    }
    
    /**
     * Adds a Node object to the end of the List.
     * 
     * @param n Node object to be added to the end of the list
     */
    public void push_back(Node n){
        if(this.numNodes == 0){
            this.head = n;
            this.tail = this.head;
            this.numNodes++;
            
        }
        else{
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
            this.numNodes++;
        }
        
    }
    
    /**
     * Adds a Node object to the front of the list.
     * 
     * @param n Node object to be added to the front of the list. 
     */
    public void push_front(Node n){
        if(this.numNodes == 0){
            this.head = n;
            this.tail = this.head;
            this.numNodes++;
        }
        else{
            this.head.prev = n;
            n.next = this.head;
            this.head = n;
            this.numNodes++;
        }
    }
        
    /**
     * Prints list from head to tail.
     */
    public void printListDown(){
        Node ticker = this.head;
        if(this.numNodes == 0){
            System.out.println("List is Empty");
        }
        else{
            while(ticker != null){
                System.out.println(ticker.getData());
                ticker = ticker.next;
            }
        }
    }
    
    /**
     * Prints list from tail to head.
     */
    public void printListUp(){
        Node ticker = this.tail;
        if(this.numNodes == 0){
            System.out.println("List is Empty");
        }
        else{
            while(ticker != null){
            System.out.println(ticker.getData());
            ticker = ticker.prev;
        }
        }
    }
    
    
    public <T> void set(int i, T d){
        int c = 1;
        Node ticker;
    }
    
    /**
     * Returns a node from a desired location in the linked list.
     *  
     * @param i Index to retrieve from linked list.
     * @return Returns the node at index 'i'.
     */
    public Node get(int i){
        int c;
        Node ticker;
        
        if(i >= this.size()){
            return this.tail;
        }
        
        if(i<(this.size()/2)){
            ticker  = this.head;
            c = 1;
            
            while(c < i){
                ticker = ticker.next;
                c++;
           }
        }
        else{
            ticker = this.tail;
            c = this.size();
            
            while(c > i){
                ticker = ticker.prev;
                c--;
           }
        }
        
        return ticker;
    }
    
    /**
     * Clears the list. (The java way)
     * @return True if successful and false if unsuccessful.
     */
    public boolean destroyList(){
        if(this.numNodes != 0){
            this.head = new Node(null, null, null);
            this.tail = this.head;
            this.numNodes = 0;
        }
        return false;
    }
}
