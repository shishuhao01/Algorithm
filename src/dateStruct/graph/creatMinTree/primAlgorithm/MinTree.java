package dateStruct.graph.creatMinTree.primAlgorithm;

import java.util.Arrays;

public class MinTree {
    public void creatMinGraph (Graph graph, int vertexes, char[] data, int[][] weight) {
        for (int i = 0; i < vertexes; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertexes; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void show (Graph graph) {
        for (int[] arr : graph.weight) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public void prim (Graph graph, int v1) {
        boolean[] isVisited = new boolean[graph.vertex];

        isVisited[v1] = true;
        int minWeight = 10000;

        int m1 = -1;
        int m2 = -1;
        for (int k = 1; k < graph.vertex; k++) {
            for (int i = 0; i < graph.vertex; i++) {
                for (int j = 0; j < graph.vertex; j++) {
                    if (isVisited[i] && !isVisited[j] && minWeight > graph.weight[i][j]) {
                        minWeight = graph.weight[i][j];
                        m1 = i;
                        m2 = j;
                    }
                }
            }
            System.out.println("边 <"+graph.data[m1]+","+graph.data[m2]+"> weight = " + minWeight);
            isVisited[m2] = true;
            minWeight = 10000;
        }
    }




}
