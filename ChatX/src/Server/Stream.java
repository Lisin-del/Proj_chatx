package Server;
import java.net.*;
import java.io.*;
import java.util.*;

public class Stream extends Thread {
    private Socket socket;
    private Server server;
    private InputStreamReader in;
    private OutputStreamWriter out;
    private BufferedReader bf_in;
    private BufferedWriter bf_out;
    private String message;




    public void run() {
        str_run();
    }

    public Stream(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    public void str_run() {


        try {
            in = new InputStreamReader(socket.getInputStream());
            out = new OutputStreamWriter(socket.getOutputStream());
            bf_in = new BufferedReader(in);
            bf_out = new BufferedWriter(out);

            while(true) {
                message = bf_in.readLine();
                System.out.println(message);
                server.sendAllClients(message);
            }

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMess(String mess) {
        try {
            bf_out.write("Server> " + mess + "\n");
            bf_out.flush();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

}
