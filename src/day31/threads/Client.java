package day31.threads;

import java.util.TreeMap;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new ClientRunnable(i)).start();
        }
    }
}
