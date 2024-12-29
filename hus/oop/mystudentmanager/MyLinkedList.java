package hus.oop.mystudentmanager;

import java.util.NoSuchElementException;

public class MyLinkedList extends AbstractMyList {
    private Node head;
    private int size;

    private class MyLinkedListIterator implements MyIterator {
        private int currentPosition;

        public MyLinkedListIterator(int start) {
            /* TODO */
            currentPosition = start;
        }

        @Override
        public boolean hasNext() {
            /* TODO */
            return currentPosition != size - 1;
        }

        @Override
        public Object next() {
            /* TODO */
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object data = head.data;
            head = head.next;
            return data;
        }
    }

    /**
     * Hàm dựng khởi tạo list để chứa dữ liệu.
     */
    public MyLinkedList() {
        /* TODO */
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        /* TODO */
        return size;
    }

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    @Override
    public void set(Object data, int index) {
        /* TODO */
        Node targetNode = getNodeByIndex(index);
        targetNode.data = data;
    }

    /**
     * Thêm phần tử dữ liệu vào đầu tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtStart(Object value) {
        /* TODO */
       Node newNode = new Node(value);
       newNode.next = head;
       head = newNode;
    }

    /**
     * Thêm phần tử dữ liệu vào cuối tập dữ liệu.
     * @param value giá trị của phần tử dữ liệu được thêm vào.
     */
    @Override
    public void insertAtEnd(Object value) {
        /* TODO */
        Node newNode = new Node(value);
        //Node perviousNode = getNodeByIndex()
        if (head == null) {
            insertAtStart(value);
        }
        else {
            Node tail = getNodeByIndex(size - 1);
            tail.next = newNode;
        }
        size++;
    }

    /**
     * Thêm phần tử dữ liệu vào vị trí index của tập dữ liệu.
     * Chỉ thêm được nếu index nằm trong đoạn [0 - size()].
     * @param value
     * @param index
     */
    @Override
    public void insertAtPosition(Object value, int index) {
        /* TODO */
        checkBoundaries(index, size);
        if (index == 0) {
            insertAtStart(value);
        } else {
            Node previousNode = getNodeByIndex(index - 1);
            Node newNode = new Node(value);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
            size++;
        }
    }

    /**
     * Xóa phần tử dữ liệu tại vị trí index.
     * Chỉ xóa được nếu index nằm trong đoạn [0 - (size() - 1)]
     * @param index
     */
    @Override
    public void remove(int index) {
        /* TODO */
        checkBoundaries(index, size);
        if (index == 0) {
            head = head.next;
        } else {
            Node previousNode = getNodeByIndex(index - 1);
            previousNode.next = previousNode.next.next;
        }
        size--;
    }

    /**
     * Phương thức lấy Node ở vị trí index.
     * @param index
     * @return
     */
    private Node getNodeByIndex(int index) {
        /* TODO */
        checkBoundaries(index, size);
        Node currentNode = head;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public MyIterator iterator() {
        /* TODO */
        return new MyLinkedListIterator(0);
    }

    @Override
    public Object get(int index) {
        return getNodeByIndex(index).data;
    }
}
