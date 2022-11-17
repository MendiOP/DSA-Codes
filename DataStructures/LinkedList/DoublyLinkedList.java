package DataStructures.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class DoublyLinkedList {

    public static Node inserBegin(Node head, int data)
    {
        Node temp = new Node(data);

        temp.next = head;

        if(head != null)
            head.prev = temp;

        return temp;
    }

    public static Node insertAtPosition(Node head, int pos, int data)
    {
        // Your code here
        Node temp = new Node(data);

        if(head == null)
        {
            return null;
        }

        if(head.next == head){
            head.next = temp;
            temp.prev = head;
            return head;
        }

        Node cur = head;
        int i=0;
        while(i < pos)
        {
            cur = cur.next;
            i++;
        }

        if(cur.next == null){
            cur.next = temp;
            temp.prev = cur;
            return head;
        }

        temp.next = cur.next;
        cur.next.prev = temp;
        cur.next = temp;
        temp.prev = cur;

        return head;
    }

    public static Node sortedInsert(Node head, int data)
    {
        // add your code here
        Node cur = head;
        Node temp = new Node(data);

        if(head.next == null)
        {
            if(head.data < data) {
                head.next = temp;
                temp.prev = head;
            }
            else{
                temp.next = head;
                head.prev = temp;
                head = temp;
            }
            return head;
        }

        if(data < head.data){
            temp.next = head;
            head.prev = temp;
            head = temp;
            return head;
        }

        while(cur.next != null)
        {
            if(cur.data >= data)
            {
               Node t = cur.prev;
               temp.next = cur;
               cur.prev.next = temp;
               cur.prev = temp;
               temp.prev = t;
               return head;
            }
            cur = cur.next;
        }

        if(cur.data < data)
        {
            cur.next = temp;
            temp.prev = cur;
        }
        else{
            cur.prev.next = temp;
            temp.prev = cur.prev;
            temp.next = cur;
            cur.prev = temp;
        }

        return head;
    }

    public static Node insertEnd(Node head, int data)
    {
        Node temp = new Node(data);
        Node cur = head;

        if(head == null)
            return temp;

        while(cur.next != null)
        {
            cur = cur.next;
        }

        cur.next = temp;
        temp.prev = cur;
        return head;
    }

    public static Node reverse(Node head)
    {
        Node cur = head;

        if(head == null || head.next == null)
        {
            return head;
        }

        Node temp = null;
        while(cur != null){
            temp = cur.prev;
            cur.prev = cur.next;
            cur.next = temp;

            cur = cur.prev;
        }
        return temp.prev;
    }

    public static Node deleteHead(Node head)
    {
        if(head == null || head.next == null)
            return null;
        head.next.prev = null;
        return head.next;
    }
    public static Node deleteNode(Node head,int x)
    {
        // Your code here
        if(x == 1)
          return deleteHead(head);

        Node cur = head;
        int i = 1;
        while(i < x){
            i++;
            cur = cur.next;
        }

        if(i == x)
           return deleteEnd(head);

        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        return head;
    }

    public static Node deleteEnd(Node head)
    {
        if(head == null || head.next == null)
            return null;
        Node cur = head;
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.prev.next = null;
        return head;
    }

    public static void displayCirculerDoublyList(Node head)
    {
        // your code here

        Node curr=head;
        while(curr.next!=head){
            System.out.print(curr.data + " ");
            curr=curr.next;
        }
    }

    public static int findMiddleCirculerDoublyList(Node head)
    {
        // your code here
        Node fast=head;
        Node slow=head;
        while(fast.next!=head){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }

    public static boolean isCircularDoublyList(Node head)
    {
        // your code here
        if(head.prev!=null){
            return true;
        }
        return false;
    }

    public static void print(Node head)
    {
        while(head != null){
            System.out.println(head.data + " ");
            head = head.next;
        }
    }

    public static void makeDoubly(Node head){

        // Your code here

        Node cur = head;
        Node prev = null;
        while(cur.next != null)
        {
            prev = cur;
            cur = cur.next;
            cur.prev = prev;
        }

    }

    public static void sumUpdateCirculerDoublyList(Node head)
    {
        int sum = 0;
        Node temp = head;

        if(head.next == head){
            head.data = sum;
            return;
        }

        while(temp.next != head)
        {
            sum += temp.data;
            temp = temp.next;
        }
        sum += temp.data;
        //System.out.println(sum);

        Node cur = head;
        while(cur.next != head)
        {
            cur.data = sum - cur.data;
            cur = cur.next;
        }
    }

    public static int getCount(Node head)
    {

        //Code here
        int sum=0;
        while (head != null)
        {
            sum += 1;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node head = null;
        boolean is = true;
        int data,pos;

        System.out.println("                Welcome to the Doubly Linked List World          ");
        while(is)
        {
            System.out.println("\nChoose any option from below.");
            System.out.println("Press 1  : Insert At Begin                   Press 2  : Insert At End");
            System.out.println("Press 3  : Insert in Sorted way              Press 4  : Insert At a Position");
            System.out.println("Press 5  : Delete Head of List               Press 6  : Delete last of List");
            System.out.println("Press 7  : Delete at Position                Press 8  : Get size of the list");
            System.out.println("Press 9  : Reverse List                      Press 10 : Display List");

            System.out.println("\nPlease Press any other number to exit");

            System.out.print("\nPlease give a choice : ");
            int choose = scan.nextInt();

            switch (choose)
            {
                case 1 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = inserBegin(head,data);
                    break;

                case 2 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertEnd(head,data);
                    break;

                case 3 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = sortedInsert(head,data);
                    break;
                case 4 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    System.out.print("Give position for the node : ");
                    pos = scan.nextInt();

                    head = insertAtPosition(head,pos,data);
                    break;

                case 5 :
                    System.out.println("The head of the list has been deleted.");
                    head = deleteHead(head);
                    break;

                case 6:
                    System.out.println("The Tail of the List has been deleted.");
                    head = deleteEnd(head);
                    break;
                case 7 :
                    System.out.print("Give position : ");
                    int n = scan.nextInt();
                    head = deleteNode(head,n);
                    System.out.println("The " + n +" node of the List has been deleted.");
                    break;
                case 8 :
                    System.out.println("The size of the list is : " + getCount(head));
                    break;

                case 9 :
                    System.out.print("before reversing :");
                    print(head);
                    System.out.println("\nAfter reversing: ");
                    print(reverse(head));
                    break;

                case 10 :
                    System.out.println("The list is ");
                    print(head);
                    break;
                default:
                    is = false;
            }
        }
    }
}
