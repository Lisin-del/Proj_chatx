package Client;
import java.net.*;
import java.util.*;
import java.io.*;

public class Stream_out extends Thread {
    private Socket socket;
    private OutputStreamWriter out;
    private BufferedWriter bf_out;
    private Scanner inp;
    private String message;

    public Stream_out(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        client_start();
    }

    public void client_start() {

        try {
            out = new OutputStreamWriter(socket.getOutputStream());
            bf_out = new BufferedWriter(out);
            inp = new Scanner(System.in);

            while(true) {
                message = inp.nextLine();
                bf_out.write("Client> " + message + "\n");
                bf_out.flush();
            }
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }

    }


}
