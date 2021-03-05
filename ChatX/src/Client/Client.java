package Client;
import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    private Socket socket;
    private String host = "192.168.1.98";
    private String message;
    private int PORT = 4545;
    private InputStreamReader in;
    private BufferedReader bf_in;

    public void run_client() {
        System.out.println("---Client is started---");

        try {
            socket = new Socket(host, PORT);
            in = new InputStreamReader(socket.getInputStream());
            bf_in = new BufferedReader(in);

            Stream_out new_stream = new Stream_out(socket);
            Thread run_stream = new Thread(new_stream);
            run_stream.start();

            while(true) {

                message = bf_in.readLine();
                System.out.println(message);
            }

        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }


}
