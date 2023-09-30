package dateStruct.Tree.BinaryTreeStack;

public class TreeNode {
    public Integer value;
    public TreeNode left;
    public TreeNode right;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
