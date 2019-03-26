
public class GraphTest {
    public static void main(String[] args) {
        AdjGraph graph = new AdjGraph(5);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(3, 0);
        graph.addEdge(3, 2);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 3);
        System.out.println(graph);
        System.out.println("degree[0]="+graph.degree(0));
        graph.setDirected(true);
        System.out.println("directed="+graph.isDirected());

        System.out.println();

        graph = new AdjGraph(4);
        graph.addEdge(1, 0);
        graph.addEdge(2, 1);
        graph.addEdge(3, 2);
        System.out.println(graph);

        System.out.println();

        graph = new AdjGraph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        System.out.println(graph);
        graph.DFS();
        System.out.println();
        graph.BFS();
    }

}
