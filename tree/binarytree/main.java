package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        final int LEFT = 0;
        final int RIGHT = 1;

        BinaryTree<Integer> tree = new BinaryTree<>(new BinaryTreeNode(24));
        BinaryTreeNode<Integer> deptLeft1 = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> deptRight1 = new BinaryTreeNode<>(28);

        tree.add(tree.getRoot(), deptLeft1, LEFT);
        tree.add(tree.getRoot(), deptRight1, RIGHT);

        BinaryTreeNode<Integer> deptLeft2_1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> deptRight2_1 = new BinaryTreeNode<>(19);

        tree.add(deptLeft1, deptLeft2_1, LEFT);
        tree.add(deptLeft1, deptRight2_1, RIGHT);

        BinaryTreeNode<Integer> deptLeft2_2 = new BinaryTreeNode<>(27);
        BinaryTreeNode<Integer> deptRight2_2 = new BinaryTreeNode<>(30);


        tree.add(deptRight1, deptLeft2_2, LEFT);
        tree.add(deptRight1, deptRight2_2, RIGHT);

        System.out.println("In Order Traversal");
        tree.inOrderTraversal(tree.getRoot());

        System.out.println("Pre Order Traversal");
        tree.preOrderTraversal(tree.getRoot());

        System.out.println("Post Order Traversal");
        tree.postOrderTraversal(tree.getRoot());

/*
// print
In Order Traversal
2
15
19
24
27
28
30
Pre Order Traversal
24
15
2
19
28
27
30
Post Order Traversal
2
19
15
27
30
28
24
*/
    }
}

