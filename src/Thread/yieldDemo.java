package Thread;

public class yieldDemo {

    public static void main(String[] args){

        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        //myThread1.run();
        for (int i=0; i<5; i++)
        {
            // Control passes to child thread
            Thread.yield();

            // After execution of child Thread
            // main thread takes over
            System.out.println(Thread.currentThread().getName()
                    + " in control");
        }
    }
}

class MyThread1 extends  Thread {

    @Override
    public void run() {
        for (int i=0; i<5 ; i++)
            System.out.println(Thread.currentThread().getName()
                    + " in control");
    }
}
