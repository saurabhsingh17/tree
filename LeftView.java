import java.util.ArrayList;
import java.util.List;

public class LeftView {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        leftView(root,0,res);
        return res;
    }
    static void leftView(TreeNode root,int level,List<Integer> res){
        if(root == null)
            return;
        if(level == res.size()){
            res.add(root.val);
        }
        leftView(root.left,level+1,res);
        leftView(root.right,level+1,res);
        
        return;
    }
}

