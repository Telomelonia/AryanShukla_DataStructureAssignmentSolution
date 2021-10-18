package BstToSkew;

public class Node
{
    int val;
    Node left, right;
    
    // allocates a new node with given and NULL left and right pointers.
    Node(int item)
    {
        val = item;
        left = right = null;
    }
}