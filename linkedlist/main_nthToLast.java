package com.company;

public class Main {

    public static void main(String[] args) {

        Node<Integer> head = new Node<>(1);

        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(5);
        head.appendToTail(6);
        head.appendToTail(7);
        head.appendToTail(8);

        System.out.println(Node.nthToLastNonRecursive(head, 2).getValue());
        IntegerWrapper intVar = new IntegerWrapper();
        System.out.println(Node.nthToLastRecursive(head, 2, intVar).getValue());

    }
}

