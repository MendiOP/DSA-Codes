package DataStructures.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class CirculerLinkedList {


    public static int getLength(Node  head)
    {
        //Your code here
        Node cur = head;
        int l=0;

        if(head.next == head)
            return 1;

        while(cur.next != head){
            l++;
            cur = cur.next;
        }
        return l;
    }

    public static boolean isCircular(Node head)
    {
        // Your code here
        if(head==null) return true;

        Node temp=head;

        while(temp.next!=null){

            temp=temp.next;
            if(temp.next==head) return true;

        }

        return false;

    }



    public static Node insertBegin(Node head, int data){
        Node temp = new Node(data);

        if(head == null){
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        return head;
    }

    public static Node insertEnd(Node head, int data){
        Node temp = new Node(data);

        if(head == null){
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        return temp;
    }

    public static void insertAtPosition(Node head, int pos, int data)
    {
        // your code here
        int i = 0;
        Node cur = head;

        Node temp = new Node(data);

        while(i < pos - 1)
        {
            if(cur.next != head)
                cur = cur.next;
            else
                break;
            i++;
        }

        if(pos - 1 > i)
            return;

        temp.next = cur.next;
        cur.next = temp;
    }

    public static Node deleteHead(Node head)
    {
        if(head == null || head.next == head)
            return null;

        head.data = head.next.data;

        head.next = head.next.next;
        return head;
    }

    public static Node deleteTail(Node head)
    {
        // your code here

        if(head == null || head.next == null)
            return null;

        Node cur = head;
        while(cur.next.next != head)
        {
            cur = cur.next;
        }
        cur.next = head;
        return head;
    }

    public static Node reverse(Node head)
    {

        if (head == null)
            return null;

        Node prev = null;
        Node current = head;
        Node next;
        do
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != (head));

        (head).next = prev;
        head = prev;
        return head;
    }


    public static Node deleteKthFromBegin(Node head, int data)
    {
        int i=1;
        Node cur = head;

        if(head == null || (head.next == head && data == 1))
            return null;

        while(i < data - 1)
        {
            cur = cur.next;
            i++;
        }

        if(data == 1)
            return deleteHead(head);

        cur.next = cur.next.next;
        return head;
    }

    public static void displayList(Node head)
    {
        // your code here

        if(head==null)
            return;


        for(Node r=head.next;r!=head;r=r.next)
            System.out.print(r.data + " ");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node head = null;
        boolean is = true;
        int data,pos;

        System.out.println("                Welcome to the Circular Linked List World          ");
        while(is)
        {
            System.out.println("\nChoose any option from below.");
            System.out.println("Press 1  : Insert At Begin                   Press 2  : Insert At End");
            System.out.println("Press 3  : Insert At a Position              Press 4  : Check if Circular");
            System.out.println("Press 5  : Delete Head of List               Press 6  : Delete last of List");
            System.out.println("Press 7  : Delete at Position from begin     Press 8  : Get size of the list");
            System.out.println("Press 9  : Reverse List                      Press 10 : Display List");

            System.out.println("\nPlease Press any other number to exit");

            System.out.print("\nPlease give a choice : ");
            int choose = scan.nextInt();

            switch (choose)
            {
                case 1 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertBegin(head,data);
                    break;

                case 2 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertEnd(head,data);
                    break;

                case 3 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    System.out.print("Give position for the node : ");
                    pos = scan.nextInt();

                    insertAtPosition(head,pos,data);
                    break;
                case 4 :
                    boolean circle = isCircular(head);
                    if(circle)
                        System.out.println("The list is circular");
                    else
                        System.out.println("The list is not circular");
                    break;

                case 5 :
                    System.out.println("The head of the list has been deleted.");
                    head = deleteHead(head);
                    break;

                case 6:
                    System.out.println("The Tail of the List has been deleted.");
                    head = deleteTail(head);
                    break;
                case 7 :
                    System.out.print("Give position : ");
                    int n = scan.nextInt();
                    head = deleteKthFromBegin(head,n);
                    System.out.println("The " + n +" node of the List has been deleted.");
                    break;
                case 8 :
                    System.out.println("The size of the list is : " + getLength(head));
                    break;

                case 9 :
                    System.out.print("before reversing :");
                    displayList(head);
                    System.out.println("\nAfter reversing: ");
                    displayList(reverse(head));
                    break;

                case 10 :
                    System.out.println("The list is ");
                    displayList(head);
                    break;
                default:
                    is = false;
            }
        }
    }
}
