import java.net.*;

public class DatagramSocketTwo {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        int port = 1085;
        // calling the constructor to create a datagram socket object
        DatagramSocket socket = new DatagramSocket();
        // connects the socket address with this socket
        socket.connect(inetAddress, port);
        // getLocalSocketAddress() returns the local address for this socket
        System.out.println("Local Socket Address: " + socket.getLocalSocketAddress());
        // isBound() will return true if this socket is bounded.
        System.out.println("Socket is bounded or not: " + socket.isBound());
        // setBroadcast() either enables or disables the SO_BROADCAST option
        socket.setBroadcast(false);
        // tests if SO_BROADCAST is enabled or disabled.
        System.out.println("SO_BROADCAST is " + (socket.getBroadcast() ? "enabled" : "disabled"));
        // isConnect() method will return false
        if (socket.isConnected()) {
            // This method will not work if the socket is already closed
            socket.disconnect();
            System.out.println("Socket is successfully disconnected");
        } else {
            System.out.println("Socked is already closed. So the disconnect() method will not work.");
        }
        socket.close();
    }
}
