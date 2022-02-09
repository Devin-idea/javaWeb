package day31;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("---------服务端______");
            System.out.println("已经启动,等待客户端请求");
            boolean flag = true;
            while (flag) {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                dataInputStream = new DataInputStream(inputStream);
                String s = dataInputStream.readUTF();
                System.out.println("客户端请求是: "+ s);
                if (s.equalsIgnoreCase("stop")) flag = false;
                String response = "接收到了请求";
                System.out.println("响应是" + response);
                outputStream = socket.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                serverSocket.close();
                inputStream.close();
                dataInputStream.close();
                outputStream.close();
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
