package DataStructures.Graph;

import java.util.Arrays;

class WriteDijkstra{
    public int[] shortestPathDist(int[][] graph, int source)
    {
        int vertices = graph.length;

        int[] dist = new int[vertices];
        boolean[] finalize = new boolean[vertices];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        for(int c=0; c<vertices; c++)
        {
            int u = -1;
            for(int i=0; i<vertices; i++)
            {
                if(!finalize[i] && (u == -1 || dist[u] > dist[i]))
                    u = i;
            }

            finalize[u] = true;

            for(int v=0; v<vertices; v++)
            {
                if(!finalize[v] && graph[u][v] != 0)
                    dist[v] = Math.min(dist[v], dist[u]+graph[u][v]);
            }
        }
        return dist;
    }
}

public class DijkstraAlgo {
    public static void main(String[] args) {

        //           1
         //    50 / |   \200
        //      /   |30  \
        //    0 - - 2----3
        //      100    20

        WriteDijkstra dj = new WriteDijkstra();

        int graph[][] = new int[][] { { 0, 50, 100, 0},
                                      { 50, 0, 30, 200 },
                                      { 100, 30, 0, 20 },
                                      { 0, 200, 20, 0 },};
        int source = 2;
        int[] dist = dj.shortestPathDist(graph, source);

        for(int i=0; i<dist.length; i++)
            System.out.println("From " + source + " to " + i + " is " + dist[i]);
    }
}
