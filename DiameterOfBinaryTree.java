public class DiameterOfBinaryTree {
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        max = Math.max(max, lh+rh);
        return 1 + Math.max(lh,rh);
    }
}