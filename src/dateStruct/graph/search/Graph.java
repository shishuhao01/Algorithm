package dateStruct.graph.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
       isVisited[v1] = true;
       System.out.print(getByIndex(v1) + "==>");
       int v2 = findFirstNeighbor(v1);

       while (v2 != -1) {
           if (!isVisited[v2]) {
               deepFirstSearch(isVisited,v2);
           }
           v2 = findNextNeighbor(v1,v2);
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
       isVisited[v1] = true;
       System.out.print(getByIndex(v1) + "==>");
       LinkedList<Integer> queue = new LinkedList<>();
       queue.add(v1);
       while (!queue.isEmpty()) {
           int head = queue.poll();
           int first = findFirstNeighbor(head);
           while (first != -1) {
               if (!isVisited[first]) {
                   System.out.print(getByIndex(first) + "==>");
                   isVisited[first] = true;
                   queue.addLast(first);
               }
               first = findNextNeighbor(head,first);
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











}
