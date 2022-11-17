package DataStructures.Stack;

import java.util.Stack;

class StackNode {
    int data;
    StackNode next;
    public StackNode(int data)
    {
        this.data = data;
        this.next = null;
    }
}


class Stackfuntionalist {

    private StackNode top;

    public void push(int data)
    {
        if (this.top == null) {
            top = new StackNode(data);
            return;
        }
        StackNode s = new StackNode(data);
        s.next = this.top;
        this.top = s;
    }
    public StackNode pop()
    {
        StackNode s = this.top;
        this.top = this.top.next;
        return s;
    }

    public void display()
    {
        StackNode s = this.top;
        while (s != null) {
            System.out.print(s.data + " ");
            s = s.next;
        }
        System.out.println();
    }

    public void reverse()
    {
        StackNode prev, cur, succ;
        cur = prev = this.top;
        cur = cur.next;
        prev.next = null;
        while (cur != null) {

            succ = cur.next;
            cur.next = prev;
            prev = cur;
            cur = succ;
        }
        this.top = prev;
    }

    public Stack<Integer> sortStack(Stack<Integer> stack)
    {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty())
        {
            int t = stack.peek();
            stack.pop();
            while (!temp.isEmpty() && t < temp.peek())
            {
                stack.push(temp.peek());
                temp.pop();
            }
            temp.push(t);
        }

        return temp;
    }

    public void SortStackUsingRecursion(Stack<Integer> stack)
    {
        if(stack.isEmpty())
            return;

        int n = stack.pop();
        SortStackUsingRecursion(stack);
        sortedInsert(stack, n);
    }

    private void sortedInsert(Stack<Integer> stack, int n)
    {
        if(stack.isEmpty() || n > stack.peek()){
            stack.push(n);
            return;
        }

        int t = stack.pop();
        sortedInsert(stack, n);
        stack.push(t);
    }

    public void reverseStack(Stack<Integer> stack)
    {

        if(stack.isEmpty())
            return;

        int n = stack.pop();
        reverseStack(stack);
        reverselyInsert(stack, n);
    }

    private void reverselyInsert(Stack<Integer> stack, int n)
    {
        if(stack.isEmpty()) {
            stack.push(n);
            return;
        }

        int t = stack.pop();
        reverselyInsert(stack, n);
        stack.push(t);
    }
}

public class SomeStackfunctionalist{
    public static void main(String[] args) {
        Stackfuntionalist stack = new Stackfuntionalist();

    }
}
