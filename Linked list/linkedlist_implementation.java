import java.util.Scanner;

public class linkedlist_implementation {
    static Node head;

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static void display() {
        Node ptr = head;
        if (ptr == null) {
            System.out.println("linked list is empty");
        } else {
            while (ptr != null) {
                System.out.print(ptr.data + " ---> ");
                ptr = ptr.next;
            }
            System.out.println("NULL");
        }
    }

    public static void add_First() {
        Scanner s = new Scanner(System.in);
        String data;
        System.out.println("enter the data of the node you want to insert");
        data = s.nextLine();
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void add_Last() {
        Scanner s = new Scanner(System.in);
        String data;
        System.out.println("enter the data of the node you want to insert");
        data = s.nextLine();
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    public static void add_before() {
        Node ptr = head;
        int count = 0;
        while (ptr != null) {
            ptr = ptr.next;
            count++;
        }
        Scanner s = new Scanner(System.in);
        int pos;
        System.out.println("enter the position before which you want to insert the node");
        pos = s.nextInt();
        String data;
        System.out.println("enter the data of the node you want to insert");
        data = s.next();
        Node newNode = new Node(data);
        ptr = head;
        if (pos < 1 || pos > count) {
            System.out.println("invalid input");
            System.exit(0);
        } else if (pos == 1) {

            newNode.next = head;
            head = newNode;
        } else {
            for (int i = 1; i < pos - 1; i++) {
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
        }

    }

    public static void add_after() {
        Node ptr = head;
        int count = 0;
        while (ptr != null) {
            ptr = ptr.next;
            count++;
        }
        Scanner s = new Scanner(System.in);
        int pos;
        System.out.println("enter the position after which you want to insert the node");
        pos = s.nextInt();
        String data;
        System.out.println("enter the data of the node you want to insert");
        data = s.next();
        Node newNode = new Node(data);
        ptr = head;
        if (pos < 1 || pos > count) {
            System.out.println("invalid input");
            System.exit(0);
        } else if (pos == count) {

            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
        } else {
            for (int i = 1; i < pos; i++) {
                ptr = ptr.next;
            }
            newNode.next = ptr.next;
            ptr.next = newNode;
        }

    }

    public static void main(String[] args) {
        linkedlist_implementation list = new linkedlist_implementation();
        int num;
        Node ptr = head;
        Scanner s = new Scanner(System.in);
        System.out.println("enter the number of nodes you want to insert");
        num = s.nextInt();
        for (int i = 0; i < num; i++) {
            String data;
            System.out.println("enter the data value of the node");
            data = s.next();
            Node newNode = new Node(data);
            if (i == 0) {
                head = newNode;
                ptr = head;
            } else {
                ptr.next = newNode;
                ptr = ptr.next;
            }
        }
        display();
        add_First();
        System.out.println("the linked list after the insertion at the beginning is");
        display();
        add_Last();
        System.out.println("the linked list after the insertion at the end is ");
        display();

        add_before();
        System.out.println("the linked list after the insertion at the any position(before) is ");
        display();
        add_after();
        System.out.println("the linked list after the insertion at the any position(after) is ");
        display();
    }
}