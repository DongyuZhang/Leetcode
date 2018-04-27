import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){

    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        t1.val = t1.val+t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static TreeNode mergeTrees_DFS(TreeNode t1, TreeNode t2){
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(t1);
        stack2.push(t2);
        while(!stack1.empty()){
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            node1.val = node1.val+node2.val;
            if(node1.left != null && node2.left != null){
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
            if(node1.left == null)
                node1.left = node2.left;
            if (node1.right != null && node2.right != null) {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
            if(node1.right == null)
                node1.right = node2.right;
        }
        return t1;
    }

    public static TreeNode mergeTrees_BFS(TreeNode t1, TreeNode t2){
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty()) {
            int size = queue1.size();
            while(size-- > 0){
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                node1.val = node1.val + node2.val;
                if(node1.left != null && node2.left != null){
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                }
                if(node1.left == null)
                    node1.left = node2.left;
                if (node1.right != null && node2.right != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                }
                if(node1.right == null)
                    node1.right = node2.right;
            }
        }
        return t1;
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
