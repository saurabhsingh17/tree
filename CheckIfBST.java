public class CheckIfBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    static boolean isBST(TreeNode root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        return isBST(root.left,minVal,root.val) && isBST(root.right,root.val,maxVal);
    }
}
