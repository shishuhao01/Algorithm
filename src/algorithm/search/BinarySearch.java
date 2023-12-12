package algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr1,5));

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
                continue;
            }

            if (arr[mid] < target) {
                left = mid + 1;
                continue;
            }

            if (target == arr[mid]) {
                break;
            }
        }

        return mid;
    }
}
