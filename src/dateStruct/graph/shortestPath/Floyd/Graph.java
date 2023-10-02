package dateStruct.graph.shortestPath.Floyd;

import java.util.Arrays;

public class Graph {
    public char[] vertex; // 顶点
    public int[][] dis;//保存各个顶点出发到其他顶点的距离，
    public int[][] pre;//保存到达目标节点的前驱节点



    public Graph (int length, int[][] matrix, char[] vertex) {

        this.vertex = vertex;
        this.pre = new int[length][length];
        this.dis = matrix;

        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void show () {

        char[] vertex = {'A','B','C','D','E','F','G'};
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]]+ " ");
            }
            System.out.println();
            for (int i = 0; i < dis.length; i++) {
                System.out.print("("+vertex[k]+"到"+vertex[i]+"最短路径为"+dis[k][i] +")");
            }
            System.out.println();
            System.out.println();


        }
    }

    public void Floyd () {
        int len = 0;
        //k 为中间节点 i 为起始节点 j为终点

        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                for(int j = 0; j < dis.length; j++) {
                    len = dis[i][k] + dis[k][j];
                    if (len < dis[i][j]) {
                        dis[i][j] = len; //更新距离
                        pre[i][j] = pre[k][j]; // 更新前驱节点
                    }
                }
            }
        }
    }
}
