package day31;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;

        try {
            socket = new Socket("127.0.0.1",8080);
            String request = "hello";
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(request);
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String response = dataInputStream.readUTF();
            System.out.println("服务器说: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                outputStream.close();
                dataOutputStream.close();
                inputStream.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
