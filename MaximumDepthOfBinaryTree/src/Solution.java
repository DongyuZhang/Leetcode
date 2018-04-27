import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){}

    /***
     * Leetcode #104 Easy
     * @param root
     * @return int -> maximum depth for this tree
     */
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }

    public static int maxDepth_DFS(TreeNode root){
        if(root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        // stores the depth for the corresponding node
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.empty()){
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null){
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null){
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }



    public static int maxDepth_BFS(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //This layer is empty now, Add this Layer
            max++;
        }
        return max;
    }








    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
