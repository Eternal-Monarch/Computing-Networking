import java.io.*;
import java.net.*;
import java.util.*;
public class Checksum_Sender
{
	

	// Driver Method
	public static void main(String args[]) throws IOException
	{
        int MAX = 100;
	Socket socket = null;
	ServerSocket servsock = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
		int port=4545;
        servsock = new ServerSocket(port);
		
		
		socket = servsock.accept();
		
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		
		while (true)
		{
			int i, l, sum = 0, nob;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter data length");
			l = sc.nextInt();
			
			
			int data[] = new int[MAX];
			
			
			int c_data[] = new int[MAX];
			
			System.out.println("Enter data to send");
			
			for (i = 0; i < l; i++)
			{
				data[i] = sc.nextInt();
				
				
				nob = (int)(Math.floor(Math.log(data[i]) / Math.log(2))) + 1;
				
				
				c_data[i] = ((1 << nob) - 1) ^ data[i];
				
				
				sum += c_data[i];
			}
			
			
			data[i] = sum;
			l += 1;
			
			System.out.println("Checksum Calculated is : " + sum);
			System.out.println("Data being sent along with Checkum.....");
			
			
			dos.writeInt(l);
			
			
			for (int j = 0; j < l; j++)
				dos.writeInt(data[j]);
			
		
			if (dis.readUTF().equals("success"))
			{
				System.out.println("Thanks for the feedback!! Message received Successfully!");
				break;
			}
			
			else if (dis.readUTF().equals("failure"))
			{
				System.out.println("Message was not received successfully!");
				break;
			}
		}
		
		// Closing all connections
		dis.close();
		dos.close();
		socket.close();
	}
}
