public class BalancedBinaryTree {
    //BBT = for every node height(left binary tree) - height(right binary tree) should be <= 1
    public boolean isBalanced(TreeNode root) {
        if(maxDepth(root) == -1){
            return false;
        }
        else return true;
    }
    static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if (lh == -1 || rh == -1){
            return -1;
        }
        if (Math.abs(lh-rh) > 1)
            return -1;
        return 1 + Math.max(lh,rh);
    }
}
