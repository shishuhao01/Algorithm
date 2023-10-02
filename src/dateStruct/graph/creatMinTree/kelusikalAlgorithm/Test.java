package dateStruct.graph.creatMinTree.kelusikalAlgorithm;

public class Test {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        //用INF表示不能联通
        int martix[][] = {
                {  0,  12, INF, INF, INF, 16,  14},
                { 12,   0,  10, INF, INF,  7, INF},
                {INF,  10,   0,   3,   5,  6, INF},
                {INF, INF,   3,   0,   4,INF, INF},
                {INF, INF,   5,   4,   0,  2,  8},
                { 16,   7,   6, INF,   2,  0,  9},
                { 14, INF, INF, INF,   8,  9,  0}
        };
        kelusikal kelusikal = new kelusikal(vertexs, martix);
        kelusikal.kuske(1);


    }
}
