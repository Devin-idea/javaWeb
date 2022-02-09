import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;

        try {
            serverSocket = new ServerSocket(8080);
            System.out.println("-------服务器已启动——————————");
            System.out.println("等待接受客户端请求");
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String utf = dataInputStream.readUTF();
            System.out.println(utf);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
                socket.close();
                inputStream.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
