import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        System.out.print(null == null);
    }

    /***
     * Given two binary trees, write a function to check if they are the same or not.
     *
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     * @param p first Tree
     * @param q second Tree
     * @return if first Tree is the same as the second Tree
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null)
            return q == null;
        if(q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTree_DFS(TreeNode p, TreeNode q){
        if(p == null)
            return q == null;
        if(q == null)
            return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(p);
        stack2.push(q);
        while (!stack1.empty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if(node1.val!=node2.val)
                return false;
            if(node1.left == null && node2.left != null || node2.left == null && node1.left != null)
                return false;
            if(node1.right == null && node2.right != null || node2.right == null && node1.right != null)
                return false;
            if (node1.left != null && node2.left != null){
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
            if(node1.right != null && node2.right != null){
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
        }
        return true;
    }

    public static boolean isSameTree_BFS(TreeNode p, TreeNode q){
        if(p == null)
            return q == null;
        if(q == null)
            return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()){
            int size = queue1.size();
            while (size-- > 0) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if(node1.val != node2.val)
                    return false;
                if(node1.left == null && node2.left != null || node2.left == null && node1.left != null)
                    return false;
                if(node1.right == null & node2.right != null || node2.right == null && node1.right != null)
                    return false;
                if(node1.left != null && node2.left != null){
                    queue1.offer(node1.left);
                    queue2.offer(node2.left);
                }
                if (node1.right != null && node2.right != null) {
                    queue1.offer(node1.right);
                    queue2.offer(node2.right);
                }
            }
        }
        return true;
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
