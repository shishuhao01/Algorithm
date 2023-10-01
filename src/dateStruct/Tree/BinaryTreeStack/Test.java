package dateStruct.Tree.BinaryTreeStack;

public class Test {
    public static void main(String[] args) {
        // 树的遍历方式  用栈实现（非递归）
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11= new TreeNode(11);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode14 = new TreeNode(14);
        treeNode5.left = treeNode3;
        treeNode3.left = treeNode2;
        treeNode2.left = treeNode1;
        treeNode3.right = treeNode4;
        treeNode5.right = treeNode9;
        treeNode9.left = treeNode7;
//        treeNode7.right = treeNode8;
        treeNode9.right = treeNode11;
//        treeNode11.left = treeNode10;
//        treeNode11.right = treeNode12;
//        treeNode2.right = treeNode13;



        Tree tree = new Tree();
        tree.inOrderUnRecur(treeNode5);
        System.out.println();


        System.out.println(tree.isFullBinaryTree(treeNode5));


    }
}
