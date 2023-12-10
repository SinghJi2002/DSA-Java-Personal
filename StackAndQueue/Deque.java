package StackAndQueue;

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