package pl.sda.finalapp.app.threads;

public class OurRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread
                .currentThread()
                .getName() + " OurRunnable");
    }
}
