package com.company;

/**
 * Created by junkyu on 2017. 3. 22..
 */

/*
* Single Linked List Node
* */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(){
    }

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public T getValue(){
       return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public Node getNext(){
        return this.next;
    }

    public void setNext(Node node){
        this.next = node;
    }

    public void appendToTail(T value){
       Node tail = new Node(value);
       Node n = this;

       while(n.next != null){
           n = n.next;
       }
       n.setNext(tail);
    }

    public Node deleteNode(Node head, T value){
        Node node = head;

        if(head.value == value){
            return head.next;
        }

        while(node.next != null){
            if(node.next.value == value){
                node.next = node.next.next;
                return head;
            }
            node = node.next;
        }

        return head;
    }
}

