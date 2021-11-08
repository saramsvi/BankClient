package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    private Socket clientSocket;
    private ObjectInputStream clientInpStream;
    private ObjectOutputStream clientOutpStream;

    public void connect() throws IOException {
        clientSocket = new Socket("127.0.0.1", 1441);
        clientOutpStream = new ObjectOutputStream(clientSocket.getOutputStream());
        clientInpStream = new ObjectInputStream(clientSocket.getInputStream());
    }
//sends
    public void send (Object parameter) throws IOException {
        clientOutpStream.writeObject(parameter);
    }
//receives
    public String recString() throws IOException, ClassNotFoundException {
        String rec = new String();
        rec = (String) clientInpStream.readObject();
        return rec;
    }

    public List<String> recList() throws IOException, ClassNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        list = (ArrayList<String>) clientInpStream.readObject();
        return list;
    }

    public boolean recBool() throws IOException, ClassNotFoundException {
        boolean flag = false;
        flag = (boolean) clientInpStream.readObject();
        return flag;
    }

}
