package StackAndQueue;
/*Deque is nothing but a queue that doesn't follow the general FIFO concept on which queues generally 
work on. Its an array based or linked link based structure in which insertion and deletion of element
can be undertaken from both the start and the end.
The general implementation can be seen below.
There are generally 2 types of dequeue.
1)Retricted Input Dequeue:In this insertion from front is not allowed. See this in the context of a 
general queue where insertion is always done from the back to facilitate the FIFO algo.
2)Restricted Output Dequeue:In this deletion is not allowed from the rear. In context of queue, deletion
is always done from front in order to facilitate FIFO algo.
 */
public class Deque{
    //Lets implement deque using linked list(Its easier that way).
    //Basic Properties of Deque
    public Node head;
    public Node tail;
    public Deque(){
        head=tail=null;
    }

    public class Node{
        //Basic Properties Of Nodes
        public int value;
        public Node next;
        public Node prev;
        public Node(int val){
            this.value=val;
        }
        public Node(){}
        public Node(int val,Node next){
            this.value=val;
            this.next=next;
        }
        public Node(int val,Node next,Node prev){
            this.value=val;
            this.next=next;
            this.prev=prev;
        }
    }
    //Basic Implementation Of Deque
    public void enqueue_front(int val){
        if(head==null){
            head.value=val;
            tail=head;
            return;
        }
        Node newNode=new Node(val);
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void enqueue_back(int val){
        if(tail==null){
            tail.value=val;
            head=tail;
            return;
        }
        Node newNode=new Node(val);
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    public void deque_front(){
        if(head==null){
            System.out.println("Nothing to delete");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        head=head.next;
        head.prev=null;
    }
    public void deque_back(){
        if(tail==null){
            System.out.println("Nothing to delete");
            return;
        }
        if(tail.prev==null){
            return;
        }
        tail=tail.prev;
        tail.next=null;
    }
    public void traverse(){
        if(head==null || tail==null){
            System.out.println("Nothing to show");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
    }
}