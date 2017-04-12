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

    public static Node nthToLastNonRecursive(Node head, int index){
        /*Non Recursive*/
        Node curNode = head;
        int length = 0;
        int valueIndex = 0;

        while(curNode != null){
            length++;
            curNode = curNode.getNext();
        }

        curNode = head;
        valueIndex = length - 1 - index;
        for(int i = 0 ; i < valueIndex; i++ ){
            curNode = curNode.getNext();
        }

        return curNode;

    }

    public static Node nthToLastRecursive(Node head, int index, IntegerWrapper indexVar){
        /* Recursive */
        if(head.getNext() == null){
            return null;
        }
        Node node = nthToLastRecursive(head.getNext(), index, indexVar);
        indexVar.setCount(indexVar.getCount() + 1);
        if(indexVar.getCount() == index){
            return head;
        }

        return node;
    }
}
class IntegerWrapper{
    private int count;

    public IntegerWrapper(){
        this.count = 0;
    }
    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
}

