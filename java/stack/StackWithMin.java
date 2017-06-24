package com.company;

/**
 * Created by junkyu on 2017. 3. 23..
 */
/*
* 내가 풀었던 방식(rescanMin())으로 하면 min이 스택에서 제거될 때 스택을 뒤져 새로운 최솟값을 찾는다
* 이렇게하면 push와 pop 연산이 O(1)시간에 수행되어야 한다는 제약조건이 깨지게 된다.
* */
/*
* min 값들을 추적하는 스택을 하나 더 둬서 메모리 낭비를 줄이면서 시간복잡도도 O(1)로 맞출 수 있음
*
* */
public class StackWithMin{
    private Node<Integer> top;
    private Stack<Integer> minStack;

    public StackWithMin(){
        minStack = new Stack<Integer>();
    }

    Object push(int value){
        Node<Integer> n = new Node<Integer>(value);

        if(this.top== null){
            this.top = n;
            this.minStack.push(value);
            return this.top;
        }

        n.setNext(this.top);
        if(this.min() > value){
            this.minStack.push(value);
        }
        this.top = n;

        return this.top;
    }

    Object pop(){
        if(this.top != null){
            Object item = this.top.getValue();
            this.top = this.top.getNext();
            if(min() == (int)item){
                minStack.pop();
            }
            return item;
        }

        return null;
    }

    Object top(){
        if(this.top != null){
            return this.top.getValue();
        }else{
            return null;
        }
    }

    int min(){
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return minStack.top();
        }
    }

    boolean isEmpty(){
        return (this.top == null)?true:false;
    }
}

