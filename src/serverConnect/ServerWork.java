package serverConnect;
//import server.dao.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;

public class ServerWork implements Runnable{

    private Socket clientSocket;
    private ObjectOutputStream output = null;
    private ObjectInputStream input = null;

    public ServerWork(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());

            while(true){
                try{
                    String task = input.readObject().toString();
                    output.writeObject(chooseTask(task));
                }catch (SocketException socketException){
                    System.out.println("Client " + clientSocket + "exit!!!");
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
/*
    private Object chooseTask(String task) throws SQLException, ClassNotFoundException {
        String[] strTask = task.split("\\|", 2);
        String[] parameters;
        Object res = false;
        System.out.println("Enter sting: " + task);
        switch(strTask[0]){
            case "logPas":
                parameters = task.split("\\|", 3);
                res = ManagerHandler.login(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "addManag":
                parameters = task.split("\\|", 6);
                res = ManagerHandler.add(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3], parameters[4], parameters[5]);
                break;
            case "deleteManag":
                parameters = task.split("\\|", 2);
                res = ManagerHandler.delete(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "updateManag":
                parameters = task.split("\\|", 7);
                res = ManagerHandler.update(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3], parameters[4], parameters[5], parameters[6]);
                break;
            case "getListManag":
                parameters = task.split("\\|", 3);
                res = ManagerHandler.getList(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "checkLogRep":
                parameters = task.split("\\|", 2);
                res = ManagerHandler.checkRepeat(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "addService":
                parameters = task.split("\\|", 3);
                res = ServiceHandler.add(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "deleteService":
                parameters = task.split("\\|", 2);
                res = ServiceHandler.delete(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "updateService":
                parameters = task.split("\\|", 4);
                res = ServiceHandler.update(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3]);
                break;
            case "getListService":
                parameters = task.split("\\|", 3);
                res = ServiceHandler.getList(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "addClient":
                parameters = task.split("\\|", 5);
                res = ClientHandler.add(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3], parameters[4]);
                break;
            case "deleteClient":
                parameters = task.split("\\|", 2);
                res = ClientHandler.delete(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "updateClient":
                parameters = task.split("\\|", 6);
                res = ClientHandler.update(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3], parameters[4], parameters[5]);
                break;
            case "getListClient":
                parameters = task.split("\\|", 3);
                res = ClientHandler.getList(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "searchClient":
                parameters = task.split("\\|", 2);
                res = ClientHandler.search(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "addCar":
                parameters = task.split("\\|", 4);
                res = CarHandler.add(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3]);
                break;
            case "deleteCar":
                parameters = task.split("\\|", 2);
                res = CarHandler.delete(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "updateCar":
                parameters = task.split("\\|", 5);
                res = CarHandler.update(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3], parameters[4]);
                break;
            case "getListCar":
                parameters = task.split("\\|", 3);
                res = CarHandler.getList(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "getIdCar":
                res = CarHandler.getIdCar(DBHandler.getDbConnection());
                break;
            case "searchBrand":
                parameters = task.split("\\|", 2);
                res = CarHandler.searchBrand(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "searchModel":
                parameters = task.split("\\|", 2);
                res = CarHandler.searchModel(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "searchCar":
                parameters = task.split("\\|", 3);
                res = CarHandler.search(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "getFullList":
                parameters = task.split("\\|", 3);
                res = ClientHandler.getFullList(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "addRep":
                parameters = task.split("\\|", 4);
                res = ServiceReportHandler.add(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3]);
                break;
            case "deleteRep":
                parameters = task.split("\\|", 2);
                res = ServiceReportHandler.delete(DBHandler.getDbConnection(), parameters[1]);
                break;
            case "updateRep":
                parameters = task.split("\\|", 5);
                res = ServiceReportHandler.update(DBHandler.getDbConnection(), parameters[1], parameters[2], parameters[3], parameters[4]);
                break;
            case "getListRep":
                parameters = task.split("\\|", 3);
                res = ServiceReportHandler.getList(DBHandler.getDbConnection(), parameters[1], parameters[2]);
                break;
            case "getIdSurname":
                res = ClientHandler.getIdSurname(DBHandler.getDbConnection());
                break;
            case "getIdTitle":
                res = ServiceHandler.getIdTitle(DBHandler.getDbConnection());
                break;
            case "getDate":
                res = ServiceReportHandler.getDateId(DBHandler.getDbConnection());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + strTask[0]);
        }
        System.out.println("Exit string: " + res);
        return res;
    }
*/

}
