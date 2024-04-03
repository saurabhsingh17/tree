# Tree

### Binary Tree Representation
```java
class Node {
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data = data;
    }
}
class Main{
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
    }
}
```
### Traversals in Trees
a. DFS
1. Inorder (Left,Root,Right)
2. Preorder (Root,Left,Right)
3. Post-order (Left, Right, Root)
b. BFS
