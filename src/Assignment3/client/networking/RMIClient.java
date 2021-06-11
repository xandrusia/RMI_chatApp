package Assignment3.client.networking;

import Assignment3.shared.networking.ClientCallback;
import Assignment3.shared.networking.RMIServer;
import Assignment3.shared.transferobjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIClient implements Client, ClientCallback {

    private RMIServer server;
    private PropertyChangeSupport support;
    private List<Message> messages;
    private ArrayList<String> arrayOfIds = new ArrayList<>();

    public RMIClient() {
        support = new PropertyChangeSupport(this);
    }

    @Override
    public void setId(String id) { //tu byl String
        try {
            server.setId(id);
        } catch (RemoteException e) {
            throw new RuntimeException("Couldnt contact the server");
        }
    }

    @Override
    public List<String> getIds() {
        try {
           return server.getIds();
        } catch (RemoteException e) {
            throw new RuntimeException("Couldnt contact the server");
        }
    }

    @Override
    public List<Message> getAllMessages() {
        try {
            return server.getAllMessages();
        } catch (RemoteException e) {
            throw new RuntimeException("Couldnt contact the server");
        }

    }

    @Override
    public void sendMessage(Message msg) {
        try {
            server.sendMessage(msg);
        } catch (RemoteException e) {
            throw new RuntimeException("Couldnt contact the server");
        }
    }

    @Override
    public void sendDirectMessage(Message msg) {
        try {
            server.sendDirectMessage(msg);
        } catch (RemoteException e) {
            throw new RuntimeException("Couldnt contact the server");
        }
    }

    @Override
    public void startClient() throws IOException {

        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("Chat App");
            server.registerClient(this);
            //server.registerId(this);
            //server.registerDirectMess(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String msg){
        support.firePropertyChange("newMessage", null, msg);

    }

    @Override
    public void updateId(ArrayList<String> arrayOfIds) throws RemoteException {
        support.firePropertyChange("newId", null, arrayOfIds);
    }

    @Override
    public void updateDirectMess(String msg, String user) throws RemoteException {

        support.firePropertyChange("newDirectMessage", user, msg);
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        support.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        support.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
