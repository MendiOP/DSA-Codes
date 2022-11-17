package DataStructures.Tree;

import java.util.ArrayList;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    public boolean search(Node root, int key)
    {
        if(root == null)
            return false;

        if(root.data == key)
            return true;
        else if(root.data < key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public Node insert(Node root, int data)
    {
        Node temp = new Node(data);

        if(root == null)
            return temp;

        if(root.data < data)
            root.right = insert(root.right, data);
        else if(root.data > data)
            root.left = insert(root.left, data);

        return root;
    }

    public Node delete(Node root, int key)
    {
        if(root == null)
            return null;

        if(root.data < key)
            root.right = delete(root.right, key);
        else if(root.data > key)
            root.left = delete(root.left, key);
        else
        {
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;

            Node successor = inorderSuccessor(root);
            root.data = successor.data;

            root.right = delete(root.right, root.data);
        }
        return root;
    }

    public int floor(Node root, int data)
    {
        int ans = Integer.MIN_VALUE;
        while(root != null)
        {
            if(root.data == data)
                return root.data;

            else if(root.data > data)
                root = root.left;
            else
            {
                ans = root.data;
                root = root.right;
            }
        }
        return ans;
    }

    public int ceil(Node root, int data)
    {
        int ans = Integer.MAX_VALUE;
        while(root != null)
        {
            if(root.data == data)
                return root.data;

            else if(root.data < data)
                root = root.right;

            else
            {
                ans = root.data;
                root = root.left;
            }

        }
        return ans;
    }

    boolean isBST(Node root)
    {
        // code here.
        ArrayList<Integer> a = new ArrayList<>();
        inorder(root, a);
        return isSorted(a);
    }

    private void inorder(Node root, ArrayList<Integer> a)
    {
        if(root == null)
            return;

        inorder(root.left, a);
        a.add(root.data);
        inorder(root.right, a);
    }

    boolean isSorted(ArrayList<Integer> a)
    {
        for(int i=1; i<a.size(); i++){
            if(a.get(i) < a.get(i-1))
                return false;
        }
        return true;
    }

    // making height balanced bst from a sorted array.
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here
        Node root = construct(nums, 0, nums.length-1);
        ArrayList<Integer> a = new ArrayList<>();
        preorder(root, a);

        return a.stream().mapToInt(i->i).toArray();
    }

    public void preorder(Node root, ArrayList<Integer> a)
    {
        if(root == null)
            return;

        a.add(root.data);
        preorder(root.left, a);
        preorder(root.right, a);
    }

    public Node construct(int[] arr, int l, int r)
    {
        if(l > r)
            return null;

        int m = (l+r)/2;

        Node root = new Node(arr[m]);

        root.left = construct(arr, l, m-1);
        root.right = construct(arr, m+1, r);

        return root;
    }

    private Node inorderSuccessor(Node root)
    {
        Node cur = root.right;
        while(cur.left != null)
        {
            cur = cur.left;
        }
        return cur;
    }

    void inorder(Node root)
    {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

}


public class BinarySearchTree {
    public static void main(String[] args) {
        BST tree = new BST();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */

        Node root = null;

        root = tree.insert(root,50);
        root = tree.insert(root,30);
        root = tree.insert(root,20);
        root = tree.insert(root,40);
        root = tree.insert(root,70);
        root = tree.insert(root,60);
        root = tree.insert(root,80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder(root);

        System.out.println("\nDelete 20");
        root = tree.delete(root,20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(root);

        System.out.println("\nDelete 30");
        root = tree.delete(root,30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(root);

        System.out.println("\nDelete 50");
        root = tree.delete(root,50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder(root);
    }
}
