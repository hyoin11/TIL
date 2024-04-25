package DataStructure.bootCourseWithJava;

public class AVLTree<E> {
    class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node<T> parent;

        public Node(T obj) {
            this.data = obj;
            parent = left = right = null;
        }

        @Override
        public String toString() {
            return "data : " + this.data
                    + "\nleft : " + this.left
                    + "\nright : " + this.right;
        }
    }

    private Node<E> root;
    private int currentSize;

    public AVLTree() {
        root = null;
        currentSize = 0;
    }

    public void add(E obj) {
        Node<E> node = new Node<E>(obj);
        if (root == null) {
            root = node;
            currentSize++;
            return;
        }
        add(root, node);
    }

    private void add(Node<E> parent, Node<E> newNode) {
        if (((Comparable<E>) newNode.data).compareTo(parent.data) > 0) {
            if (parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                add(parent.right, newNode);
            }
        } else {
            if (parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                currentSize++;
            } else {
                add(parent.left, newNode);
            }
        }
        checkBalance(newNode);
    }

    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left == null) {
            return 1 + height(node.right);
        } else if (node.right == null) {
            return 1 + height(node.left);
        }
        if (height(node.left) > height(node.right)) {
            return 1 + height(node.left);
        }
        return 1 + height(node.right);
    }

    private void checkBalance(Node<E> node) {
        if ((height(node.left) - height(node.right) > 1) ||
                (height(node.left) - height(node.right) < -1)) {
            rebalance(node);
            return;
        }
        if (node.parent == null) {
            return;
        }
        checkBalance(node.parent);
    }

    private void rebalance(Node<E> node) {
        if (height(node.left) - height(node.right) > 1) {
            // 왼쪽 자식 > 오른쪽 자식
            if (height(node.left.left) > height(node.left.right)) {
                // 왼쪽 서브 트리 > 오른쪽 서브 트리
                node = rightRotate(node);
                if (node.parent != null) {
                    node.parent.right = node;
                }
            } else {
                node = leftRightRotate(node);
                if (node.parent != null) {
                    node.parent.left = node;
                }
            }
        } else if (height(node.right) - height(node.left) > 1) {
            // 왼쪽 자식 < 오른쪽 자식
            if (height(node.right.left) < height(node.right.right)) {
                // 왼쪽 서브 트리 < 오른쪽 서브 트리
                node = leftRotate(node);
                if (node.parent != null) {
                    node.parent.left = node;
                }
            } else {
                node = rightLeftRotate(node);
                if (node.parent != null) {
                    node.parent.right = node;
                }
            }
        }

        if (node.parent == null) {
            root = node;
        }
    }

    public Node<E> leftRotate(Node<E> node) {
        Node<E> tmp = node.right;
        node.right = tmp.left;
        tmp.parent = node.parent;
        tmp.left = node;
        node.parent = tmp;
        return tmp;
    }

    public Node<E> rightRotate(Node<E> node) {
        Node<E> tmp = node.left;
        node.left = tmp.right;
        tmp.parent = node.parent;
        tmp.right = node;
        node.parent = tmp;
        return tmp;
    }

    public Node<E> rightLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    public Node<E> leftRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("root");
        sb.append("\n");
        sb.append(root.toString());
        return sb.toString();
    }
}
