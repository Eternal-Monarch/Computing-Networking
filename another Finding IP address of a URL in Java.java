// Java program to demonstrate
// how to fetch public IP Address
import java.net.*;
import java.*;
import java.io.*;
  
class GFG {
    public static void main(String args[])
        throws UnknownHostException
    {
        String systemipaddress = "";
        try {
            URL url_name = new URL("https://bot.whatismyipaddress.com");
  
            BufferedReader sc = new BufferedReader(
                new InputStreamReader(url_name.openStream()));
  
            // reads system IPAddress
            systemipaddress = sc.readLine().trim();
        }
        catch (Exception e) {
            systemipaddress = "Cannot Execute Properly";
        }
        // Print IP address
        System.out.println("Public IP Address: "
                           + systemipaddress + "\n");
    }
}
