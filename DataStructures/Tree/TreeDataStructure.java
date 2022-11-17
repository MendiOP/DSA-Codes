package DataStructures.Tree;

import java.util.*;

class TreeNode{
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;
    public TreeNode nextRight;

    TreeNode(int data)
    {
        this.data = data;
        leftChild = null;
        rightChild = null;
        nextRight = null;
    }
}

class TreeOperations{

    public void inOrderTraversal(TreeNode root)
    {
        if(root == null)
            return;

        inOrderTraversal(root.leftChild);
        System.out.print(root.data + " ");
        inOrderTraversal(root.rightChild);
    }

    public void inOrderTraversalIT(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;

        while(treeNode != null || !stack.isEmpty())
        {
            while(treeNode != null)
            {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            treeNode = stack.pop();
            System.out.print(treeNode.data + " ");
            treeNode = treeNode.rightChild;
        }
    }

    public void preOrderTraversal(TreeNode root)
    {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    public void preOrderTraversalIT(TreeNode root)
    {
        Stack<TreeNode> stack =new Stack<>();

        if(root == null)
            return;

        TreeNode treeNode = root;
        stack.push(treeNode);
        while(!stack.isEmpty())
        {
            treeNode = stack.pop();
            System.out.print(treeNode.data + " ");

            if(treeNode.rightChild != null)
                stack.push(treeNode.rightChild);

            if(treeNode.leftChild != null)
                stack.push(treeNode.leftChild);


        }
    }

    public void postOrderTraversal(TreeNode root)
    {
        if(root == null)
            return;

        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.print(root.data + " ");
    }

    //Given a binary tree, find height of it.
    // Height of empty tree is 0, height of tree with one node is 1.
    // 1. recursion 2.BF traversal
    public int heightOfTree(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftheight = heightOfTree(root.leftChild);
        int rightheight = heightOfTree(root.rightChild);

        return Math.max(leftheight, rightheight) + 1;
    }

    public int heightUsingBF(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        int h=1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty())
        {
            TreeNode treeNode = q.poll();

            if(treeNode == null)
                h++;

            if(treeNode != null)
            {
                if(treeNode.leftChild != null)
                    q.add(treeNode.leftChild);
                if(treeNode.rightChild != null)
                    q.add(treeNode.rightChild);
            }
            else if(!q.isEmpty())
                q.add(null);
        }
        return h;
    }

    public void distanceAtK(TreeNode root, int k)
    {
        if(root == null) return;

        if(k == 0) {
            System.out.print(root.data + " ");
            return;
        }

        distanceAtK(root.leftChild, k-1);
        distanceAtK(root.rightChild,k-1);
    }

    //level order traversal
    public void BreadtFirstTraversal(TreeNode root)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            TreeNode treeNode = q.poll();
            System.out.print(treeNode.data + " ");

            if(treeNode.leftChild != null)
                q.add(treeNode.leftChild);

            if(treeNode.rightChild != null)
                q.add(treeNode.rightChild);
        }
    }

    //Problem: Given a Binary Tree and a Key.
    // The task is to insert the key into the binary tree at first position available in level order.
    public void insertNode(TreeNode root, int data)
    {
        Queue<TreeNode> q = new LinkedList<>();

        TreeNode child = new TreeNode(data);

        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode tree = q.poll();

            if(tree.leftChild == null){
                tree.leftChild = child;
                break;
            }
            else{
                q.add(tree.leftChild);
            }

            if(tree.rightChild == null){
                tree.rightChild = child;
                break;
            }
            else{
                q.add(tree.rightChild);
            }
        }
    }

    //Problem: Given a Binary Tree and a node to be deleted from this tree.
    // The task is to delete the given node from it. The node to be deleted will be the right most node conventionally.
    public void deleteNode(TreeNode root, int data)
    {

        if(root == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();

        TreeNode nodeTobeDeleted=null;
        TreeNode tree=null;

        q.add(root);
        while(!q.isEmpty())
        {
            tree = q.poll();

            if(tree.data == data)
                nodeTobeDeleted = tree;

            if(tree.leftChild != null)
                q.add(tree.leftChild);

            if(tree.rightChild != null)
                q.add(tree.rightChild);
        }



        int key = tree.data;
        deleteLastNode(root, tree);
        nodeTobeDeleted.data = key;
    }

    private void deleteLastNode(TreeNode root, TreeNode tree)
    {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode temp;

        q.add(root);
        while(!q.isEmpty())
        {
            temp = q.poll();

            if(temp.rightChild != null){
                if(temp.rightChild == tree){
                    temp.rightChild = null;
                    return;
                }
                else{
                    q.add(temp.rightChild);
                }
            }

            if(temp.leftChild != null){
                if(temp.leftChild == tree){
                    temp.leftChild = null;
                    return;
                }
                else{
                    q.add(temp.leftChild);
                }
            }
        }
    }

    //Size of a binary tree(number of nodes in it)
    //1.reecursion 2.Level order
    public int sizeOfTreeRecursive(TreeNode root)
    {
        if(root == null)
            return 0;

        return sizeOfTreeRecursive(root.leftChild) + sizeOfTreeRecursive(root.rightChild) + 1;
    }

    public int sizeOfTreeBF(TreeNode root)
    {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int count=0;
        while(!q.isEmpty())
        {
            TreeNode tree = q.poll();
            count++;

            if(tree.leftChild != null)
                q.add(tree.leftChild);
            if(tree.rightChild != null)
                q.add(tree.rightChild);
        }
        return count;
    }

    //Maximum in a binary tree. Very good in perfect tree.
    public int maximumInTree(TreeNode root)
    {
        int max = Integer.MIN_VALUE;

        if(root == null)
            return max;

        max = Math.max(root.data, Math.max(maximumInTree(root.leftChild), maximumInTree(root.rightChild)));
        return max;
    }

    //very efficient in skewed tree
    public int maximumInTreeBF(TreeNode root)
    {
        int max = Integer.MIN_VALUE;

        if(root == null)
            return max;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            TreeNode tree = q.poll();

            if(max < tree.data)
                max = tree.data;

            if(tree.leftChild != null)
                q.add(tree.leftChild);

            if(tree.rightChild != null)
                q.add(tree.rightChild);
        }
        return max;
    }

    public boolean isIdentical(TreeNode root1, TreeNode root2)
    {
        // Code Here

        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if(root1.data != root2.data)
            return false;

        return isIdentical(root1.leftChild, root2.leftChild) && isIdentical(root1.rightChild, root2.rightChild);
    }

    //Function to check whether all nodes of a tree have the value
    //equal to the sum of their child nodes.
    public static int isSumProperty(TreeNode root)
    {
        // add your code here
        if(root == null)
            return 1;

        if(root.leftChild == null && root.rightChild == null)
            return 1;

        int sum=0;

        if(root.leftChild != null)
            sum += root.leftChild.data;

        if(root.rightChild != null)
            sum += root.rightChild.data;

        if(sum == root.data){
            return isSumProperty(root.leftChild) & isSumProperty(root.rightChild);
        }

        return 0;
    }
    //level order traversal and storing in 2D list
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode node)
    {
        // Your code here
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();


        if(node  == null)
            return a;

        q.add(node);

        while (!q.isEmpty())
        {
            int l = q.size();

            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<l; i++)
            {
                TreeNode treeNode = q.poll();
                temp.add(treeNode.data);

                if(treeNode.leftChild != null)
                    q.add(treeNode.leftChild);

                if(treeNode.rightChild != null)
                    q.add(treeNode.leftChild);
            }

            a.add(temp);
        }
        return a;
    }

    //Function to return a list containing the level order
    //traversal in spiral form.
    ArrayList<Integer> findSpiral(TreeNode root)
    {
        // Your code here

        ArrayList<Integer> a = new ArrayList<>();

        if(root == null)
            return a;

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        boolean leftToRight = true;

        currentLevel.add(root);

        while(!currentLevel.isEmpty())
        {
            TreeNode tree = currentLevel.pop();

            if(tree != null)
            {
                a.add(tree.data);

                if(leftToRight){
                    if(tree.leftChild != null)
                        nextLevel.push(tree.leftChild);
                    if(tree.rightChild != null)
                        nextLevel.push(tree.rightChild);
                }
                else{
                    if(tree.rightChild != null)
                        nextLevel.push(tree.rightChild);
                    if(tree.leftChild != null)
                        nextLevel.push(tree.leftChild);
                }
            }

            if(currentLevel.isEmpty()){

                leftToRight = !leftToRight;
                Stack<TreeNode> temp;

                temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }

        return a;
    }

    //return the maximum width of a binary tree
    public int maximumWidth(TreeNode root)
    {
        int max = 0;

        if(root == null)
            return max;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty())
        {
            int l = q.size();
            max = Math.max(l, max);

            for(int i=0; i<l; i++)
            {
                TreeNode treeNode = q.poll();

                if(treeNode.leftChild != null)
                    q.add(treeNode.leftChild);
                if(treeNode.rightChild != null)
                    q.add(treeNode.rightChild);
            }
        }
        return max;
    }

    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(TreeNode root)
    {
        // Your code here
        if(root == null)
            return false;

        int d = Math.abs(heightOfTree(root.leftChild) - heightOfTree(root.rightChild));

        if(d > 1)
            return false;

        return isBalanced(root.leftChild) & isBalanced(root.rightChild);

    }

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(TreeNode node)
    {
        // Your code here
        ArrayList<Integer> a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(node == null)
            return a;

        q.add(node);
        while(!q.isEmpty())
        {
            int s = q.size();

            for(int i=0; i<s; i++)
            {
                TreeNode tree = q.poll();

                if(i == 0)
                    a.add(tree.data);

                if(tree.leftChild != null)
                    q.add(tree.leftChild);
                if(tree.rightChild != null)
                    q.add(tree.rightChild);
            }
        }
        return a;
    }

    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(TreeNode node)
    {
        //add code here.
        ArrayList<Integer> a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(node == null)
            return a;

        q.add(node);
        while(!q.isEmpty())
        {
            int s = q.size();

            for(int i=0; i<s; i++)
            {
                TreeNode tree = q.poll();

                if(i+1 == s)
                    a.add(tree.data);

                if(tree.leftChild != null)
                    q.add(tree.leftChild);
                if(tree.rightChild != null)
                    q.add(tree.rightChild);
            }
        }
        return a;
    }

    public ArrayList<Integer> topview(TreeNode root)
    {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        if(root == null)
            return a;

        q.add(new Pair(0, root));
        while(!q.isEmpty())
        {
            Pair p = q.poll();

            if(!hm.containsKey(p.hd))
                hm.put(p.hd, p.node.data);

            if(p.node.leftChild != null)
                q.add(new Pair(p.hd-1, p.node.leftChild));

            if(p.node.rightChild != null)
                q.add(new Pair(p.hd+1, p.node.rightChild));
        }

        for(int k : hm.keySet())
            a.add(hm.get(k));
        return a;
    }

    public ArrayList<Integer> bottomview(TreeNode root)
    {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();

        if(root == null)
            return a;

        q.add(new Pair(0, root));
        while(!q.isEmpty())
        {
            Pair p = q.poll();

            hm.put(p.hd, p.node.data);

            if(p.node.leftChild != null)
                q.add(new Pair(p.hd-1, p.node.leftChild));

            if(p.node.rightChild != null)
                q.add(new Pair(p.hd+1, p.node.rightChild));
        }

        for(int k : hm.keySet())
            a.add(hm.get(k));
        return a;
    }

    //Function to return the lowest common ancestor in a Binary Tree.
    TreeNode lca(TreeNode root, int n1,int n2)
    {
        // Your code here

        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        TreeNode left = lca(root.leftChild, n1, n2);
        TreeNode right = lca(root.rightChild, n1, n2);

        if(left == null && right == null)
            return null;

        if(left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    // Function to return the diameter of a Binary Tree.
    int diameter(TreeNode root)
    {
        // Your code here

        if(root == null)
            return 0;

        int leftH = heightOfTree(root.leftChild);
        int rightH = heightOfTree(root.rightChild);

        int leftD = diameter(root.leftChild);
        int rightD = diameter(root.rightChild);

        return Math.max((Math.max(1+leftH+rightH, leftD)) , rightD);
    }

    // Function to convert a binary tree into its mirror tree.
    void mirror(TreeNode node)
    {
        // Your code here

        if(node == null)
            return;

        mirror(node.leftChild);
        mirror(node.rightChild);

        TreeNode t = node.leftChild;
        node.leftChild = node.rightChild;
        node.rightChild = t;
    }

    //Check if subtree
    public boolean isSubtree(TreeNode T, TreeNode S)
    {
        // add code here.
        if(T == null)
            return false;

        if(S == null)
            return false;

        if(isIdentical(T, S))
            return true;

        return isSubtree(T.leftChild, S) || isSubtree(T.rightChild, S);
    }

    //Function to make binary tree from linked list.
    public static TreeNode convert(Node head, TreeNode node)
    {
        // add code here.
        Node cur = head;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(cur.data);
        cur=cur.next;
        q.add(root);
        while(cur != null)
        {
            TreeNode temp = q.poll();
            temp.leftChild= new TreeNode(cur.data);
            cur = cur.next;
            q.add(temp.leftChild);

            if(cur != null)
            {
                temp.rightChild = new TreeNode(cur.data);
                cur = cur.next;
                q.add(temp.rightChild);
            }
        }
        return root;
    }

    //This function should return head to the DLL
    private TreeNode prev = null;
    private TreeNode head = null;
    TreeNode bToDLL(TreeNode root)
    {
        if(root==null) return null;

        bToDLL(root.leftChild);
        if(prev==null) head = root;

        else{
            root.leftChild = prev;
            prev.rightChild = root;
        }
        prev = root;

        bToDLL(root.rightChild);
        return head;
    }

    //Function to convert binary tree into circular doubly linked list.
    TreeNode bTreeToClist(TreeNode root)
    {
        //your code here
        TreeNode head = dLL(root);
        TreeNode curr = head;
        while(curr.rightChild!=null){
            curr = curr.rightChild;
        }
        head.leftChild = curr;
        curr.rightChild = head;
        return head;

    }

    //function to covert in doubly linked list
    TreeNode dLL(TreeNode root)
    {
        if(root == null) return root;

        TreeNode head = dLL(root.leftChild);
        if(prev == null)
            head = root;
        else{
            root.leftChild = prev;
            prev.rightChild = root;

        }
        prev = root;
        dLL(root.rightChild);
        return head;
    }

    //Function to construct binary tree from parent array.
    public static TreeNode createTree(int[] parent, int n)
    {
        //Your code here
        TreeNode root = null;
        TreeNode[] tree = new TreeNode[n];
        for(int i=0;i<n;i++) {
            tree[i] = new TreeNode(i);
        }
        for(int i=0;i<n;i++) {
            if(parent[i] == -1) {
                root = tree[i];
            }else {
                if(tree[parent[i]].leftChild == null) {
                    tree[parent[i]].leftChild= tree[i];
                }else {
                    tree[parent[i]].rightChild = tree[i];
                }
            }
        }
        return root;
    }

    //Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(TreeNode root)
    {
        // your code
        if(root == null)
            return false;

        return isFoldable(root.leftChild, root.rightChild);
    }

    boolean isFoldable(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)
            return true;

        if(left== null || right == null)
            return false;

        return isFoldable(left.rightChild, right.leftChild) && isFoldable(left.leftChild, right.rightChild);
    }

    ////Function to return maximum path sum from any node in a tree.
    // HARDEST I EVER SOLVED :)
    private int ans = Integer.MIN_VALUE;
    int findMaxSum(TreeNode root)
    {
        //your code goes here
        return Math.max(ans, solve(root));
    }

    int solve(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftSum = solve(root.leftChild);
        int rightSum = solve(root.rightChild);

        int updateLeft = Math.max(leftSum, 0);
        int updateRight = Math.max(rightSum, 0);

        ans = Math.max(ans, updateLeft+updateRight+root.data);

        return root.data + Math.max(updateLeft, updateRight);
    }

    //Function to connect nodes at same level.
    public void connect(TreeNode root)
     {
        // Your code goes here.

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int l = q.size();
            TreeNode prev = null;

            for (int i = 0; i < l; i++) {
                TreeNode t = q.poll();

                if (prev != null)
                    prev.nextRight= t;
                prev = t;

                if (t.leftChild != null)
                    q.add(t.leftChild);
                if (t.rightChild != null)
                    q.add(t.rightChild);
            }
        }
    }



    static class Pair{
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node){
            this.hd = hd;
            this.node = node;
        }
    }
    static class Node{
        int data;
        Node next,prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}

