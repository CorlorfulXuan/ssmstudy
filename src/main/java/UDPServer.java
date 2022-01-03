import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args)throws IOException {
        //定义服务器的端口号为12000
        int severPort = 12000;
        //创建一个空的字节数组用来接收客户端发来的数据
        byte[] byReceive = new byte[1024];
        //创建一个服务端UDP套接字，并指定端口号
        DatagramSocket serverSocket= new DatagramSocket(severPort);

        //服务器保持开启状态
        while (true){
            //创建一个DatagramPacket用来封装将要接收的客户端发送的指针数组
            DatagramPacket ReceiveData = new DatagramPacket(byReceive, byReceive.length);
            //接收
            serverSocket.receive(ReceiveData);
            //创建一个String对象用来接收数据
            String massage = new String(ReceiveData.getData());
            //创建一个String对象用来发送接受数据的大写
            String sendMassage = massage.toUpperCase();
            //发送数据转换数组
            byte[] bySend = sendMassage.getBytes();
            //创建一个DatagramPacket用来封装将要发送的指针数组
            DatagramPacket SendData = new DatagramPacket(bySend, bySend.length, ReceiveData.getAddress(), ReceiveData.getPort());
            //发送
            serverSocket.send(SendData);

            System.out.println("From IP：" + ReceiveData.getAddress() + ",Port： " + ReceiveData.getPort());
        }
    }
}