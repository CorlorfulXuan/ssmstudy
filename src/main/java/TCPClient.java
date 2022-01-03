import javax.xml.crypto.Data;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args)throws IOException {
        //设置服务器地址为本地地址，端口号为12000
        InetAddress serverName = InetAddress.getLocalHost();
        int serverPort = 12000;
        //创建一个clientSocket发起连接
        Socket clientSocket = new Socket(serverName, serverPort);
        //获取套接字的输出流
        OutputStream outputStream = clientSocket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        Scanner input = new Scanner(System.in);
        String massage = input.next();
        dataOutputStream.writeUTF(massage);
        //获取套接字的输入流
        InputStream inputStream = clientSocket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println("发送的消息为：" + dataInputStream.readUTF());
        //关闭连接
        clientSocket.close();
    }
}
