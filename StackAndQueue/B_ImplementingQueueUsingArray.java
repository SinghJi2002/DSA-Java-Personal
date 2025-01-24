class Queue{
    int size;
    int start=-1;
    int end=-1;
    int[] queue;
    int currSize=0;

    public Queue(int size){
        this.size=size;
        queue=new int[size];
    }

    public void push(int number){
        if(currSize>=size){
            System.out.println("Queue is full");
            return;
        }
        if(currSize==0){
            start=0;
        }
        end=(end+1)%size;
        queue[end]=number;
        currSize++;
    }

    public int pop(){
        if(currSize==0){
            System.out.println("Queue is empty");
            return(-1);
        }
        int elementToReturn=queue[start];
        if(currSize==1){
            start=end=-1;
            return(elementToReturn);

        }
        start=(start+1)%size;
        currSize--;
        return(elementToReturn);
    }

    public int top(){
        if(currSize==0){
            System.out.println("Queue is empty");
            return(-1);
        }
        return(queue[start]);
    }

    public int size(){
        return(currSize);
    }

}


public class B_ImplementingQueueUsingArray {
    public static void main(String[] args) {
        Queue queue=new Queue(10);
        System.out.println(queue.top());
        queue.push(1);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.top());
    }
}
