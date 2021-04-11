package com.tematihonov;

class Node {
    public RedBook redBook;
    public int id;
    public int value;
    public Node leftChild;
    public Node rightChild;

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void display() {
        System.out.println("id: " + redBook.id + " Имя: " + redBook.name + " Значение: " + redBook.value);
    }
}
