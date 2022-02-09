package day31.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("服务器已经启动");
            while (true){
                Socket socket = serverSocket.accept();
                new Thread( new SeverRunnable(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
