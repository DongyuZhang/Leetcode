import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    /***
     *
     * @param root
     * @return a reverted Binary Tree with root 'root'
     * Revert a Binary Tree
     */
    public static TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
    public static TreeNode invertTree_DFS(TreeNode root){
        if(root == null)
            return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            //switch between left and right
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left=right;
            node.right=left;
            //add left and right to stack
            if (left != null) {
                stack.push(left);
            }
            if (right != null) {
                stack.push(right);
            }
        }
        return root;
    }
    public static TreeNode invertTree_BFS(TreeNode root){
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.right=left;
            node.left=right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return root;
    }
}
