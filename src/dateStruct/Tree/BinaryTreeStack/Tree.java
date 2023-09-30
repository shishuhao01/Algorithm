package dateStruct.Tree.BinaryTreeStack;

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



}
