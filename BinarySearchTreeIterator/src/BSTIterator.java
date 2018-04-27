import java.util.Stack;

/***
 * #173 Bianry Serach Tree Iterator
 * O(1) for next() function is overall calculated.
 * Put all the way left node to stack first
 * Once we access one node, we output the value and put all the way left node of its right child (included) into the stack
 */
public class BSTIterator {
    public static void main(String[] args){}


    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        if(root != null){
            TreeNode node = root.left;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (stack.empty())
            return false;
        else
            return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode temp = node.right;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        return node.val;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
