public class Solution {
    public static void main(String[] args){}

    public int maxPathSum(TreeNode root) {

    }
    private int getMaxPathSumWithRoot(TreeNode root){
        if(root == null)
            return 0;
        int leftSum = Math.max(getMaxPathSumWithRoot(root.left), 0);
        int rightSum = Math.max(getMaxPathSumWithRoot(root.right), 0);
        int res = Math.max()
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){ this.val = val};
}