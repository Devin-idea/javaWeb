package day31.threads;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new ClientRunnable(i)).start();
        }
    }
}
