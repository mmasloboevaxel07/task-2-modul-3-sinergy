package third_modul.second;

public class MyLinkedList<E> {
    private class Node {
        public E element;
        public Node next;

        public Node(E element) {
            this.element = element;
            next = null;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node = " + this.element.toString();
        }
    }

    private int size;
    private Node head;

    public MyLinkedList() {
        size = 0;
        head = null;
    }
    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public int getSize() {
        return size;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    public int indexOf(Object obj) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (obj.equals(node.element)) return i;
            node = node.next;
        }
        return -1;
    }

    public void add(E element) {
        if (size != 0) {
            Node node = head;
            for (; node.next != null; node = node.next) {}
            node.next = new Node(element);
        } else {
            head = new Node(element);
        }
        size++;
    }

    public void add(int index, E element) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса");
        } else {
            if (index == 0) {
                head = new Node(element, head);
            } else {
                Node node = getNode(index - 1);
                node.next = new Node(element, node.next);
            }
            size++;
        }
    }

    public E remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("Нет такого индекса");
        } else {
            Node toReturn = getNode(index);
            if (index == 0) {
                head = new Node(getNode(index + 1).element, getNode(index + 2));
            } else {
                Node node = getNode(index - 1);
                node.next = getNode(index + 1);
            }
            size--;
            return toReturn.element;
        }
    }

    public void remove(Object object) {
        remove(indexOf(object));
    }

    public void print() {
        System.out.print("Содержимое массива: ( ");
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println("), длина массива: " + size);

    }
}