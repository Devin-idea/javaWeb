package day31.udb;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TerminalA {
    public static void main(String[] args) {
        try {
            byte[] buff = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
            DatagramSocket datagramSocket = new DatagramSocket(8181);
            datagramSocket.receive(datagramPacket);
            String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("Terminal A, received message from:" + datagramPacket.getSocketAddress() + ": " + "data is : " + message);
//          发送数据
            String response = "I'm terminal A message received";
            SocketAddress socketAddress = datagramPacket.getSocketAddress();
            DatagramPacket datagramPacket2 = new DatagramPacket(response.getBytes(), response.getBytes().length, socketAddress);
            datagramSocket.send(datagramPacket2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
