package DataStructures.LinkedList;

import java.util.ArrayList;
import java.util.Scanner;

public class SinglyLinkedList{

    public static void displayList(Node head)
    {
        // Your code here
        ArrayList<Integer> a = new ArrayList<>();
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static int sumOfElements(Node head)
    {
        // your code here
        int sum=0;
        while (head != null)
        {
            sum += head.data;
            head = head.next;
        }
        return sum;
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

    public static int maximum(Node head)
    {
        // your code here
        int max = -1;
        while(head != null)
        {
            if(max < head.data)
                max = head.data;
            head = head.next;
        }
        return max;
    }

    public static int minimum(Node head)
    {
        // your code here
        int max = Integer.MAX_VALUE;
        while(head != null)
        {
            if(max > head.data)
                max = head.data;
            head = head.next;
        }
        return max;
    }

    public static Node insertAtBeginning(Node head, int data)
    {
        // code here
        Node temp = new Node(data);
        temp.next = head;
        head = temp;

        return head;
    }

    public static Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        Node slow = head;
        Node fast = head;
        //Node prev = null;

        Node temp = new Node(data);

        if(head.next == null)
        {
            head.next = temp;
            return head;
        }

        while (fast.next != null && fast.next.next != null)
        {
           // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = slow.next;
        slow.next = temp;

        return head;
    }

    public static Node insertAtPosition(Node head, int position, int data)
    {
        // your code here
        position++;
        Node temp = new Node(data);

        if(head == null)
            return head;

        if(position == 1){

            temp.next = head;
            return temp;
        }

        Node cur = head;
        int i=1;
        while(i < position - 1 && cur != null)
        {
            cur = cur.next;
            i++;
        }

        if(cur == null)
            return head;

        temp.next = cur.next;
        cur.next = temp;
        return head;
    }

    //Function to insert a node at the end of the linked list.
    public static Node insertAtEnd(Node head, int data)
    {
        // code here
        Node temp = new Node(data);

        if(head == null)
            return temp;

        Node cur = head;
        while(cur.next != null)
        {
            cur = cur.next;
        }

        cur.next = temp;
        return head;
    }

    public static Node insertInSorted(Node head, int data)
    {
        // your code here
        Node temp = new Node(data);

        if(head == null)
            return temp;

        if(head.next == null || head.data > data){
            temp.next = head;
            return temp;
        }

        Node cur = head;
        while (cur.next != null)
        {
            if(cur.next.data > data) {
                temp.next = cur.next;
                cur.next = temp;
                return head;
            }
            cur=cur.next;
        }

        cur.next = temp;
        return head;
    }

    public static Node deleteTail(Node head)
    {
        // Your code here
        if(head == null || head.next == null)
            return null;

        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteHead(Node head)
    {
        // Your code here
        if(head == null)
            return null;
        return head.next;

    }
    public static boolean isSorted(Node head)
    {
        // your code here
        Node in = head;
        boolean c1 = true;
        boolean c2 = true;

        while(in != null && in.next != null)
        {
            if(in.data > in.next.data) {
                c1 = false;
                break;
            }
            in = in.next;
        }

        Node dec = head;
        while(dec != null && dec.next != null)
        {
            if(dec.data > dec.next.data) {
                c2 = false;
                break;
            }
            dec = dec.next;
        }

        return (c1 || c2);
    }

    public static Node removeDuplicates(Node head)
    {
        // Your code here
        Node cur = head;

        if(head == null)
            return null;

        while(cur.next != null)
        {
            if(cur.data == cur.next.data){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static boolean isIdentical (Node head1, Node head2){
        //write your code here

        Node h = head1;
        Node t = head2;
        while(t != null && h != null)
        {
            if(t.data != h.data)
                return false;
            t = t.next;
            h = h.next;
        }

        return t == null && h == null;
    }

    public static int getNthFromLast(Node head, int n)
    {
        // Your code here
        if(head==null)
            return -1;

        Node first=head;
        for(int i=0;i<n;i++){
            if(first==null)
                return -1;
            first=first.next;
        }

        Node second=head;
        while(first!=null){

            second=second.next;
            first=first.next;
        }
        return second.data;
    }

    public static Node reverseList(Node head)
    {
        // code here
        Node prev = null;
        Node cur = head;
        Node next;

        while(cur != null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static int search(Node head, int data)
    {
        Node temp = head;

        int count=0;
        while(temp != null)
        {
            count++;
            if(temp.data == data)
                return count;

            temp = temp.next;
        }

        return -1;
    }

    public static Node pairwise_swap(Node head)
    {
        // your code here
        Node cur = head;
        while(cur != null && cur.next != null)
        {
            int t = cur.data;
            cur.data = cur.next.data;
            cur.next.data = t;
            cur = cur.next.next;
        }
        return head;
    }

    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        // Add code here

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;

    }

    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head)
    {
        //Your code here
        String s = "";
        Node cur = head;
        while(cur != null)
        {
            s = s + cur.data;
            cur = cur.next;
        }
        System.out.println(s);
        int l = 0;
        int h = s.length()-1;

        while(l < h)
        {
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }

    ////Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list

        String s1 = "";
        String s2 = "";

        while(first != null)
        {
            s1 += first.data;
            first = first.next;
        }

        while(second != null)
        {
            s2 += second.data;
            second = second.next;
        }

        String s3 = (Integer.parseInt(s1) + Integer.parseInt(s2)) + "";

        Node head = null;
        for(char c : s3.toCharArray()) {
            int n = Integer.parseInt(c + "");
            head = insertAtEnd(head, n);
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node head = null;
        boolean is = true;
        int data,pos;

        System.out.println("                Welcome to the Singly Linked List World          ");
        while(is)
        {
            System.out.println("\nChoose any option from below.");
            System.out.println("Press 1  : Insert At Begin                   Press 2  : Insert At End");
            System.out.println("Press 3  : Insert At Middle                  Press 4  : Insert At a Position");
            System.out.println("Press 5  : Insert in Sorted way              Press 6  : Get Size of the List");
            System.out.println("Press 7  : Delete Head of List               Press 8  : Delete last of List");
            System.out.println("Press 9  : Check if sorted                   Press 10 : Check if Two list are identical");
            System.out.println("Press 11 : Remove Duplicates                 Press 12 : Find Nth Node from last");
            System.out.println("Press 13 : Search in list                    Press 14 : Reverse List");
            System.out.println("Press 15 : Swap Elements Pairwise            Press 16 : Sum of the Elements");
            System.out.println("Press 17 : Minimum element in the List       Press 18 : Maximum element in the List");
            System.out.println("Press 19 : Display List");
            System.out.println("\nPlease Press any other number to exit");

            System.out.print("\nPlease give a choice : ");
            int choose = scan.nextInt();

            switch (choose)
            {
                case 1 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertAtBeginning(head,data);
                    break;

                case 2 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertAtEnd(head,data);
                    break;

                case 3 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertInMid(head,data);
                    break;
                case 4 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    System.out.print("Give position for the node : ");
                    pos = scan.nextInt();

                    head = insertAtPosition(head,pos,data);
                    break;

                case 5 :
                    System.out.print("Give data for the node : ");
                    data = scan.nextInt();
                    head = insertInSorted(head,data);
                    break;

                case 6 :
                    System.out.println("The size of the List is : " + getCount(head));
                    break;
                case 7 :
                    System.out.println("The head of the list has been deleted.");
                    head = deleteHead(head);
                    break;

                case 8 :
                    System.out.println("The Tail of the List has been deleted.");
                    head = deleteTail(head);
                    break;
                case 9 :
                    boolean sorted = isSorted(head);
                    if(sorted)
                        System.out.println("The List is SORTED.");
                    else
                        System.out.println("The List is NOT SORTED");
                    break;
                case 10 :
                    System.out.println("Sorry, this is under developing.");
                    break;
                case 11 :
                    System.out.println("The duplicates are removed from the list.");
                    head = removeDuplicates(head);
                    displayList(head);
                    break;
                case 12 :
                    System.out.print("Give position of the node : ");
                    int n = scan.nextInt();
                    data = getNthFromLast(head, n);
                    System.out.println("\nThe Node is : " + data);
                    break;
                case 13 :
                    System.out.print("Give node value to search : ");
                    data = scan.nextInt();
                    int position = search(head,data);
                    System.out.println("\nThe node is " + position + " number from head.");
                    break;
                case 14 :
                    System.out.print("before reversing :");
                    displayList(head);
                    System.out.println("\nAfter reversing: ");
                    displayList(reverseList(head));
                    break;
                case 15 :
                    head = pairwise_swap(head);
                    System.out.println("The elements are swapped");
                    displayList(head);
                    break;
                case 16 :
                    System.out.println("The sum of the elements is : " + sumOfElements(head));
                    break;
                case 17 :
                    System.out.println("The minimum element in the list is : " + minimum(head));
                    break;
                case 18 :
                    System.out.println("The maximum element in the list is : " + maximum(head));
                    break;
                case 19 :
                    System.out.println("The list is ");
                    displayList(head);
                    break;
                 default:
                     is = false;
            }
        }
    }
}
