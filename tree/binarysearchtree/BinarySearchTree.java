package com.company;

/**
 * Created by junkyu on 2017. 3. 26..
 */
public class BinarySearchTree {
    private BinarySearchTreeNode root;

    public BinarySearchTree(){
    }
    public BinarySearchTree(BinarySearchTreeNode n){
        this.root = n;
    }

    public boolean search(int value){
        BinarySearchTreeNode curNode = root;

        while(curNode != null){
            int curVal = curNode.getValue();
            if(curVal == value){
                return true;
            }else if(curVal < value){
                curNode = curNode.getLeftChild();
            }else{
                curNode = curNode.getRightChild();
            }
        }
        return false;
    }

    public boolean insert(int value){
        BinarySearchTreeNode curNode = root;

        while(curNode != null){
            int curVal = curNode.getValue();
            if(curVal == value){
                return false;
            }

            if(curVal < value){
                if(curNode.getLeftChild() == null){
                    BinarySearchTreeNode n = new BinarySearchTreeNode(value);
                    curNode.setLeftChild(n);
                    return true;
                }else{
                    curNode = curNode.getLeftChild();
                }
            }else{
                if(curNode.getRightChild() == null){
                    BinarySearchTreeNode n = new BinarySearchTreeNode(value);
                    curNode.setRightChild(n);
                    return true;
                }else{
                    curNode = curNode.getRightChild();
                }
            }
        }

        return false;
    }

    /*
    * Incomplete
    * */
    public boolean delete(int value){
        BinarySearchTreeNode curNode = this.root;

        if(value == this.root.getValue()){
            if(curNode.getLeftChild() != null){
                while(curNode.getLeftChild() != null){
                    curNode = curNode.getLeftChild();
                    if(curNode.getLeftChild() == null)
                }

            }else if(curNode.getRightChild() != null){
                while(curNode.getRightChild() != null){
                    curNode = curNode.getRightChild();
                }
            }else{
                this.root = null;
            }
        }

        while(curNode != null){


        }


        return false;
    }

}

class BinarySearchTreeNode<T>{
    private int value;
    private BinarySearchTreeNode leftChild;
    private BinarySearchTreeNode rightChild;

    public BinarySearchTreeNode(int value){
        this.value = value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public void setLeftChild(BinarySearchTreeNode leftChild){
        this.leftChild = leftChild;
    }

    public BinarySearchTreeNode getLeftChild(){
        return this.leftChild;
    }

    public void setRightChild(BinarySearchTreeNode rightChild){
        this.rightChild = rightChild;
    }

    public BinarySearchTreeNode getRightChild(){
        return this.rightChild;
    }

}

