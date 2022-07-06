public class AllPairsShortestPathFloydWarshalls {

    int n;
    int cost[][];
    int A[][];

    public AllPairsShortestPathFloydWarshalls()
    {
        n = 3;
        cost = new int[][]{
                {0, 4, 11},
                {6, 0, 2},
                {3, Integer.MAX_VALUE, 0}
        };
        A = new int[n][n];
    }

    public void AllPairs()
    {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                A[i][j] = cost[i][j];
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    A[i][j] = Math.min(A[i][j],A[i][k]+A[k][j]);
    }



    public void displayA()
    {
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++)
                System.out.print(A[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        AllPairsShortestPathFloydWarshalls apsp = new AllPairsShortestPathFloydWarshalls();
        apsp.AllPairs();
        apsp.displayA();
    }


}

// Time complexity: O(V^3)
