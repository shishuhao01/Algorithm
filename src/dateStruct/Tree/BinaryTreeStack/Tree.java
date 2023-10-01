package dateStruct.Tree.BinaryTreeStack;

import algorithm.leetcode.easy.ReverseCharacter;

import java.util.*;

public class Tree {
    public TreeNode root;


    public void preOrderUnRecur (TreeNode head) {
        //先序遍历非递归
        if (head == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode temporary = stack.pop();
            System.out.println(temporary);   // 先右边后左边
            if (temporary.right != null) {
                stack.push(temporary.right);
            }
            if (temporary.left != null) {
                stack.push(temporary.left);
            }
        }
    }

    public void preOrderRecur (TreeNode head) {
        //先序递归遍历
        if (head == null) {
            return;
        }
        System.out.println(head);
        if (head.left != null) {
            preOrderRecur(head.left);
        }
        if (head.right != null) {
            preOrderRecur(head.right);
        }
    }









    public void inOrderUnRecur (TreeNode head) {
        //中序遍历非递归
        if (head == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head);
                head = head.right;
            }
        }
    }

    public void inOrderRecur (TreeNode head) {
        //中序遍历递归
        if (head == null) {
            return;
        }
        if (head.left != null) {
            inOrderRecur(head.left);
        }
        System.out.println(head);
        if (head.right != null) {
            inOrderRecur(head.right);
        }
    }






    public void postOrderUnRecur (TreeNode head) {
        //后序栈
        if (head == null) {
            return ;
        }
        Stack<TreeNode> eject = new Stack<>(); // 弹出栈
        Stack<TreeNode> collection = new Stack<>(); //收集栈
        eject.push(head);

        while (!eject.isEmpty()) {
            TreeNode temporary = eject.pop();
            collection.push(temporary);
            if (temporary.left != null) {
                eject.push(temporary.left);
            }
            if (temporary.right != null) {
                eject.push(temporary.right);
            }
        }
        while (!collection.isEmpty()) {
            System.out.println(collection.pop());;
        }
    }

    public void postOrderRecur (TreeNode head) {
        if (head == null) {
            return;
        }
        if (head.left != null) {
            postOrderRecur(head.left);
        }
        if (head.right != null) {
            postOrderRecur(head.right);
        }
        System.out.println(head);
    }



    //树的宽度优先遍历  类似于图的广度优先遍历  用队列
    public void breathOrderRecur (TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.remove();
            System.out.println(head);
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }


    //找一棵树的最宽层返回层和宽度
    public int getMaxBreathLayer (TreeNode head) {
        if (head == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        Map<TreeNode,Integer> map = new HashMap();
        map.put(head,1);
        int curLevel = 1;
        int curLevelNodes = 0;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            head = queue.remove();
            int curNodeLevel = map.get(head);
            if (curLevel == curNodeLevel) {
                curLevelNodes++;
            } else {
                max = Math.max(max,curLevelNodes);
                curLevel = curNodeLevel;
                curLevelNodes = 0;
                curLevelNodes++;
            }
            System.out.println(head);
            if (head.left != null) {
                map.put(head.left,curNodeLevel + 1);
                queue.add(head.left);
            }
            if (head.right != null) {
                map.put(head.right,curNodeLevel + 1);
                queue.add(head.right);
            }
        }
        for (Map.Entry<TreeNode,Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        return Math.max(max,curLevelNodes);
    }


    //找一棵树的最宽层返回层和宽度 (简单算法)
    public int getMaxBreathLayer2 (TreeNode head) {
        if (head == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(size,max);
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.removeFirst();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return max;
    }

    //判断是否二叉排序树(递归)  （搜索二叉树）
    private static int preValue = Integer.MIN_VALUE;
    public boolean isThreadedBinaryTreeRecur (TreeNode head) {
        if (head == null) {
            return true;
        }
        boolean isLeftTBT = isThreadedBinaryTreeRecur(head.left);

        if (!isLeftTBT) {
            return false;
        }
        if (head.value < preValue) {
            return false;
        }else {
            preValue = head.value;
        }
        return isThreadedBinaryTreeRecur(head.right);
    }


    //判断是否二叉排序树(非递归)  （搜索二叉树）
    public boolean isThreadedBinaryTreeUnRecur (TreeNode head) {
        //中序遍历非递归
        if (head == null) {
            return true;
        }
        int preVal = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null)
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.value <= preVal) {
                    return false;
                } else {
                    preVal = head.value;
                }
                head = head.right;
            }
           return true;
    }


    // 第二种方法
    public class ReturnType1 {
        int max;
        int min;
        boolean isThreaded;

        public ReturnType1(int max, int min, boolean isThreaded) {
            this.max = max;
            this.min = min;
            this.isThreaded = isThreaded;
        }
    }
    public ReturnType1 isThreaded (TreeNode head) {
        if (head == null) {
            return null;
        }
        ReturnType1 leftTree = isThreaded(head.left);
        ReturnType1 rightTree = isThreaded(head.right);

        int min = head.value;
        int max = head.value;

        if (leftTree != null) {
            min = leftTree.min;
        }

        if (rightTree != null) {
            max = rightTree.max;
        }
        boolean isBalanced = true;
        if (leftTree != null && (!leftTree.isThreaded || head.value <= leftTree.max)) {
            isBalanced = false;
        }
        if (rightTree != null && (!rightTree.isThreaded || head.value > rightTree.min)) {
            isBalanced = false;
        }
        return new ReturnType1(max,min,isBalanced);
    }













    //判断是否为完全二叉树
    public boolean isCompleteBinaryTree (TreeNode head) {
        if (head == null) {
            return true;
        }
        boolean flag = false; // 是一个标记 判断是否遇到第一个叶子节点
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode l = temp.left;
            TreeNode r = temp.right;
            if ( (r != null && l == null) || (flag && (r != null || l != null))) {
                //不是完全二叉树的条件 （1） 一个节点右边的孩子不为空， 左边的孩子是空
                //若发现了一个节点左孩子不为空，右孩子为空(或者左右孩子都为空) 则接下来遇到的节点都应该是孩子节点
                //（2） 满足1的条件下 当出现一个节点不是左右孩子都空的情况 将flag 标记为true,接下来遇到的每一个节点都应该是孩子节点
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                flag = true;
            }
        }
        return true;
    }















    //判断一棵树是否为平衡二叉树
    public boolean isBalanced (TreeNode head) {
        return isBalanced1(head).isBalanced;
    }
    public class ReturnType2 {
        public int height;
        public boolean isBalanced;

        public ReturnType2(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    public ReturnType2 isBalanced1(TreeNode head) {
        if (head == null) {
            return new ReturnType2(0,true);
        }
        ReturnType2 leftTree = isBalanced1(head.left);
        ReturnType2 rightTree = isBalanced1(head.right);
        int height = Math.max(leftTree.height, rightTree.height) + 1;
        boolean isBalanced = (leftTree.isBalanced && rightTree.isBalanced) && Math.abs(leftTree.height - rightTree.height) < 2;
        return new ReturnType2(height,isBalanced);
    }




    //判断一棵树是否为满二叉树    节点数 树的深度
    public boolean isFullBinaryTree (TreeNode head) {
        ReturnType3 rets = isFullBinaryTree1(head);
        System.out.println(rets.height + "  "+ rets.nodes);

        return rets.nodes == (1 << rets.height) - 1;

    }

    public class ReturnType3 {
        int height;
        int nodes;

        public ReturnType3(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public ReturnType3 isFullBinaryTree1 (TreeNode head){
        if (head == null) {
            return new ReturnType3(0,0);
        }
        ReturnType3 leftTree = isFullBinaryTree1(head.left);
        ReturnType3 rightTree = isFullBinaryTree1(head.right);

        int height = Math.max(leftTree.height,rightTree.height) + 1;
        int nodes = leftTree.nodes + rightTree.nodes + 1;
        return new ReturnType3(height,nodes);
    }





}
