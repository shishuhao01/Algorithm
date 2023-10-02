package dateStruct.graph.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    public ArrayList<String> list;
    public int edgeNum;
    public int[][] matrix;
    public boolean[] isVisited;

   public Graph (int vertexes) {
       this.list = new ArrayList<>();
       this.matrix = new int[vertexes][vertexes];
       this.isVisited = new boolean[vertexes];
       this.edgeNum = 0;
   }

   public void addEdges (int v1, int v2, int weight) {
       this.matrix[v1][v2] = weight;
       this.matrix[v2][v1] = weight;
       this.edgeNum++;
   }

   public void addVertex (String vertex) {
       this.list.add(vertex);
   }

   public int getEdgeNum () {
       return this.edgeNum;
   }

   public String getByIndex (int v1) {
       return list.get(v1);
   }

   public int findFirstNeighbor (int v1) {
       for (int i = 0; i < edgeNum; i++) {
           if (matrix[v1][i] != 0) {
               return i;
           }
       }
       return -1;
   }

   public int findNextNeighbor (int v1, int v2) {
       for (int i = v2 + 1; i < matrix.length; i++) {
           if (matrix[v1][i] != 0) {
               return i;
           }
       }
       return -1;
   }


   public void deepFirstSearch (boolean[] isVisited, int v1) {
       //深度优先遍历
       isVisited[v1] = true;
       System.out.print(getByIndex(v1)+"==>");
       int next = findFirstNeighbor(v1);
       while (next != -1) {
           if (!isVisited[next]) {
               deepFirstSearch(isVisited,next);
           }
           next = findNextNeighbor(v1,next);
       }


   }

   public void deepFirstSearch () {
       for (int i = 0; i < matrix.length; i++) {
           if (!isVisited[i]) {
               deepFirstSearch(isVisited,i);
           }
       }
   }

   public void show () {
       for (int[] arr: matrix) {
           System.out.println(Arrays.toString(arr));
       }
   }


  public void breathFirstSearch (boolean[] isVisited, int v1) {
       // 广度优先遍历
      isVisited[v1] = true;
      System.out.print(getByIndex(v1)+"==>");
      Queue<Integer> queue = new LinkedList<>();
      queue.add(v1);
      while (!queue.isEmpty()) {
          int next = queue.poll();
          int w = findFirstNeighbor(next);
          while (w != -1) {
              if (!isVisited[w]) {
                  isVisited[w] = true;
                  System.out.print(getByIndex(w)+"==>");
                  queue.add(w);
              }
              w = findNextNeighbor(next,w);
          }
      }
  }

    public void breathFirstSearch () {
        for (int i = 0; i < matrix.length; i++) {
            if (!isVisited[i]) {
                breathFirstSearch(isVisited,i);
            }
        }
    }





    //拓扑排序 解决所有点的问题，但是有的点是需要后来访问，

}
