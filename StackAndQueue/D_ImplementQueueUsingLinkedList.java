class Node{
    int value;
    Node next;

    public Node(int value){
        this.value=value;
    }
}

class Queue{
    Node start;
    Node end;
    int currSize=0;

    public Queue(){
        System.out.println("Queue is created");
    }

    public void push(int value){
        if(start==null && end==null){
            start=new Node(value);
            end=start;
            currSize++;
            return;
        }
        Node newNode=new Node(value);
        end.next=newNode;
        end=end.next;
        currSize++;
    }

    public int pop(){
        if(start==null){
            System.out.println("Queue is empty");
            return(-1);
        }
        int valueToReturn=start.value;
        start=start.next;
        if (start == null) {
            end = null;
        }
        currSize--;
        return(valueToReturn);
    }

    public int top(){
        if(start==null){
            System.out.println("Queue is empty");
            return(-1);
        }
        return(start.value);
    }

    public int size(){
        return(currSize);
    }


}

public class D_ImplementQueueUsingLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
    
        System.out.println("Initial size: " + queue.size()); // 0
        queue.pop(); // Queue underflow!
    
        queue.push(10);
        queue.push(20);
        queue.push(30);
    
        System.out.println("Top element: " + queue.top()); // 10
        System.out.println("Size: " + queue.size()); // 3
    
        System.out.println("Popped: " + queue.pop()); // 10
        System.out.println("Top element: " + queue.top()); // 20
        System.out.println("Size: " + queue.size()); // 2
    
        queue.pop();
        queue.pop();
        queue.pop(); // Queue underflow!
    }
}
