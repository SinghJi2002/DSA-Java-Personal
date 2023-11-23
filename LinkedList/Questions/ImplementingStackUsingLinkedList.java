package Questions;

class LinkedList{
    Node head;
    Node tail;
    int size;
    public LinkedList(){
        this.size=0;
    }
    class Node{
        int value;
        Node next;
        public Node(){};
        public Node(int value){
        this.value=value;
        }
        public Node(int value,Node next){
            this.value=value;
            this.next=next;
        }
    }

    public void add(int val){
        if(head==null){
            Node temp0=new Node(val);
            head=temp0;
            return;
        }
        Node temp1=head;
        while(temp1.next!=null){
            temp1=temp1.next;

        }
        Node valueStore=new Node(val);
        temp1.next=valueStore;
        temp1=temp1.next;

    }
    public void remove(){
        Node dummy=new Node();
        dummy.next=head;
        Node temp2=head;
        while(temp2.next!=null){
            temp2=temp2.next;
            dummy=dummy.next;
        }
        dummy.next=null;
    }

    public void peek(){
        Node temp3=head;
        while(temp3.next!=null){
            temp3=temp3.next;
        }
        System.out.println(temp3.value);
    }
}

public class ImplementingStackUsingLinkedList {
    public static void main(String[] args) {
        LinkedList LL1=new LinkedList();
        LL1.add(10);
        LL1.add(11);
        LL1.add(19);
        LL1.add(9);
        LL1.add(7);

        LL1.peek();

        LL1.remove();

        LL1.peek();

    }
    
}
