import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return preOrder(root, res);
    }

    List<Integer> preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
        return res;
    }
}
