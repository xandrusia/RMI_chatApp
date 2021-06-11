package Assignment3.shared.networking;

import Assignment3.shared.transferobjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {

    void sendMessage(Message message) throws RemoteException;
    void setId(String id) throws RemoteException;
    List<Message> getAllMessages() throws RemoteException;
    List<String> getIds() throws RemoteException;
    void sendDirectMessage(Message msg) throws RemoteException;
    void registerClient(ClientCallback clientCallback) throws RemoteException;
    //void registerId(ClientCallback clientCallback) throws RemoteException;
    //void registerDirectMess(ClientCallback clientCallback) throws RemoteException;


}
