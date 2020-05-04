/*
 * Author:      Ryan Ringer
 * Created on:  May 1, 2020
 * File:        Deck.java
 * Purpose:     Iterable Deck
 */

package pkg4_iterableslab;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Deck<T> implements Iterable<T>, List<T>{

    private class Node<T>{
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
        
        public DeckIterator(Deck d){
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
    Node<T> head;
    Node<T> tail;
    int numElements;
    
    public Deck(){
        this.numElements = 0;
    }
    @Override
    public Iterator<T> iterator(){
        return new DeckIterator<>(this);
    }
    
    @Override
    public int size() {
        return this.numElements;
    }

    @Override
    public boolean isEmpty() {
        if(this.numElements < 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        Node<T> n = new Node(e, null, null);
        if (this.head == null){
            this.head = n;
            this.tail = n;     
            return true;
        }
        else{
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        this.tail = null;
        this.head = this.tail;
    }

    @Override
    public T get(int i) {
        int c;
        Node<T> ticker;
        
        if(i >= this.size()){
            return this.tail.getData();
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
        
        return (T)ticker.getData();
    }

    @Override
    public T set(int i, T el) {
        int c;
        Node<T> ticker;
        
        if(i >= this.size()){
            this.tail.setData(el);
            return el;
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
        ticker.data = el;
        return el;
    }

    @Override
    public void add(int i, T el) {
        int c;
        Node<T> ticker;
        Node<T> n = new Node(el, null ,null);
        if(i >= this.size()){
            this.tail.next = n;
            this.tail.next.prev = this.tail;
            this.tail = this.tail.next;
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
        n.next = ticker;
        n.prev = ticker.prev;
        ticker.prev = n;        
    }

    @Override
    public T remove(int e) {
        Node<T> ticker;
        if(e > this.numElements){
        }
        if(e == 1 && this.numElements == 1){
            ticker = this.head;
            this.head = null;
            this.numElements--;
            return ticker.getData();
        }
        else if(e == 1){
            ticker = this.head;
            this.head.next.prev = null;
            this.head = this.head.next;
            this.numElements--;
            return ticker.getData();
        }
        else if(e == this.numElements){
            ticker = this.tail;
            this.tail = this.tail.prev;
            this.numElements--;
            return ticker.getData();
        }
        else if(e < (this.numElements/2)){
            ticker = this.head;
            for (int i = 1; i < e; i++) {
                ticker = ticker.next;
            }
            ticker.prev.next = ticker.next;
            ticker.next.prev = ticker.prev;
            this.numElements--;
            return ticker.getData();
        }
        else{
            ticker = this.tail;
            for (int i = this.numElements; i > e; i--) {
                ticker = ticker.prev;
            }
            ticker.prev.next = ticker.next;
            ticker.next.prev = ticker.prev;
            this.numElements--;
            return ticker.getData();
        }
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}