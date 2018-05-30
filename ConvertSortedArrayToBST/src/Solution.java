public class Solution {
    public static void main(String[] args){

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return createBST(nums, 0, nums.length-1);
    }

    private TreeNode createBST(int[] nums, int start, int end){
        if(start>end)
            return null;
        if(start == end)
            return new TreeNode(nums[start]);
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBST(nums, start, mid-1);
        root.right = createBST(nums, mid+1, end);
        return root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
    }

}
