package dateStruct.Tree.BinarySortTree;

public class Test {
    public static void main(String[] args) {
        int[] arr = {9,5,11,1,7,10,12,13,8,6};
        Tree tree = new Tree();
        for (int i = 0; i < arr.length; i++) {
            tree.addNode(new TreeNode(arr[i]));
        }
        tree.del(7);
        tree.show();



    }
}
