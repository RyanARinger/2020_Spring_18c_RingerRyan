/*
 * Author:      Ryan Ringer
 * Created on:  April 11th, 2020
 * File:        MyQueue.java
 * Purpose:     Queue Implementation
 */

package javaqueue;

import java.util.ArrayList;

public class MyQueue<T> implements IQueue{

    private ArrayList<T> data;
    
    public MyQueue(){
        this.data = new ArrayList();
    }
    
    @Override
    public void enqueue(Object element) {
        this.data.add((T)element);
    }

    @Override
    public T dequeue() {
        T ticker = null;
        if(this.data.size() > 0){
            ticker = this.data.get(0);
            this.data.remove(0);
        }
        return ticker;
    }

    @Override
    public T first() {
        if(this.data.size() > 0){
            return this.data.get(0);
        }
        return null;
    }

    @Override
    public Integer size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        if(this.data.size() == 0){
            return true;
        }
        return false;
    }
    
    
}
