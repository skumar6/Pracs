package DataStructures;

/**
 * Created by vineet on 7/6/17.
 */
public class Tree {
    Node root;

    public static void main(String[] args){
        Tree t = new Tree();
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
       // System.out.println(t.root.val);
        t.inorder(t.root);

    }

    public void insert(int x){

        if(root== null) {
            root = new Node(x);
            return;
        }
        Node current = root;
        Node prev = null;
        while(current != null){
            prev = current;
            if(current.val < x)
                current = current.right;
            else
                current = current.left;
        }
        if(x<prev.val)
            prev.left=new Node(x);
        else
            prev.right = new Node(x);

    }

    public void inorder(Node root){
        if(root == null)
            return;
        System.out.print(root.val +" ");
        inorder(root.left);
        inorder(root.right);
    }


}
class Node {
    int val;
    Node left;
    Node right;

    public Node(int x ){
        this.val=x;
        this.right = null;
        this.left = null;
    }
}
