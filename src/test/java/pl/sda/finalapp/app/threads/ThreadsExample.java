package pl.sda.finalapp.app.threads;

import org.junit.jupiter.api.Test;

public class ThreadsExample {

    @Test
    public void basicThreads() {
        Runnable runnableClass = new OurRunnable();
        Runnable runnableAnonymous = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread
                        .currentThread()
                        .getName() + " AnonymousRunnable");
            }
        };
        Runnable runnableLambda = () -> System.out.println(Thread
                .currentThread()
                .getName() + " LambdaRunnable");


        Thread thread = new Thread(runnableClass);
        Thread thread2 = new Thread(runnableAnonymous);
        Thread thread3 = new Thread(runnableLambda);
        thread.start();
        //thread.run();
        thread2.start();
        thread3.start();
    }
}
