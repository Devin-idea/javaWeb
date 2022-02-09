package day31.udb;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class TerminalB {
    public static void main(String[] args) {
//        发送消息
        String message = "hello, I'm terminal B ";
        try {
            InetAddress inetAddress = InetAddress.getByName("localhost");
            DatagramPacket datagramPacket2 = new DatagramPacket(message.getBytes(),
                    message.getBytes().length, inetAddress, 8181);
            DatagramSocket datagramSocket = new DatagramSocket(8080);
            datagramSocket.send(datagramPacket2);
            // 接收消息
            byte[] buff = new byte[1024];
            DatagramPacket datagramPacket3 = new DatagramPacket(buff, buff.length);
            datagramSocket.receive(datagramPacket3);
            String response = new String(datagramPacket3.getData(),0, datagramPacket3.getLength());
            System.out.println("Here is terminal B, received " + datagramPacket3.getSocketAddress()
                    + "message : " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
