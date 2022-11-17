package DataStructures.Stack;

class Stack {

    private final int size;
    private int[] arr;
    private int top = -1;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public void push(int data)
    {
        if(top < size - 1)
            arr[++top] = data;
        else
            System.out.println("The stack is full. no pushing possible");
    }

    public int pop()
    {
        if(!isEmpty())
            return arr[top--];
        System.out.println("The stack is empty. No pop is possible.");
        return -1;
    }

    public int top() {
        if (isEmpty()){
            System.out.println("The stack is empty.no top element");
        return -1;
        }
        return arr[top];
    }

    public int getSize()
    {
        return top+1;
    }

//    ArrayList<Integer> al=new ArrayList<>();
//    void push(int x){
//        al.add(x);
//    }
//
//    int pop(){
//        int res=al.get(al.size()-1);
//        al.remove(al.size()-1);
//        return res;
//    }
//
//    int peek(){
//        return al.get(al.size()-1);
//    }
//
//    int size(){
//        return al.size();
//    }
//
//    boolean isEmpty(){
//        return al.isEmpty();
//    }

    public void print()
    {
        for(int i =0;i<=top;i++)
            System.out.println(arr[i] + " ");
    }


}

public class MyStackinArray{
    public static void main(String[] args) {
        Stack my = new Stack(5);
        my.push(5);
        my.push(6);
        my.push(8);
        my.push(18);
        my.print();
        System.out.println("Poped " + my.pop());
        my.print();
        my.push(200);
        my.print();
        my.pop();
        my.pop();
        my.pop();
        my.pop();
        my.pop();
        my.pop();

    }
}
