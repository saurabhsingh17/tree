import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) {
            return wrapList;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null)queue.offer(queue.peek().left);
                if(queue.peek().right != null)queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
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
