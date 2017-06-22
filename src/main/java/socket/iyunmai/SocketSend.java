package socket.iyunmai;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketSend {

	private static final Logger logger = LoggerFactory.getLogger(SocketSend.class);
	private static final String ip = "172.0.0.1";
	private static final int port = 10000;
	public static void main(String[] args) {
		sendToReceive();
	}
	
	public static void sendToReceive(){
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		String data = "socket test succeed!";
		byte bytes[] = new byte[1024];
		try {
			socket = new Socket(ip, port);
			os = socket.getOutputStream();
			os.write(data.getBytes());
			is = socket.getInputStream();
			System.out.println(bytes.toString());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("IOException :{}",e.toString());
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
			} catch (IOException e) {
				e.printStackTrace();
				logger.error("IOException :{}",e.toString());
			}
		}
	}
}
