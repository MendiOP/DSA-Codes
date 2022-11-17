package DataStructures.Graph;

import java.util.LinkedList;
import java.util.Queue;

class Solution
{
    //Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid)
    {
        // Code here

        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                    q.add(new Node(0, i, j));
            }
        }

        int t=0;
        Node node=null;;
        while(!q.isEmpty())
        {
            node = q.poll();

            if(isValid(node.x+1, node.y, m, n) && grid[node.x+1][node.y] == 1)
            {
                grid[node.x+1][node.y] = 2;
                q.add(new Node(node.time+1, node.x+1, node.y));
            }

            if(isValid(node.x-1, node.y, m, n) && grid[node.x-1][node.y] == 1)
            {
                grid[node.x-1][node.y] = 2;
                q.add(new Node(node.time+1, node.x-1, node.y));
            }

            if(isValid(node.x, node.y+1, m, n) && grid[node.x][node.y+1] == 1)
            {
                grid[node.x][node.y+1] = 2;
                q.add(new Node(node.time+1, node.x, node.y+1));
            }

            if(isValid(node.x, node.y-1, m, n) && grid[node.x][node.y-1] == 1)
            {
                grid[node.x][node.y-1] = 2;
                q.add(new Node(node.time+1, node.x, node.y-1));
            }

        }

        t = node.time;
        boolean f = true;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    f = false;
                }
            }
        }

        if(f)
            return t;

        return -1;
    }

    boolean isValid(int i, int j, int m, int n)
    {
        return (i >= 0 && j >= 0 && i < m && j < n);
    }

    class Node{
        int time;
        int x, y;

        Node(int time, int x, int y)
        {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }
}

public class RottenOranges {
    public static void main(String[] args) {

    }
}
