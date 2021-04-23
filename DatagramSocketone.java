import java.net.*;

public class DatagramSocketOne {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        int port = 1085;
        InetAddress inetAddress = InetAddress.getByName("localhost");
        // Calling the constructor of the DatagramSocket to create its object.
        DatagramSocket socket = new DatagramSocket();
        // The connect() method connects the inetAddress and port number with this
        // socket
        socket.connect(inetAddress, port);
        // The getRemoteSocketAddress() method returns null if the socket closed
        System.out.println("Remote Socket Address: " + socket.getRemoteSocketAddress());
        // The getLocalPort() returns the local address to which the socket is bound
        System.out.println("Local port number: " + socket.getLocalPort());
        // The getPort()the port number to which this socket is connected.
        System.out.println("Port number: " + socket.getPort());
        // The gteInetAddress() returns the address of the socket
        System.out.println("Address:" + socket.getInetAddress());
        // closing the socket
        socket.close();
    }
}
