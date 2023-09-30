package dateStruct.graph.creatMinTree.kelusikalAlgorithm;

public class kelusikal {
    private int edgeNums;
    private char[] vertexes;
    private int[][] weight;
    private static final int INF = Integer.MAX_VALUE;


    public kelusikal (char[] vertexes, int[][] weight) {
        this.vertexes = vertexes;
        this.weight = weight;
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (weight[i][j] != INF) {
                    this.edgeNums++;
                }
            }
        }
    }

    public void kuske (int v1) {
        EdgesData[] edges = getEdges();
        EdgesData[] minTree = new EdgesData[edges.length];
        sortEdges(edges);
        int index = 0;
        int[] rets = new int[edgeNums];

        for (int i = 0; i < edges.length; i++) {
            int start = getPosition(edges[i].start);
            int end = getPosition(edges[i].end);
            int end1 = getEnd(rets, start);
            int end2 = getEnd(rets, end);
            if (end1 != end2) {
                minTree[index++] = edges[i];
                rets[end1] = end2;
            }
        }
        for (int i = 0; i < minTree.length; i++) {
            if (minTree[i] != null) {
                System.out.println(minTree[i]);
            }
        }
    }

    public EdgesData[] getEdges () {
        EdgesData[] rets = new EdgesData[this.edgeNums];
        int index = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (weight[i][j] != INF) {
                    rets[index++] = new EdgesData(vertexes[i], vertexes[j], weight[i][j]);
                }
            }
        }
        return rets;
    }

    public void sortEdges (EdgesData[] edgesData) {
        for (int i = 0; i < edgesData.length; i++) {
            for (int j = 0; j < edgesData.length - i -1; j++) {
                if (edgesData[j].weight > edgesData[j+1].weight) {
                    EdgesData temp = edgesData[j];
                    edgesData[j] = edgesData[j+1];
                    edgesData[j+1] = temp;
                }
            }

        }
    }

    public int getPosition (char ch) {
        for (int i = 0; i < vertexes.length; i++) {
            if (vertexes[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public int getEnd (int[] end, int v1) {
        while (end[v1] != 0) {
            v1 = end[v1];
        }
        return v1;
    }




}
