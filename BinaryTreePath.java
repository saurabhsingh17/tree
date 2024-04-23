import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return getPath(root,sb,ans);
    }
    static List<String> getPath(TreeNode root, StringBuilder res, List<String> ans){
        if(root != null)
            res.append(root.val);

        if(root.left == null && root.right == null){
            //System.out.println(res.toString());
            ans.add(res.toString());
        }

        if(root.left != null)
            getPath(root.left,new StringBuilder(res).append("->"),ans);
        if(root.right != null)
            getPath(root.right,new StringBuilder(res).append("->"),ans);
        return ans;
    }
}
