import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个serverSocket，绑定端口12000
        int serverPort = 12000;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("服务器已启动，等待连接：");
        //接收客户端连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功:" + socket.getInetAddress() + " " + socket.getPort());
        //创建inputStream获取客户端发送来的输入流
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String massage = dataInputStream.readUTF();
        System.out.println(massage);
        //创建OutputStream获取输出流
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(massage);
        //关闭连接
        socket.close();
    }
}
