package DataStructure.bootCourseWithJava;

public class LinkedList_<E> {
    // 노드 정의
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize; // 노드의 개수를 세는 변수

    public LinkedList_() {  // 기본 연결 리스트
        head = null;
        tail = null;
        currentSize = 0;
    }

    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        node.next = head;
        if (head == null) {
            head = tail = node;
        } else {
            head = node;
        }
        currentSize++;
    }

    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E tmp = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return tmp;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            return removeFirst();
        }

        Node<E> current = head, previous = null;
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    public E remove(E obj) {
        Node<E> current = head, previous = null;
        while (current != null) {
            if (((Comparable<E>) current.data).compareTo(obj) == 0) {
                // 찾고자 하는 객체
                if (current == head) {
                    return removeFirst();
                }
                if (current == tail) {
                    return removeLast();
                }
                currentSize--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (((Comparable<E>) obj).compareTo(current.data) == 0) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
