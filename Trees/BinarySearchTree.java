package Trees;

public class BinarySearchTree {
    class Node{
        //Inheritant properties of BST Nodes
        public int value;
        public Node right;
        public Node left;
        public int height;
        //Constructors
        public Node(int value){
            this.value=value;
        }

        //We will just write a get value function here to generate node values.
        public int getValues(){
            return(value);
        }
    }
    //Ofcourse the root node.
    public Node root;

    //Now lets write the various functionalities associated to BST
    //First we find the height of the nodes(Remember they are measured from the bottom)
    public int getHeight(Node node){
        if(node==null){
            return(-1);
        }
        return(node.height);
    }

    //Next is function to check whether an tree even exists or not
    public boolean isEmpty(){
        if(root==null){
            return(true);
        }
        return(false);
    }

    //Now lets talk about the biggger fish. Insertion of nodes in a tree. Note that, there are 2
    //conditions a tree must satisfy to be called BST. One of them is that, on the left should the 
    //values smaller to the parent node and on the right should be the values greater to the parent node
    public void insertion(int value){
        root=insertion(root,value);
    }
    public Node insertion(Node node,int value){
        if(node==null){
            node.value=value;
            return(node);
        }
        if(value>node.value){
            node.right=insertion(node.right,value);
        }
        if(value<node.value){
            node.left=insertion(node.left, value);
        }
        //Now that we have inserted the nodes, the next thing that we need to do is manage the heights
        node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
        return(node);
    }
    //The next condition to check and satisfy is that tree should be balanced. A tree is said to be
    //balanced if the nodes in same level have height difference less than 1.
    public boolean balanced(){
        return(balanced(root));
    }
    public boolean balanced(Node node){
        if(node==null){
            //If there is no BST in the first place
            return(true);
        }
        return(Math.abs(getHeight(node.left)-getHeight(node.right))<=1 && balanced(node.left) && balanced(node.right));
    }
}
