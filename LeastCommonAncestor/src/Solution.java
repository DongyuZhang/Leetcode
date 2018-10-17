import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        root.left = node5;
        root.right = node1;
        node1.left = node0;
        node1.right = node8;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        lca_tarjan(root, node6, node4);
        System.out.print(res.val);
    }

    static Set<TreeNode> visited = new HashSet<>();
    static UnionFindSet unionFindSet = new UnionFindSet();
    static TreeNode res = null;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null? right : right == null? left : root;
    }

    public static void lca_tarjan(TreeNode root, TreeNode node1, TreeNode node2){
        if (root == null || res != null) {
            return;
        }
        unionFindSet.ancestor.put(root, root);
        if (root.left != null) {
            lca_tarjan(root.left, node1, node2);
            unionFindSet.union(root, root.left);
        }
        if (root.right != null) {
            lca_tarjan(root.right, node1, node2);
            unionFindSet.union(root,root.right);
        }
        visited.add(root);
        TreeNode v = root.equals(node1)? node2 : (root.equals(node2)? node1 : null);
        if(v != null && visited.contains(v))
            res = unionFindSet.find(v);
    }

    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int val){ this.val = val; }
    }

    static class UnionFindSet{
        Map<TreeNode, TreeNode> ancestor = new HashMap<>();

        TreeNode find(TreeNode p){
            if(p == null)
                return null;
            if(p.equals(ancestor.get(p)))
                return p;
            else{
                ancestor.put(p, find(ancestor.get(p)));
                return ancestor.get(p);
            }
        }
        void union(TreeNode u, TreeNode v){
            if(u == null || v == null)
                return;
            //put the ancestor of v as child of u
            ancestor.put(find(v), find(u));
        }
    }
}
