package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class server{

    public static void main(String []args) throws RemoteException
    {
        Registry reg=LocateRegistry.createRegistry(1098);
        Implement impl=new Implement();
        reg.rebind("Implement", impl);
        System.out.println("servidor iniciado");

    }
}

