public class DFS_Graph {

    public int vertices;
    public int adjMat[][];
    public int visited[];

    public DFS_Graph() {
        vertices = 8;
        visited = new int[vertices];
        adjMat = new int[][]{
                {0,1,1,0,0,0,0,0},
                {1,0,0,1,1,0,0,0},
                {1,0,0,0,0,1,1,0},
                {0,1,0,0,0,0,0,1},
                {0,1,0,0,0,0,0,1},
                {0,0,1,0,0,0,0,1},
                {0,0,1,0,0,0,0,1},
                {0,0,0,1,1,1,1,0}
        };

    }

    public void dfs(int s) {
            System.out.print(s + " ");
            visited[s] = 1;
            for (int j = 0; j < vertices; j++)
                if (adjMat[s][j] == 1 && visited[j] == 0)
                    dfs(j);
        
    }

    public static void main(String args[]) {
        DFS_Graph g = new DFS_Graph();
        System.out.println("DFS:");
        g.dfs(0);
    }

}
