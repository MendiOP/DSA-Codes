package DataStructures.Graph;

import java.util.Arrays;

class WriteKruskal {
    // A class to represent a graph edge
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        // Comparator function used for sorting edges
        // based on their weight
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {
        int parent, rank;
    }

    int V, E;
    Edge edge[];

    // Creates a graph with V vertices and E edges
    WriteKruskal(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i) {

        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void KruskalMST() {
        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        Arrays.sort(edge);

        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        int res = 0;

        while (e < V - 1) {

            Edge next_edge ;
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);

                res += next_edge.weight;
            }
        }

        System.out.println("Weight of MST is: " + res);
    }
}
public class KrusKalAlgo {
    public static void main(String[] args) {
        int V = 5; // Number of vertices in graph
        int E = 7; // Number of edges in graph
        WriteKruskal graph = new WriteKruskal(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 8;

        // add edge 0-3
        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 3;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        //add egde 2-4
        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 12;

        // add edge 3-4
        graph.edge[6].src = 3;
        graph.edge[6].dest = 4;
        graph.edge[6].weight = 15;

        graph.KruskalMST();
    }
}
