import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
    Node node;
    int v;
    public Pair(Node n, int v){
        node=n;
        this.v=v;
    }
}
 class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
}
public class TopView {
    
    static ArrayList<Integer> topView(Node root){
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        if(root == null) return ans;
        q.add(new Pair(root,0));
        
        while(!q.isEmpty()){
            Pair it = q.remove();
            int vertical = it.v;
            Node tmp = it.node;
            if(map.get(vertical) == null) map.put(vertical, tmp.data);
            
            if(tmp.left != null) q.add(new Pair(tmp.left,vertical-1));
                
            if(tmp.right != null ) q.add(new Pair(tmp.right,vertical+1));
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        
        return ans;  
        
    }
}
