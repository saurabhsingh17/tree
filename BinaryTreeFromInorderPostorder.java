public class BinaryTreeFromInorderPostorder {
    static class StriverSolution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }
        private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }
            int rootVal = postorder[postEnd];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (inorder[i] == rootVal) {
                    rootIndex = i;
                    break;
                }
            }
            int leftSize = rootIndex - inStart;
            int rightSize = inEnd - rootIndex;
            root.left = buildTree(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
            root.right = buildTree(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

            return root;
        }
    }
    static class BestSolution {
        private int i;
        private int p;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            i=inorder.length-1;
            p=postorder.length-1;
            return build(inorder,postorder,Integer.MIN_VALUE);
        }
        private TreeNode build(int inorder[],int postorder[],int stop){
            if(p<0){
                return null;
            }
            if(inorder[i]==stop){
                i--;
                return null;
            }
            TreeNode node = new TreeNode(postorder[p--]);
            node.right = build(inorder,postorder,node.val);
            node.left = build(inorder,postorder,stop);
            return node;
        }
    }
}
