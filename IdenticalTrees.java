public class IdenticalTrees {
    //Check if two given trees are identical
    //Logic is simple just do any traversal and node.val should be equal for both.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
