class test extends Thread{
    public void run(){
        System.out.println("Process Running");
        System.out.println(Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        //1.Below using the getPriority method we are getting priority of main thread and t1 thread. Note that by default priority of main is 5.
        System.out.println(Thread.currentThread().getPriority());
        test t1=new test();
        t1.start();
        System.out.println(t1.getPriority());
        //2.One thing to notice here is that both main and t1 thread have the same priority. This is because, child thread inherits the priority of parent thread unless changed specifically. This can be seen in the case of main, t1 and run, each of which are child of the other.

        //3.Let see few instances where we are setting the priority.
        t1.setPriority(MAX_PRIORITY);
        //4.We can use MIN_PRIORITY OR MAX_PRIORITY and similar keywords for setting priority or we can use keywords from 1 to 10. Else runtime exception is throwm, illegalArgument exceptions
        System.out.println(t1.getPriority());
        t1.setPriority(9);
        System.out.println(t1.getPriority());
        //5.Disclaimer: Window doesnt support priorities.
    }
}

