import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode node,int num){
            this.node = node;
            this.num = num;
        }
    }
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            Queue<Pair> q = new LinkedList<>();
            int max = 0;
            if (root == null) return 0;
            q.offer(new Pair(root,0));
            while(!q.isEmpty()){
                int size = q.size();
                int mmin = q.peek().num;
                int first = 0,last = 0;
                for(int i = 0; i < size; i++){
                    int curr_id = q.peek().num-mmin;
                    TreeNode node = q.peek().node;
                    q.poll();
                    if(i == 0) first = curr_id;
                    if(i == size-1) last = curr_id;
                    if(node.left != null) q.offer(new Pair(node.left,curr_id*2+1));
                    if(node.right != null) q.offer(new Pair(node.right,curr_id*2+2));

                }
                max =  Math.max(max, last-first+1);
            }
            return max;
        }
    }
}
