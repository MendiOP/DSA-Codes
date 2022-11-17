package DataStructures.Graph;

import java.util.Arrays;

class WritePrims{
    static final int V=4;
    public int primMST(int graph[][])
    {

        int[] key=new int[V];int res=0;
        Arrays.fill(key,Integer.MAX_VALUE);
        boolean[] mSet=new boolean[V]; key[0]=0;

        for (int count = 0; count < V ; count++)
        {
            int u = -1;

            for(int i=0;i<V;i++)
                if(!mSet[i]&&(u==-1||key[i]<key[u]))
                    u=i;
            mSet[u] = true;
            res+=key[u];


            for (int v = 0; v < V; v++)

                if (graph[u][v]!=0 && mSet[v] == false)
                    key[v] = Math.min(key[v],graph[u][v]);
        }
        return res;
    }
}

public class PrimsAlgo {
    public static void main(String[] args) {

        WritePrims prim = new WritePrims();

        int graph[][] = new int[][] { { 0, 5, 8, 0},
                                      { 5, 0, 10, 15 },
                                      { 8, 10, 0, 20 },
                                      { 0, 15, 20, 0 },};

        System.out.println("The minimum spanning tree cost will be : " + prim.primMST(graph));
    }
}
