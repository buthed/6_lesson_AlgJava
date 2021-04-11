package com.tematihonov;
	// Task 6.1
    // Приведите пример использования древовидной структуры:
    // Все животные красной книги. Вся книга делится на царства: Животные, бактерии, Растения и т.д. В свою очередь Царство животные делится на: рыбы, птицы, насекомые и т.д.

    // Task 6.2
    // Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
    public class Tree {

        private Node root;


        // Task 6.3
        // Реализуйте методы поиска и вставки узла в дерево.
        public void insert(RedBook redBook) {
            Node node = new Node();
            node.redBook = redBook;
            if (root == null) {
                root = node;
            } else {
                Node current = root;
                Node parent;
                while (true) {
                    parent = current;
                    if (redBook.id < current.redBook.id) {
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

        public Node find(int key) {
            Node current = root;
            while (current.redBook.id != key) {
                if (key < current.redBook.id)
                    current = current.leftChild;
                else
                    current = current.rightChild;
                if (current == null)
                    return null;
            }
            return current;
        }


        // Task 6.4
        // Реализуйте базовые методы обхода дерева и метода дисплей.
        // Реализуйте поиск максимума и минимума.
        private void preOrder(Node rootNode) {
            if (rootNode != null) {
                rootNode.display();
                preOrder(rootNode.leftChild);
                preOrder(rootNode.rightChild);
            }
        }

        private void postOrder(Node rootNode) {
            if (rootNode != null) {
                postOrder(rootNode.leftChild);
                postOrder(rootNode.rightChild);
                rootNode.display();
            }
        }

        private void inOrder(Node rootNode) {
            if (rootNode != null) {
                inOrder(rootNode.leftChild);
                rootNode.display();
                inOrder(rootNode.rightChild);
            }
        }

        public Node min() {
            Node current, last = null;
            current = root;
            while (current != null) {
                last = current;
                current = current.leftChild;
            }
            return last;
        }

        public Node max() {
            Node current, last = null;
            current = root;
            while (current != null) {
                last = current;
                current = current.rightChild;
            }
            return last;
        }

        // Task 6.5
        // Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
        public boolean delete(int id) {
            Node current = root;
            Node parent = root;

            boolean isLeftChild = true;

            while (current.redBook.id != id) {
                parent = current;
                if (id < current.redBook.id) {
                    isLeftChild = true;
                    current = current.leftChild;
                } else {
                    isLeftChild = false;
                    current = current.rightChild;
                }
                if (current == null) {
                    return false;
                }
            }

            if (current.leftChild == null && current.rightChild == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.leftChild = null;
                } else {
                    parent.rightChild = null;
                }
            } else if (current.rightChild == null) {
                if (current == null) {
                    root = current.leftChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            } else if (current.leftChild == null) {
                if (current == null) {
                    root = current.rightChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            } else {
                Node successor = getSuccesor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }
                successor.leftChild = current.leftChild;
            }
            return true;
        }

        public Node getSuccesor(Node node) {
            Node successorParent = node;
            Node successor = node;
            Node current = node.rightChild;

            while (current != null) {
                successorParent = successor;
                successor = current;
                current = node.leftChild;
            }
            if (successor != node.rightChild) {
                successorParent.leftChild = successorParent.rightChild;
                successor.rightChild = node.rightChild;
            }
            return successor;
        }

        public void displayTree() {
            Node current = root;
            System.out.println("Симметричный");
            inOrder(root);
            System.out.println("ПРямой");
            preOrder(root);
            System.out.println("Обратный");
            postOrder(current);
        }
    }










