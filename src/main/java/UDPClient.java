import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args)throws IOException {

        //获取主机地址和设置一个端口号
        InetAddress serverName = InetAddress.getLocalHost();
        int serverPort = 12000;
        //创建客户端的UDP套接字
        DatagramSocket clientSocket = new DatagramSocket();
        //输入一个字符串
        Scanner input = new Scanner(System.in);
        String massage = input.nextLine();
        //输入的字符串转化为字节数组
        byte[] bySend = massage.getBytes();
        //定义一个空的字节数组用来接收数据
        byte[] byReceive = new byte[1024];
        //获取字节数组的长度
        int lengthSend = bySend.length;
        //获取收到的字节数组的长度
        int lengthReceive = byReceive.length;
        //创建DatagramPacket对象封装将要发送的字节数组的指针，长度，目的地址IP和端口号
        DatagramPacket packet = new DatagramPacket(bySend, lengthSend, serverName, serverPort);
        //发送
        clientSocket.send(packet);
        //创建DatagramPacket对象封装将要接收的字节数组的指针
        DatagramPacket modifiedPacket = new DatagramPacket(byReceive, lengthReceive);
        //接收
        clientSocket.receive(modifiedPacket);
        //创建String对象接收服务端回复的数据
        String receive = new String(modifiedPacket.getData());
        //输出
        System.out.println(receive.trim());
        //客户端UDP套接字关闭
        clientSocket.close();
    }

}
