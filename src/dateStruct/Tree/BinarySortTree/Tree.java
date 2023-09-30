package dateStruct.Tree.BinarySortTree;

public class Tree {
    public TreeNode root;
    //添加叶子节点
    public void addNode(TreeNode node) {
        if (root == null) {
            this.root = node;
        }else {
            root.addNodes(node);
        }
    }
    // 中序遍历顺序存储二叉树
    public void show () {
        if (root != null) {
            root.show();
        }else {
            return ;
        }
    }

    //寻找右边最小的叶子节点
    public int getRightMin (TreeNode node) {
        TreeNode temp = node;
        while (true) {
            if (temp.left == null) {
                break;
            }
            temp = temp.left;
        }
        del(temp.value);
        return temp.value;
    }


    //删除叶子节点
    public void del (int value) {
       if (root == null) {
           return;
       } else {

           TreeNode children = findChildren(value);

           if (children == null) {
               return;
           }

          if (root.left == null && root.right == null) {
              root = null;
              return;
          }

          TreeNode parent = findParent(value);

          if (children.left == null && children.right == null) {  //删除节点没有孩子节点
              if (parent.left != null && parent.left.value == value) {
                  parent.left = null;
              } else {
                  parent.right = null;
              }
          } else if (children.left != null && children.right != null) { // 删除节点有左右孩子节点
              int rets = getRightMin(children.right);
              children.value = rets;
          } else {
              if (children.left != null) {
                  if (parent.left != null && parent.left.value == value) {
                      parent.left = children.left;
                  } else {
                      parent.right = children.left;
                  }
              } else {
                  if (parent.left != null && parent.left.value == value) {
                      parent.left = children.right;
                  } else {
                      parent.right = children.right;
                  }
              }
          }
       }
    }
    // 寻找父节点
    public TreeNode findParent (int value) {
        if (root.value == value) {
            return root;
        }else {
           return root.findParent(value);
        }
    }
    //寻找删除的叶子节点
    public TreeNode findChildren (int value) {
        if (root.value == value) {
            return root;
        } else {
            return root.findChildren(value);
        }
    }




}
