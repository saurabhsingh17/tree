import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root==null)
            return result;

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levels = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode current = queue.poll();
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
                levels.add(current.val);
            }
            result.add(levels);
        }
        return result;
    }
    //recursive solution without using queue
    public List<List<Integer>> levelOrderRecursive(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, result, 0);
        return result;
    }

    private void dfs(TreeNode root, List<List<Integer>> result, int level){
        if(root == null){
            return;
        }
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        dfs(root.left, result, level + 1);
        dfs(root.right, result, level + 1);
    }
}
