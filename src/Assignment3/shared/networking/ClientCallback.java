package Assignment3.shared.networking;

import Assignment3.shared.transferobjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClientCallback extends Remote {

    void update(String message) throws RemoteException;
    void updateId(ArrayList<String> arrayOfIds) throws RemoteException;
    void updateDirectMess(String msg, String user) throws RemoteException;


}
