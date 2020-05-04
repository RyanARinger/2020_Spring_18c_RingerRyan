/*
 * Author:      Ryan Ringer
 * Created on:  April 11th, 2020
 * File:        MyStack.java
 * Purpose:     Stack implementation
 */

package javastack;

import java.util.ArrayList;

public class MyStack<T> implements IStack{
    
    private ArrayList<T> data;
    
    
    public MyStack(){
        this.data = new ArrayList();
    }

    @Override
    public void push(Object element) {
        this.data.add(0, (T)element);
    }
    
    @Override
    public T pop() {
        T ticker = null;
        if(this.data.size() > 0){
            ticker = this.data.get(0);
            this.data.remove(0);
        }        
        return ticker;
    }

    @Override
    public T top() {
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
