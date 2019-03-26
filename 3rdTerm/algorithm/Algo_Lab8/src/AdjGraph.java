import java.util.LinkedList;

public class AdjGraph {
    private int graphArray[][];
    private int edge;
    private boolean directed;
    private boolean dfs[];
    private boolean bfs[];
    LinkedList<Integer> queue;

    public AdjGraph(int v) {
        graphArray = new int[v][v];
        edge = 0;
    }

    public void addEdge(int u, int v) {
        if (graphArray[u][v] == 0) {
            edge++;
        }
        graphArray[u][v] = 1;
        if (!directed) {
            graphArray[v][u] = 1;
        }
    }

    public int degree(int v) {
        int counter = 0;
        for (int i = 0; i < graphArray[v].length; i++) {
            if (graphArray[i][v] == 1) {
                counter++;
            }
        }
        return counter;
    }

    public int inDegree(int v) {
        int counter = 0;
        for (int i = 0; i < graphArray[v].length; i++) {
            if (graphArray[i][v] == 1) {
                counter++;
            }
        }
        return counter;
    }

    public int outDegree(int v) {
        int counter = 0;
        for (int i = 0; i < graphArray[v].length; i++) {
            if (graphArray[i][v] == 1) {
                counter++;
            }
        }
        return counter;
    }


    public void DFS() {
        dfs = new boolean[graphArray.length];
        for (int i = 0; i < graphArray.length; i++) {
            if (dfs[i] == false) {
                dfs(i);
            }
        }
    }

    private void dfs(int v) {
        System.out.println("visiting vertex " + v);
        dfs[v] = true;
        for (int i = 0; i < graphArray.length; i++) {
            if (graphArray[v][i] == 1) {
                if (dfs[i] == false) {
                    dfs(i);
                }
            }
        }
    }

    public void BFS() {
        bfs = new boolean[graphArray.length];
        for (int i = 0; i < graphArray.length; i++) {
            if (bfs[i] == false) {
                bfs(i);
            }
        }
    }

    private void bfs(int v) {
        System.out.println("visiting vertex " + v);
        bfs[v] = true;

        queue = new LinkedList<Integer>();
        queue.add(v);

        while (queue.size() != 0) {
            for (int i = queue.getFirst(); i < graphArray.length; i++) {
                if (graphArray[queue.getFirst()][i] == 1) {
                    if (bfs[i] == false) {
                        System.out.println("visiting vertex " + i);
                        bfs[i] = true;
                        queue.add(i);
                    }
                }
            }
            queue.poll();
        }
    }

    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < graphArray.length; i++) {
            for (int j = 0; j < graphArray[i].length; j++) {
                returnString += graphArray[i][j] + " ";
            }
            returnString += "\n";
        }
        return returnString;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

}
