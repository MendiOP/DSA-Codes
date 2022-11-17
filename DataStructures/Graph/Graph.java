package DataStructures.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GraphOperation{

    public void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public void BFS(ArrayList<ArrayList<Integer>> graph, int source, int vertices)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices+1];

        visited[source] = true;
        q.add(source);
        while(!q.isEmpty())
        {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : graph.get(u))
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    private void BFS(ArrayList<ArrayList<Integer>> graph, int source, boolean[] visited)
    {
        Queue<Integer> q = new LinkedList<>();

        visited[source] = true;
        q.add(source);
        while(!q.isEmpty())
        {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : graph.get(u))
            {
                if(!visited[v])
                {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public int connectedComponentbyBFS(ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        boolean[] visited = new boolean[vertices+1];
        int connectedComponent=0;
        for(int i=0; i<vertices; i++)
        {
            if(!visited[i]){
                BFS(graph, i, visited);
                connectedComponent++;
            }
        }
        return connectedComponent;
    }

    public void DFS(ArrayList<ArrayList<Integer>> graph, int source, int vertices)
    {
        boolean[] visited = new boolean[vertices];
        recursiveDFS(graph, source, visited);
    }

    private void recursiveDFS(ArrayList<ArrayList<Integer>> graph, int source, boolean[] visited)
    {
        visited[source] = true;
        System.out.print(source + " ");

        for(int u : graph.get(source))
        {
            if(!visited[u])
                recursiveDFS(graph, u, visited);
        }
    }

    // for undirected graph
    public boolean hasCycle(ArrayList<ArrayList<Integer>> graph)
    {
        boolean[] visited = new boolean[graph.size()+1];

        for(int i=0; i<graph.size(); i++)
        {
            if(!visited[i])
                if(checkCycle(graph, i, visited, -1))
                    return true;
        }
        return false;
    }

    private boolean checkCycle(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited, int parent)
    {
        visited[u] = true;
        for(int v : graph.get(u))
        {
            if(!visited[v])
            {
                if(checkCycle(graph, v, visited, u))
                    return true;
            }
            else if(v != parent)
                return true;
        }
        return false;
    }

    public boolean hasCycleInDirectedGraph(ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        boolean[] visited = new boolean[vertices];
        boolean[] recursionST = new boolean[vertices];

        for(int i=0; i<vertices; i++)
        {
            if(!visited[i])
                if(checkCycleInDirectedGraph(graph, i, visited, recursionST))
                    return true;
        }
        return false;
    }

    private boolean checkCycleInDirectedGraph(ArrayList<ArrayList<Integer>> graph, int v, boolean[] visited, boolean[] recursionST)
    {
        visited[v] = true;
        recursionST[v] = true;

        for(int u : graph.get(v))
        {
            if(!visited[u] && checkCycleInDirectedGraph(graph, u, visited, recursionST))
                return true;
            else if(recursionST[u])
                return true;
        }
        recursionST[v] = false;
        return false;
    }

    public void topologicalSortUsingDFS(ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<vertices; i++)
        {
            if(!visited[i])
            {
                topDFS(graph, i, visited, stack);
            }
        }

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private void topDFS(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited, Stack<Integer> stack)
    {
        visited[u] = true;

        for(int v : graph.get(u))
        {
            if(!visited[v])
                topDFS(graph, v, visited, stack);
        }

        stack.push(u);
    }

    public void topologicalSortKahnAlgo(ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        int[] indegree = new int[vertices];

        for(int i=0; i<vertices; i++)
        {
            for(int u : graph.get(i))
                indegree[u]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indegree.length; i++)
            if(indegree[i] == 0)
                q.add(i);

        while(!q.isEmpty())
        {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v : graph.get(u))
            {
                indegree[v]--;
                if(indegree[v] == 0)
                    q.add(v);
            }
        }
    }

    // kahn's algorithm for checking cycle in directed graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();

        int[] in = new int[V];

        for(int i=0; i<V; i++)
        {
            for(int u : adj.get(i))
                in[u]++;
        }

        for(int i=0; i<V; i++)
            if(in[i] == 0)
                q.add(i);

        int c=0;
        while(!q.isEmpty())
        {
            int u = q.poll();

            for(int v : adj.get(u))
            {
                in[v]--;
                if(in[v] == 0)
                    q.add(v);
            }

            c++;
        }

        return c != V;
    }
}

public class Graph {
    public static void main(String[] args) {

        //    1 - - - - 3
        //   /|       /  |
        //  / |     /    |
        // 0  |   /      |
        //  \ |  /       |
        //   \|/         |
        //    2 - - - -  4

        GraphOperation g = new GraphOperation();

        int vertices = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<vertices; i++)
            graph.add(new ArrayList<>());


        g.addEdge(graph, 0, 1);
        g.addEdge(graph, 0, 2);
        g.addEdge(graph, 1, 2);
        g.addEdge(graph, 2, 3);
        g.addEdge(graph, 3, 4);
        g.addEdge(graph, 1, 3);
        g.addEdge(graph, 2, 4);

        //g.BFS(graph, 4);
        //g.DFS(graph, 3, 5);

        GraphOperation g2 = new GraphOperation();
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for(int i=0; i<vertices; i++)
            graph2.add(new ArrayList<>());

        g2.addEdge(graph2, 0, 1);
        g2.addEdge(graph2, 0, 2);
        g2.addEdge(graph2, 0, 4);
        g2.addEdge(graph2, 1, 3);
        g2.addEdge(graph2, 1, 4);
        g2.addEdge(graph2, 2, 4);
        g2.addEdge(graph2, 3, 2);
        g2.DFS(graph2, 1, 5);
//        System.out.println(g.hasCycle(graph));
//        g.topologicalSortUsingDFS(graph, 5);
    }
}
