package dateStruct.graph.search;

public class dfsAndBfsTest {

    public static void main(String[] args) {
        int n = 8;

        String Vertexs[] = {"A","B","C","D","E","F","G","H"};

        Graph graph = new Graph(n);

        for (String vertex : Vertexs) {
            graph.addVertex(vertex);
        }

        graph.addEdges(0,1,1);
        graph.addEdges(1,3,1);
        graph.addEdges(1,4,1);
        graph.addEdges(3,7,1);
        graph.addEdges(4,7,1);
        graph.addEdges(2,5,1);
        graph.addEdges(2,6,1);
        graph.addEdges(5,6,1);

        graph.show();
        System.out.println(graph.getEdgeNum());
        graph.breathFirstSearch();
    }
}
