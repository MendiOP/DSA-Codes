package DataStructures.Queue;

class Node{

    int data;
    Node next;
    Node prev;

    Node(int value){
        this.data = value;
        this.next = null;
        this.prev = null;
    }
}

class QueueList {
    private Node front, rear;
    private int size;

    public QueueList() {
        this.front = this.rear = null;
        size = 0;
    }


    void enqueue(int key) {


        Node temp = new Node(key);

        size++;
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        this.rear.next = temp;
        this.rear = temp;
    }


    void dequeue() {

        if (this.front == null)
            return;

        size--;
        Node temp = this.front;
        this.front = this.front.next;


        if (this.front == null)
            this.rear = null;
    }

    int getSize()
    {
        return this.size;
    }

    int getFront()
    {
        return front.data;
    }

    int getRear()
    {
        return rear.data;
    }
}
    public class MyQueueInLinkedList {

            public static void main(String[] args) {
                QueueList q = new QueueList();
                q.enqueue(10);
                q.enqueue(20);
                System.out.println("Queue Size : " + q.getSize());
                q.dequeue();
                q.dequeue();
                q.enqueue(30);
                q.enqueue(40);
                q.enqueue(50);
                q.dequeue();
                System.out.println("Queue Front : " + q.getFront());
                System.out.println("Queue Rear : " + q.getRear());
                System.out.println("Queue Size : " + q.getSize());
            }
}
