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
        treeNode1.left = treeNode2;
        treeNode2.left = treeNode10;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode4.left = treeNode8;
        treeNode4.right = treeNode9;
        treeNode5.right = treeNode6;
        treeNode5.left = treeNode7;
        treeNode10.left = treeNode11;
        treeNode6.left = treeNode12;


        Tree tree = new Tree();

        System.out.println(tree.getMaxBreathLayer2(treeNode1));



    }
}
