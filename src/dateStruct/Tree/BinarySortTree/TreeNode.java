package dateStruct.Tree.BinarySortTree;



public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
    //添加节点
    public void addNodes (TreeNode node) {
        if (this.value > node.value) {
            if (this.left != null) {
                this.left.addNodes(node);
            } else {
                this.left = node;
            }
        } else {
           if (this.right != null) {
              this.right.addNodes(node);
           } else {
              this.right = node;
           }
        }
    }
    ///遍历节点
    public void show () {
        if (this.left != null) {
            this.left.show();
        }
        System.out.println(this);

        if (this.right != null) {
            this.right.show();
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }

    public TreeNode findParent (int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
                return this;
        } else {
            if (this.value < value) {
                if (this.right != null) {
                    return this.right.findParent(value);
                }else {
                    return null;
                }
            }else {
                if (this.left != null) {
                    return this.left.findParent(value);
                }else {
                    return null;
                }
            }
        }
    }



    public TreeNode findChildren (int value) {
        if (this.value == value) {
            return this;
        } else if (this.value < value) {
            if (this.right != null) {
                return this.right.findChildren(value);
            }else {
                return null;
            }
        } else if (this.value > value) {
            if (this.left != null) {
                return this.left.findChildren(value);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
}
