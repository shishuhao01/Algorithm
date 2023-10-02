package dateStruct.graph.shortestPath.DijiesiTela;

import java.util.Arrays;

public class Graph {
    public char[] vertex; //顶点数组
    public int[][] matrix;//邻接矩阵
    VisitedVertex vv;


    public Graph (char[] vertex, int[][] matrix) {
        this.matrix = matrix;
        this.vertex = vertex;
    }

    public void show() {
        for (int[] link: matrix) {
            System.out.println(Arrays.toString(link));
        }
    }
    //创建vv类 实现算法
    public void djs(int index) {
        vv = new VisitedVertex(vertex.length, index);
        update(index);
        for (int i = 0; i < vertex.length; i++) {
            index = vv.updateArr();
            update(index);
        }
        show1();
    }


    //更新3个数组
    public void update (int index) {
        int len = 0;
        for (int i = 0; i < matrix[index].length; i++) {
            // 出发顶点到index 的距离 + index 到 i 顶点的和
            len = vv.getDis(index) + matrix[index][i];
            if (!vv.in(i) && len < vv.getDis(i)) {  //如果i顶点没有访问过  且 从index 这个顶点到i这个顶点的距离加上index到出发顶点的距离 < 直接从i这个顶点到出发点顶点的距离时
                vv.updateDis(i,len); //更新i这个顶点到出发顶点的近距离
                vv.updatePre(i,index); //更新i这个顶点的前驱节点为index
            }
        }
    }
    public void show1() {
        //打印结果数组
        System.out.println("====================");
        for (int i : vv.already_arr) {
            System.out.print(i+"   ");
        }
        System.out.println();
        System.out.println("====================");
        for (int i : vv.pre_visited) {
            System.out.print(i+"   ");
        }
        System.out.println();
        System.out.println("====================");
        char[] vertex = {'A','B','C','D','E','F','G'};
        int count = 0;
        for (int i: vv.dis) {
            System.out.print(vertex[count++]+ "("+i+")" + "   ");
        }

    }




}
