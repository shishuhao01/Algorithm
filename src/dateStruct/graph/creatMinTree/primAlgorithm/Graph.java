package dateStruct.graph.creatMinTree.primAlgorithm;

public class Graph {
    public int vertex;
    char[] data;
    int[][] weight;

    public Graph (int vertexes) {
        this.data = new char[vertexes];
        this.weight = new int[vertexes][vertexes];
        this.vertex = vertexes;
    }
}
