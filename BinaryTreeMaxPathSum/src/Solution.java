public class Solution {
    public static void main(String[] args){}

    private int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int max_with_root = maxPathDown(root);
        return max_sum;
    }

    /**
     * Use a global variable to calculate max path sum each time we get the
     * left and right maxPathDown
     * @param root
     * @return
     * The maximum sum of the path from this root down to the leaf of that path
     * This sum can be used by the parent of this root to calculate parent's
     * maxPathDown.
     */
    private int maxPathDown(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left_max = Math.max(maxPathDown(root.left), 0);
        int right_max = Math.max(maxPathDown(root.right), 0);
        int res = left_max+root.val+right_max;
        max_sum = Math.max(res, max_sum);
        return Math.max(left_max, right_max)+root.val;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){ this.val = val};
}