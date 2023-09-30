package algorithm.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0,4532,54,34,56,3,6,546,745,74};
        Sort(arr);
        System.out.println(Arrays.toString(arr));

//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//        int count = 0;
//        int begin = 0;
//        boolean flag = true;
//
//        for(int i = 0; i < a.length(); i++){
//            if(a.charAt(i) != ' ' && flag == true){
//                count += 1;
//                flag = false;
//            }else if(a.charAt(i) == ' ' && flag == false){
//                flag = true;
//            }
//        }
//        System.out.println(count);


//
//        Scanner scanner = new Scanner(System.in);
//        String a = scanner.nextLine();
//
//        int begin = 0;
//        String b = "";
//        boolean flag = true;
//        int i = 0;
//        for(i = 0; i < a.length(); i++){
//            if(a.charAt(i) != ' ' && flag == true){
//                begin = i;
//                flag = false;
//            }else if(a.charAt(i) == ' '){
//                if(flag == false){
//                    flag = true;
//                    b = a.substring(begin,i) + b;
//                    b = a.charAt(i) + b;
//                }else{
//                    b = a.charAt(i) + b;
//                }
//            }
//        }
//        if(flag == false){
//            b = a.substring(begin,i)+b;
//        }
//        System.out.println(b);




    }
    public static void Sort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        int gap = arr.length / 2;
         while(gap != 0) {
           for(int i = gap; i < arr.length; i++) {
              insertVal = arr[i];
              insertIndex = i - gap;
              while(insertIndex >= 0 && arr[insertIndex] > insertVal){
                  arr[insertIndex + gap] = arr[insertIndex];
                  insertIndex -= gap;
              }
              arr[insertIndex + gap] = insertVal;
           }
           gap /= 2;
       }
    }




}
