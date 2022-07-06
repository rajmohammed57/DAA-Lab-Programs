import java.util.*;

public class TopologicalOrdering {

    public int n;
    public int adjMat[][];
    public int incounter[];
    public int v[];

    public TopologicalOrdering() {
        n = 8;
        adjMat = new int[][]{
                {0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0},
                {0,0,0,1,1,0,0,1},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0}
        };
        incounter = new int[n];
        v = new int[n];
    }

    public int indegree(int v) {
        int count = 0;
        for(int i=0;i<n;i++)
            if(adjMat[i][v]!=0)
                count = count + 1;
        return count;
    }

    public void topological()
    {
        Stack<Integer> S = new Stack<Integer>();
        for(int u=0;u<n;u++)
        {
            incounter[u] = indegree(u);
            if(incounter[u]==0)
                S.push(u);
        }
        int i = 0;
        while(!S.empty())
        {
            int u = S.pop();
            v[i] = u;
            i = i+1;
            for(int e=0;e<n;e++)
            {
                if(adjMat[u][e]!=0)
                {
                    incounter[e] = incounter[e]-1;
                    if(incounter[e]==0)
                        S.push(e);
                }
            }
        }
        if(i>=n) {
            System.out.print("Topological Order: ");
            for (int k = 0; k < n; k++)
                System.out.print(v[k] + "  ");
            System.out.println();
        }
        else
            System.out.println("Digraph has a directed Cycle");
    }

    public static void main(String args[])
    {
        TopologicalOrdering t = new TopologicalOrdering();
        t.topological();
    }
}

// Time Complexity:  O(V+E)
