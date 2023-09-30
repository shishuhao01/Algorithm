package dateStruct.graph.creatMinTree.kelusikalAlgorithm;

public class EdgesData {
    public char start;
    public char end;
    public int weight;
    public EdgesData (char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public String toString() {
        return
                "<" + start +
                        "," + end +
                        ">  weight=" + weight;
    }

    public EdgesData() {
    }
}
