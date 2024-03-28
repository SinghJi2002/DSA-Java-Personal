//1.The runnable interface only has on method in it, that is run.

//2.First step is to implement the runnable interface.
class Test implements Runnable{
    //3.Next step is to define the run method(overide)
    public void run(){

    }
    //9.The JVM always converts the main method into a thread itself. That is, no matter you want to create a thread or not, by default, a main thread is always executed.
    public static void main(String[] args) {
        //4.Next step is creating new class object.
        Test t=new Test();
        //5. We know inorder to start a thread(runnable) we need the start method. But runnable interface doesnt has its own start method. Hence, we need to create the Thread object and pass class object through it to access neccessary methods.
        Thread th=new Thread(t);
        //6. Next step is call the start method.
        th.start();
    }

    //7.In general we have that this method is better than thread class one. This is because, its extention and better performing.

    //8.If we run the "run" method in place of start, we will have the same output, but, no thread will be created.
}