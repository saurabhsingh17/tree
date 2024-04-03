import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return postOrder(root, res);
    }

    List<Integer> postOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
        return res;
    }
}