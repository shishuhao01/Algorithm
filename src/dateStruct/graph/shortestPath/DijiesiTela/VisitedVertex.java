package dateStruct.graph.shortestPath.DijiesiTela;

import java.util.Arrays;

public class VisitedVertex {
    public int[] already_arr; //记录顶点，访问过为1，没有访问过为0
    public int[] pre_visited; //每个下标对应一个前一个节点的顶点下标，会动态更新
    public int[] dis; //记录出发顶点到其他所有顶点的距离，最短距离放在dis里面

    /**
     *
     * @param length 表示顶点的个数
     * @param index 出发顶点对应的下标
     */
    public VisitedVertex (int length, int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        Arrays.fill(dis,65535);
        this.dis[index] = 0;//设置出发顶点到出发顶点的距离为0
        this.already_arr[index] = 1; //将出发顶点置为1
    }


    //判断顶点是否被访问过
    public boolean in (int index) {
        return already_arr[index] == 1;
    }

    //更新出发顶点到index 顶点的距离
    public void updateDis (int index, int len) {
        dis[index] = len;
    }

    //更新pre顶点的前驱节点为index
    public void updatePre (int pre,int index) {
        pre_visited[pre] = index;
    }

    //返回出发顶点到index的距离
    public int getDis (int index) {
        return dis[index];
    }

    //继续选择并访问新的节点，在未访问的节点里面找一个距离出发顶点距离最小的
    public int updateArr() {
        int min = 65535,index = 0;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i] == 0 && min > dis[i]) {
                min = dis[i];
                index = i;
            }
        }
        already_arr[index] = 1;
        return index;
    }



}
