import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] args){

    }

    /***
     *
     * @param root
     * @return if this binary tree is height balanced:
     * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * recursive method
     */
    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode root){
        if(root == null)
            return 0;
        int left_depth = depth(root.left);
        if(left_depth == -1)
            return -1;
        int right_depth = depth(root.right);
        if(right_depth == -1)
            return -1;
        if(Math.abs(left_depth-right_depth) > 1)
            return -1;
        return Math.max(left_depth, right_depth)+1;
    }

    /***
     * Post Order Traversal for a binary tree:
     *
     *
      * @param root
     * @return if the bianry tree is height balanced
     */
    public static boolean isBalanced_post_order(TreeNode root){
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        //Store the depth of a node
        Map<TreeNode, Integer> hm = new HashMap<>();
        TreeNode node = root, last = null;
        while (!stack.empty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                //only access a node if its right tree is empty or last visited
                if (node.right == null || node.right == last) {
                    int left_depth = hm.getOrDefault(node.left, 0), right_depth = hm.getOrDefault(node.right, 0);
                    if(Math.abs(left_depth-right_depth)>1)
                        return false;
                    hm.put(node, Math.max(left_depth,right_depth)+1);
                    last = node;
                    node = null;
                }else {
                    node = node.right;
                }
            }
        }
        return true;
    }

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
