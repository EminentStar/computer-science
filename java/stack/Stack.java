package com.company;

/**
 * Created by junkyu on 2017. 3. 23..
 */
public class Stack<T> {
    Node<T> top;

    Object push(T value){
        Node<T> n = new Node<T>(value);

        if(this.top== null){
            this.top = n;
            return this.top;
        }

        n.setNext(this.top);
        this.top = n;

        return this.top;
    }

    Object pop(){
        if(this.top != null){
            Object item = this.top.getValue();
            this.top = this.top.getNext();
            return item;
        }

        return null;
    }

    T top(){
        if(this.top != null){
            return this.top.getValue();
        }else{
            return null;
        }
    }

    boolean isEmpty(){
        return (this.top == null)?true:false;
    }
}

