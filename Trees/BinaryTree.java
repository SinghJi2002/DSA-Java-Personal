package Trees;

import java.util.Scanner;

public class BinaryTree{
    public class Node{
        //Each node will have 3 inherit properties
        Node left;
        Node right;
        int value;
        //Now we will draw the constructors
        public Node(int value){
            this.value=value;
        }
    }

    //Now like the head in linked list, we will have root in case of tree
    public Node root;

    //Now we will start with insertion of nodes.
    public void insertion(Scanner sc){
    //Note that we have used scanner object sc as argument so that we do not need to create the scanner
    //object again and again.
        System.out.println("Enter the value to be stored in root node");
        int rootVal=sc.nextInt();
        root.value=rootVal;
        //After inserting the root value, the other nodes will be added via a seperate function.
        insertion(sc,root);
    }
    //Function to insert non-root nodes
    public void insertion(Scanner sc,Node node){
        System.out.println("Do you want to create new left node?");
        boolean ansLeft=sc.nextBoolean();
        if(ansLeft){
            System.out.println("Enter value of the left node");
            int leftVal=sc.nextInt();
            //Create new node
            Node leftNode=new Node(leftVal);
            node.left=leftNode;
            insertion(sc,leftNode);
        }
        System.out.println("Do you want to create new right node?");
        boolean ansRight=sc.nextBoolean();
        if(ansRight){
            System.out.println("Enter the value of right node");
            int rightVal=sc.nextInt();
            Node rightNode=new Node(rightVal);
            node.right=rightNode;
            insertion(sc, rightNode);
        }
    }
    //Above we have discussed about inserting the nodes. Now lets see how to display the values.
    public void display(){
        display(this.root,"");
    }
    public void display(Node node,String dString){
        if(node==null){
            return;
        }
        System.out.println(dString+node.value);
        display(node.left,dString+'\t');
        display(node.right, dString+'\t');
    }
    //Trees traversal. First one is, preOrder. The general order is Node->Left->Right. Pre order 
    //transversal is generally used in math exp eval. Making tree copy of tree. Serialisation of string
    //array.
    public void preOrder(){
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