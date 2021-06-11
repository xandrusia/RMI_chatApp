package Assignment3.server.networking;

import Assignment3.server.model.ModelServer;
import Assignment3.shared.networking.ClientCallback;
import Assignment3.shared.networking.RMIServer;
import Assignment3.shared.transferobjects.Message;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServerImpl implements RMIServer {

    private final ModelServer modelServer;

    public RMIServerImpl(ModelServer modelServer) throws RemoteException
    {
        UnicastRemoteObject.exportObject(this,0);
        this.modelServer = modelServer;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Chat App", this);
    }


    @Override
    public void sendMessage(Message message) {
        modelServer.sendMessage(message);
    }

   /* @Override
    public void setId(int id) {
        modelServer.setId((String.valueOf(id)));
    }
    */

    @Override
    public void setId(String id) { //tu byl int
        modelServer.setId(id);
    }

    @Override
    public List<Message> getAllMessages() {
        return modelServer.getAllMessages();
    }

    @Override
    public List<String> getIds() {
        return modelServer.getIds();
    }

    @Override
    public void sendDirectMessage(Message msg) {
        //String message = msg.getAlias() + ": " +msg.getText();
       // String[] array = (msg.toString()).split(": ");
        //Message newMessage = new Message(array[1], array[0]);
        modelServer.sendDirectMessage(msg);
    }

    @Override
    public void registerClient(ClientCallback clientCallback) throws RemoteException {
        modelServer.addPropertyChangeListener("newMessage", evt -> {
            try {
                clientCallback.update((String) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        modelServer.addPropertyChangeListener("newId", evt -> {
            try {
                clientCallback.updateId((ArrayList<String>) evt.getNewValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });


        modelServer.addPropertyChangeListener("newDirectMessage",evt -> {
            try {
                clientCallback.updateDirectMess((String) evt.getNewValue(),(String)evt.getOldValue());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } );
    }

}
