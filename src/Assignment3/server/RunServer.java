package Assignment3.server;

import Assignment3.server.model.ModelManagerServer;
import Assignment3.server.networking.RMIServerImpl;
import Assignment3.shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RMIServerImpl ss = new RMIServerImpl(new ModelManagerServer());
        ss.startServer();
    }
}
