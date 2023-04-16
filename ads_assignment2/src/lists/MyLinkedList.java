package lists;


public class MyLinkedList<T> implements MyList<T>{
    private class Node {
        T element;
        Node next;
        Node prev;

        Node(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }


    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private void removeNode(Node node) {
        if (node == head) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node == tail) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        size--;
    }
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index <= size / 2) {
            Node currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            Node currNode = tail;
            for (int i = size - 1; i > index; i--) {
                currNode = currNode.prev;
            }
            return currNode;
        }
    }

        @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node node = head;
        while (node != null) {
            if (node.element.equals(o)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void add(T element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node nodeAtIndex = getNode(index);
            nodeAtIndex.prev.next = newNode;
            newNode.prev = nodeAtIndex.prev;
            newNode.next = nodeAtIndex;
            nodeAtIndex.prev = newNode;
        }

        size++;
    }

    @Override
    public boolean remove(T element) {
        Node nodeToRemove = head;
        while (nodeToRemove != null) {
            if (nodeToRemove.element.equals(element)) {
                removeNode(nodeToRemove);
                return true;
            }
            nodeToRemove = nodeToRemove.next;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node nodeToRemove = getNode(index);
        removeNode(nodeToRemove);
        return nodeToRemove.element;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.element;
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        Node node = head;
        while (node != null) {
            if (node.element.equals(element)) {
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object element) {
        int index = size - 1;
        Node node = tail;
        while (node != null) {
            if (node.element.equals(element)) {
                return index;
            }
            node = node.prev;
            index--;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (size <= 1) {
            return;
        }
        Node current = head.next;
        while (current != null) {
            Node prev = current.prev;
            while (prev != null && ((Comparable) current.element).compareTo(prev.element) < 0) {
                Object tmp = current.element;
                current.element = prev.element;
                prev.element = (T) tmp;
                current = prev;
                prev = current.prev;
            }
            current = current.next;
        }
    }
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node node = head;
        sb.append(node.element);
        node = node.next;
        while (node != null) {
            sb.append(", ").append(node.element);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