public class TreeDataStructure {

    //              10
    //             /   \
    //            20    30
    //           /     /  \
    //          60    40  50
    //         /  \   / \  / \
    //       90  100 12 4  7  2

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.leftChild = new TreeNode(20);
        root.rightChild = new TreeNode(30);
        root.leftChild.leftChild = new TreeNode(60);
        root.rightChild.leftChild = new TreeNode(40);
        root.rightChild.rightChild = new TreeNode(50);
        root.leftChild.leftChild.leftChild = new TreeNode(90);
        root.leftChild.leftChild.rightChild = new TreeNode(100);
        root.rightChild.leftChild.leftChild = new TreeNode(12);
        root.rightChild.leftChild.rightChild = new TreeNode(4);
        root.rightChild.rightChild.leftChild = new TreeNode(7);
        root.rightChild.rightChild.rightChild = new TreeNode(2);

        TreeOperations tree = new TreeOperations();
        System.out.print("Inorder Traversal : ");
        tree.inOrderTraversalIT(root);
        System.out.print("\nPreorder Traversal : ");
        tree.preOrderTraversalIT(root);
        System.out.print("\nPostorder Traversal : ");
        tree.postOrderTraversal(root);
        System.out.println();
        System.out.println("The height is : " + tree.heightOfTree(root));

        //tree.distanceAtK(root,2);
//        System.out.print("Before Deleting : ");
//        tree.BreadtFirstTraversal(root);
//
//        tree.deleteNode(root, 10);
//
//        System.out.print("\nAfter Deleting  : ");
//        tree.BreadtFirstTraversal(root);

        System.out.println("The size is : " + tree.sizeOfTreeBF(root));
        System.out.println(tree.maximumInTreeBF(root));

        System.out.println("The width is : " + tree.maximumWidth(root));
        System.out.println("The top view is : " + tree.topview(root));
        System.out.println("The bottom view is : " + tree.bottomview(root));
    }
}
