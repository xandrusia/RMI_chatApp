package Assignment3.client.core;

import Assignment3.client.networking.Client;
import Assignment3.client.networking.RMIClient;

public class ClientFactory
{
    private static ClientFactory instance;

    static
    {
        instance = new ClientFactory();
    }
    public static ClientFactory getInstance()
    {
        return instance;
    }

    private Client client;
    private ClientFactory()
    {}

    public Client getClient()
    {
        if(client == null)
        {
            client = new RMIClient();
        }
        return client;
    }
}
