package com.company;

public class Main {

    public static void main(String[] args) {
        StackQueue<Integer> sq = new StackQueue<>(1);
        sq.insert(2);
        sq.insert(3);
        sq.insert(4);
        sq.insert(5);
        sq.insert(6);


        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        sq.insert(7);
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        sq.insert(8);
        System.out.println(sq.remove());


        System.out.println("--------------------------------------");

        sq.insert(1);
        sq.insert(2);
        sq.insert(3);
        sq.insert(4);
        sq.insert(5);
        sq.insert(6);

        sq.shiftToNew();

        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        sq.insert(7);
        System.out.println(sq.remove());
        sq.insert(8);
        System.out.println(sq.remove());



        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
        System.out.println(sq.remove());
    }
}

