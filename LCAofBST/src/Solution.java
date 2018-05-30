public class Solution {

    public static void main(String[] args){

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ((root.val-p.val)*(root.val-q.val))>0?
                ((root.val-p.val)>0?
                        lowestCommonAncestor(root.left, p, q) :lowestCommonAncestor(root.right, p ,q)) : root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
    }
}
