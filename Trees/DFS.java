package Trees;

public class DFS {
    class Node{
        Node left;
        Node right;
        int value;
    }
    //Refer to inorder post order and pre order tranversals
    //Trees traversal. First one is, preOrder. The general order is Node->Left->Right. Pre order 
    //transversal is generally used in math exp eval. Making tree copy of tree. Serialisation of string
    //array.
    public void preOrder(){
        Node root=new Node();
        preOrder(root);
    }
    public void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    //Inorder.The general order is Left->Node->Right. This traversal is generally used for visiting BST
    //in sorted manner.
    public void inOrder(){
        Node root=new Node();
        inOrder(root);
    }
    public void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }
    //PostOrder. The general order is Left->Right->Node. The traversal is generally used in deletion 
    //of tree nodes. Also used for bottom to up calculation.
    public void postOrder(){
        Node root=new Node();
        postOrder(root);
    }
    public void postOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.value);
    }
}
