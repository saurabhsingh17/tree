public class MaximumPathSumBinaryTree {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = Math.max(0, maxDepth(root.left));
        int rh = Math.max(0, maxDepth(root.right));
        max = Math.max(max, root.val+lh+rh);
        return root.val + Math.max(lh,rh);
    }
}
