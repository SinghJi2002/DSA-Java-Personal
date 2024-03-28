class test extends Thread{
    public void run(){
        System.out.println("Process running");
        System.out.println(Thread.currentThread().getName());
        //7.Will return the name of the thread executing this code, that is ashu.
    }
    public static void main(String[] args) {
        //1.Whatever code is inside this is executed by main thread. The name of this thread is given by JVM. All the threads created below will be executed by main thread.

        //2.Here we are getting name of current thread
        System.out.println(Thread.currentThread().getName());
        
        //3.Here giving a new name to the current thread
        Thread.currentThread().setName("Ashutosh");
        System.out.println(Thread.currentThread().getName());

        //4.System.out.println(10/0);//Throws exception with thread name not main but, the name we have given it.
        
        //5.The thread below will execute the run code block. Its name by default is given by JVM which we have changed.
        test t1=new test();
        t1.setName("Ashu");
        t1.start();
        System.out.println(Thread.currentThread().getName());//6.This will print name of thread which will execute this code. That is main.

        //8.using is alive
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(t1.isAlive());
    }
}