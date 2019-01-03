/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
          return true;
        return dfs_search(node, null, null);
    }

    private boolean dfs_search(TreeNode node, Integer upper_limit, Integer lower_limit){
      if(upper_limit != null && node.val >= upper_limit)
        return false;
      if(lower_limit != null && node.val <= lower_limit)
        return false;
      boolean is_left_valid = node.left == null? true : dfs_search(node.left, node.val, lower_limit);
      if(is_left_valid){
        return node.right == null? true : dfs_search(node.right, upper_limit, node.val);
      }
      else{
        return false;
      }
    }

    public boolean isValidBST_inorder(TreeNode root){
      if(root == null)
        return true;
      Stack<TreeNode> st = new Stack<>();
      TreeNode pre = null;
      while(root != null || !st.empty()){
        while(root!=null){
          st.push(root);
          root = root.left;
        }
        root = st.pop();
        if(pre != null && pre.val >= root.val)
          return false;
        pre = root;
        root = root.right;
      }
      return true;
    }



    class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x){val = x;}
    }
}
