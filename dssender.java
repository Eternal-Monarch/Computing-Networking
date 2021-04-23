import java.net.*;  
import java.io.*;  
public class DSender {  
	public static void main(String[] args) throws Exception {  
		int port=1085;  
		String msg="";
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds = new DatagramSocket();
		InetAddress Address = InetAddress.getByName("localhost");
		System.out.println("Enter Massage for Client");
		msg=br.readLine();		
		DatagramPacket dp = new DatagramPacket(msg.getBytes(),msg.length(),Address,port);
		ds.send(dp);
		ds.close();
	}
}
