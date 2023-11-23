package StackAndQueue;

public class CustomQueue {
    //Lets first see the basic properties of our queue. 1)Internal implementation is array.
    private int queueArray[];
    private int size;
    int Default_Size=10;
    //Keeps track of the last element position
    int pointer=-1;

    //2 construtors for manufacturing of the queue
    public CustomQueue(){
        this.size=Default_Size;
        this.queueArray=new int[size];
    }

    public CustomQueue(int len){
        this.size=len;
        this.queueArray=new int[size];
    }
    
    //Lets now start implementing the processes inside a queue
    //Adding an element
    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full, element cannot be added");
            return;
        }
        pointer++;
        queueArray[pointer]=value;
    }

    public boolean isFull(){
        if(pointer==size-1){
            return(true);
        }
        return(false);
    }

    //Removing element from the queue
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty nothing to remove");
            return(-1);
        }
        int returnElement=queueArray[0];
        for(int i=1;i<=pointer;i++){
            queueArray[i-1]=queueArray[i];
        }
        queueArray[pointer]=0;
        pointer--;
        return(returnElement);
    }

    public boolean isEmpty(){
        if(pointer==-1){
            return(true);
        }
        return(false);
    }

    //Display
    public void Display(){
        if(isEmpty()){
            System.out.println("Queue is empty,nothing to display");
            return;
        }
        for(int i=0;i<=pointer;i++){
            System.out.print(queueArray[i]+"<-");
        }
        System.out.println("END");
    }

    //Displaying just the top element
    public void front(){
        if(isEmpty()){
            System.out.println("Queue is empty, nothing to display");
            return;
        }
        System.out.println(queueArray[0]);
    }

    //Now lets implement the queue 
    public static void main(String[] args) {
        CustomQueue queue=new CustomQueue(5);
        queue.enqueue(10);
        queue.enqueue(9);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(6);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.front();
        
        queue.dequeue();

        queue.Display();
    }
}
