package dateStruct.graph.creatMinTree.primAlgorithm;

public class PrimTest {
    public static void main(String[] args) {
        char[] data ={'A','B','C','D','E','F','G'};
        int vertex = data.length;
        int [][]weight = new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };

        Graph graph = new Graph(vertex);

        MinTree minTree = new MinTree();
        minTree.creatMinGraph(graph,vertex,data,weight);

        minTree.show(graph);

        minTree.prim(graph,0);



    }
}
