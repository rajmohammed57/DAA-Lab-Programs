import java.util.*;

public class BFS_Graph {

    public int vertices;
    public int adjMat[][];

    public BFS_Graph() {
        vertices = 8;
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

    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        int visited[] = new int[vertices];
        System.out.print(s+" ");
        visited[s] = 1;
        q.add(s);
        while(!q.isEmpty()) {
            int i = q.remove();
            for(int j=0;j<vertices;j++) {
                if(adjMat[i][j]==1 && visited[j] ==0) {
                    System.out.print(j+" ");
                    visited[j] = 1;
                    q.add(j);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS_Graph b = new BFS_Graph();
        System.out.println("BFS:");
        b.bfs(0);
    }

}
