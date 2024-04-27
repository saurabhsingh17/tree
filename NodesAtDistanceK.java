import java.util.*;

public class NodesAtDistanceK {
    static void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack, TreeNode target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            while (n-- > 0) {
                TreeNode current = q.poll();
                if(current.left != null){
                    parentTrack.put(current.left,current);
                    q.offer(current.left);
                }
                if(current.right != null){
                    parentTrack.put(current.right,current);
                    q.offer(current.right);
                }
            }

        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentTrack = new HashMap<>();
        markParent(root,parentTrack,root);
        Map<TreeNode,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int currLevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currLevel == k) break;
            currLevel++;
            for(int i = 0; i < size; i++){
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left,true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right,true);
                }
                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    q.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            res.add(current.val);
        }
        return res;
    }
}
