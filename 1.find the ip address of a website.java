import java.net.*; 
import java.net.InetAddress.*;
public class Main
{ 
	public static void main(String[] args) { 
		try { 
			InetAddress address = InetAddress.getLocalHost();
			System.out.println("IP address: " + address.getHostAddress());
			System.out.println("Host name : " + address.getHostName());  
		} 
		catch (UnknownHostException uhEx) { 
			System.out.println( "Could not find local address!"); 
		} 
	} 
}
