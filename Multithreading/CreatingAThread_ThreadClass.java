/*Thread in java can be created via the thread class or the runnable interface. We are going to see the first method here. */

//0.Note that Thread class has various inbuilt methods and constructors included into it. Run, start, sleep, suspend etc are all part of this

//1.To create a thread the first step is to extend the thread class.
class test extends Thread{
//2. The next step is to overide the run method of thread class.
    public void run(){

    }

    public static void main(String[] args) {
        //3.The next step is to create a object of test class
        test t=new test();
        //4.Next step is to create the start of the thread
        t.start();
        //5.Note that the thread class generally calls the run function. As per cycle of thread, we know after completion of thread is done, it goes dead. Hence even if we want to restarted a thread, we will get exception.
        t.start();//This we throw a exception
        //6.In general we have that this method is better than thread class one. This is because, its extention and better performing.

        //7.If we run the "run" method in place of start, we will have the same output, but, no thread will be created.
    }

}