import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return inOrder(root, res);
    }

    List<Integer> inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
        return res;
    }
}
