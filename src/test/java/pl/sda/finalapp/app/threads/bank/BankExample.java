package pl.sda.finalapp.app.threads.bank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BankExample {
    @Test
    public void bankTest() {
        List<Thread> threads = new ArrayList<>();
        Runnable clientAction = new ClinetAction();
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(clientAction));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Balance " + Bank.getBalance());
        System.out.println("Op counter " + Bank.getCounter());
    }

}
