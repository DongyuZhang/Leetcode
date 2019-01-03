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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
          return root;
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parent.put(root, null);
        queue.add(root);
        while(!hm.containsKey(p) || !hm.containsKey(q)){
          TreeNode curr = queue.poll();
          if(curr.left != null){
            queue.add(curr.left);
            hm.put(curr.left, curr);
          }
          if(curr.right != null){
            queue.add(curr.right);
            hm.put(curr.right, curr);
          }
        }
        Set<TreeNode> hs = new HashSet<>();
        TreeNode curr = p;
        while(curr != null){
          hs.add(curr);
          curr = parent.get(curr);
        }
        curr = q;
        while(!hs.contains(curr)){
          curr = parent.get(curr);
        }
        return curr;
    }
}
