public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSym(root.left, root.right);

    }
    private boolean isSym(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val)return false;
        return isSym(left.left,right.right) && isSym(left.right,right.left);

    }

}
