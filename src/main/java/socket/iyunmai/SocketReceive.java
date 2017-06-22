package socket.iyunmai;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketReceive {

	private static final Logger logger = LoggerFactory.getLogger(SocketReceive.class);
	private static final int port = 10000;
	public static void main(String[] args) {

	}
	public static void receiveToSend(){
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		byte bytes[] = new byte[1024];
		try {
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			int end = is.read(bytes);
			System.out.println("客户端发送的信息"+bytes.toString());
			os = socket.getOutputStream();
			os.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				try {
					if(is != null){
					is.close();
					}
					if(os != null){
						os.close();
					}
					if(socket != null){
						socket.close();
					}
					if(serverSocket != null){
						serverSocket.close();
					}
					System.out.println("就这样没了？");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}
