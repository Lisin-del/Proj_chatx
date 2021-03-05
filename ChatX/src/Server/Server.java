package Server;
import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    private ServerSocket serv_sock;
    private Socket socket;
    private int PORT = 4545;
    private ArrayList<Stream>streams = new ArrayList<Stream>();


    public void run_server() {
        System.out.println("---Server is started---");

        try {
            serv_sock = new ServerSocket(PORT);

            while(true) {
                socket = serv_sock.accept();
                System.out.println("Input connection: " + socket.getInetAddress());
                Stream new_stream = new Stream(socket, this);
                streams.add(new_stream);
                Thread run_stream = new Thread(new_stream);
                run_stream.start();
            }

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendAllClients(String mess) {
        for(Stream s : streams) {
            s.sendMess(mess);
        }
    }





}
