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
}