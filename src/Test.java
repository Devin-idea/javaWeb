import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
    public static void main(String[] args) {
        try {
//            IP地址：
            InetAddress localHost = InetAddress.getByName("127.0.0.1");
            System.out.println(localHost);
            localHost = InetAddress.getByName("localhost");
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
