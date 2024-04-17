package DataStructure.bootCourseWithJava;

public class Tree_<E> {
    class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E obj) {
            this.data = obj;
            left = right = null;
        }
    }

    private Node<E> root;
    private int currentSize = 0;

    public void add(E obj) {
        if (root == null) {
            root = new Node<E>(obj);
        } else {
            add(obj, root);
        }
        currentSize++;
    }

    private void add(E obj, Node<E> node) {
        if (((Comparable<E>) obj).compareTo(node.data) > 0) {
            // go to the right
            if (node.right == null) {
                node.right = new Node<E>(obj);
                return;
            }
            add(obj, node.right);
            return;
        }

        // go to the left
        if (node.left == null) {
            node.left = new Node<E>(obj);
            return;
        }
        add(obj, node.left);
        return;
    }

    public boolean contains(E obj) {
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node) {
        if (node == null) {
            return false;
        }
        if (((Comparable<E>) obj).compareTo(node.data) == 0) {
            return true;
        }
        if (((Comparable<E>) obj).compareTo(node.data) > 0) {
            return contains(obj, node.right);
        }
        return contains(obj, node.left);
    }

    public Node<E> leftRotate(Node<E> node) {
        Node<E> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }

    public Node<E> rightRotate(Node<E> node) {
        Node<E> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
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
}
