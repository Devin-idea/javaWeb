import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket("127.0.0.1",8080);
            String request = "hello";
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(request);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                outputStream.close();
                dataOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
