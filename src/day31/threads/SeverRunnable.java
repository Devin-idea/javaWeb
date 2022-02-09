package day31.threads;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SeverRunnable implements Runnable{
    private Socket socket;

    public SeverRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        DataInputStream dataInputStream = null;
        try {
            inputStream = this.socket.getInputStream();
            dataInputStream = new DataInputStream(inputStream);
            String request = dataInputStream.readUTF();
            System.out.println(request);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
