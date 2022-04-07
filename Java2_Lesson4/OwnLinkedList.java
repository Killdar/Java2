package ru.geekbrains.com;

public class OwnLinkedList<T> {
    private long size;
    private Node tails;
    private Node head;

    public OwnLinkedList() {
        this.size = 0;
        this.tails = null;
        this.head = null;
    }


    public void addNodeIndx(T data, int index) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tails = newNode;
            size++;
        } else {
            if ((index > size)) {
                System.out.println("Размер списка (" + size + ") меньше заданного индекса добавляемого элемента (" + index + ")");
                return;
            } else {
                if (index == 0) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    if (index < size) {
                        Node current = head;
                        int i = 0;
                        while (current.next != null) {
                            if (i == index - 1) {
                                newNode.next = current.next;
                                current.next = newNode;
                                return;
                            }
                            current = current.next;
                            i++;
                        }
                    } else {
                        tails.next = newNode;
                    }
                }
            }
            tails = newNode;
            size++;
        }
    }

    public void deleteNodeIndx(int index) {
        if (head == null) {
            System.out.println("Список пуст");
            return;
        }
        if ((head == tails) & (size == 1)) {
            System.out.println("Элемент удален");
            head = null;
            tails = null;
            return;
        }
        if (index > size) {
            System.out.println("ERROR - элемента с таким индексом не существует");
            return;
        } else {
            if (index == 0) {
                head = head.next;
            } else {
                Node current = head;
                int i = 0;
                while (current.next != null) {
                    if (i == index - 1) {
                        if (index == size) {
                            tails = current;
                            current.next = null;
                            size--;

                            return;
                        } else {
                            current.next = current.next.next;
                            return;
                        }
                    }
                    current = current.next;
                    i++;
                }
            }
        }
    }


    public void display() {
        if (size == 0) {
            System.out.println("Список пуст");
            return;
        } else {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }

    }


    public void displayIndex(int index) {
        if (index > size) {
            System.out.println("Размер списка меньше заданного индекса");
            return;
        } else {
            Node current = head;
            for (int i = 1; i <= index; i++) {
                current = current.next;
            }
            System.out.println(current.data);
        }

    }

    private class Node {
        T data;
        Node next;


        public Node(T data) {
            this.data = data;
            this.next = null;
        }


    }

}
