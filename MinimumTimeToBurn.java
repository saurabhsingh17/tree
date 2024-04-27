import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumTimeToBurn {
    static TreeNode markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack, int target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode res = null;
        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- > 0) {
                TreeNode current = q.poll();
                if (current.val == target) {
                    res = current;
                }
                if (current.left != null) {
                    parentTrack.put(current.left, current);
                    q.offer(current.left);
                }
                if (current.right != null) {
                    parentTrack.put(current.right, current);
                    q.offer(current.right);
                }
            }

        }
        return res;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        TreeNode target = markParent(root, parentTrack, start);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    flag = 1;
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    flag = 1;
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null) {
                    flag = 1;
                    q.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
            if (flag == 1) {
                time++;
            }
        }
        return time;
    }
}
