import java.util.*;

public class ZigZagTraversal {
    //Level Order Traversal with alternate direction
    //Just use boolean flag, reverse the subList when false
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return levelOrder(root);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        boolean leftToRight = false;
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
            leftToRight = !leftToRight;
            if(!leftToRight) Collections.reverse(subList);
            wrapList.add(subList);


        }
        return wrapList;
    }
}
