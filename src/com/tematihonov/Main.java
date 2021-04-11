package com.tematihonov;

public class Main {
	// Task 6.1
    // Приведите пример использования древовидной структуры:
    // Все животные красной книги. Вся книга делится на царства: Животные, бактерии, Растения и т.д. В свою очередь Царство животные делится на: рыбы, птицы, насекомые и т.д.

    // Task 6.2
    // Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
    class Tree {

        private Node root;


        // Task 6.3
        // Реализуйте методы поиска и вставки узла в дерево.
        public void insert(int value) {
            Node node = new Node();
            node.setValue(value);
            if(root == null){
                root = node;
            } else {
                Node current = root;
                Node parent;
                while (true) {
                    parent = current;
                    if (value < node.getValue()) {
                        current = current.leftChild;
                        if (current == null) {
                            parent.leftChild = node;
                            return;
                        }
                    } else {
                        current = current.rightChild;
                        if (current == null) {
                            parent.rightChild = node;
                            return;
                        }
                    }
                }
            }
        }


        public Node find (int key) {
            Node current = root;
            while (current.value != key) {
                if (key < current.value) {
                    current = current.leftChild;
                } else {
                    current = current.rightChild;
                }
                if (current == null) {
                    return null;
                }
            }
            return current;
        }


        // Task 6.5
        // Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().

        public boolean delete(int id) {

        }

    }
    class Node {
        private int id;
        private int value;
        private Node leftChild;
        private Node rightChild;

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
    }






    // Task 6.4
    // Реализуйте базовые методы обхода дерева и метода дисплей.
    // Реализуйте поиск максимума и минимума.


    // Task 6.6
    // Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
    // Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.

    // Task 6.7
    // Приведите пример сбалансированного дерева и его применения.

}
