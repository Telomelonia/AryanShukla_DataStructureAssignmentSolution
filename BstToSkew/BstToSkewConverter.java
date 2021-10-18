
package BstToSkew;
import BstToSkew.Node;
public class BstToSkewConverter 
{
    public static Node node;
    static Node prevnode = null;
    static Node headnode = null;  
    static void bstToSkew(Node root)
    {
        //null tree case
        if(root == null)
        {
            return;
        }
        //maintaining the increasing order of the skewed tree using recursion for next nodes
        bstToSkew(root.left);
        Node rightNode = root.right;
        Node leftNode = root.left;
        //checking the headNode whether it is defined or not
        if(headnode == null)
        {
            headnode = root;
            root.left = null;
            prevnode = root;
        }
        else
        {
            prevnode.right = root;
            root.left = null;
            prevnode = root;
        }
       //now repeating the recursion logic as above
        bstToSkew(rightNode);
    }
    //recursive traverse through the skewed tree
    static void traverseSkewedTree(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.val +" ");
        traverseSkewedTree(root.right);
    }


    //driver
    public static void main(String[] args) 
    {
        /*
                50
                /\
              30  60
              /   /
             10  40
        */    
        BstToSkewConverter tree = new BstToSkewConverter();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left= new Node(40);
        bstToSkew(node);
        traverseSkewedTree(headnode);
    }
}        

