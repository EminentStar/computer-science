package com.company;

/**
 * Created by junkyu on 2017. 3. 25..
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode root){
        this.root = root;
    }

    public BinaryTreeNode getRoot(){
        return this.root;
    }

    public void setRoot(BinaryTreeNode root){
        this.root = root;
    }

    public void add(BinaryTreeNode parent, BinaryTreeNode child, int direction){
        if(direction == 0) { // the child's location is left.
            parent.setLeftChild(child);
        }else{
            parent.setRightChild(child);
        }
    }

    public void inOrderTraversal(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            inOrderTraversal(node.getLeftChild());
        }
        System.out.println(node.getValue());

        if(node.getRightChild() != null){
            inOrderTraversal(node.getRightChild());
        }
    }

    public void preOrderTraversal(BinaryTreeNode node) {
        System.out.println(node.getValue());
        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    public void postOrderTraversal(BinaryTreeNode node){
        if(node.getLeftChild() != null){
            postOrderTraversal(node.getLeftChild());
        }

        if(node.getRightChild() != null){
            postOrderTraversal(node.getRightChild());
        }

        System.out.println(node.getValue());
    }

}

class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }
    public void setRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}


