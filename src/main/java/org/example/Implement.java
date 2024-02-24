package org.example;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Implement extends UnicastRemoteObject implements remoteInterface{
    protected Implement() throws RemoteException {
    }

    protected Implement(int port) throws RemoteException {
        super(port);
    }

    protected Implement(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }

    @Override
    public int[][] creatSudoku(int tamaño) throws RemoteException {
        return new int[0][];
    }

    @Override
    public int[][] fillMatrix(int tamaño, int[][] sudoku) throws RemoteException {
        return new int[0][];
    }

    @Override
    public void showMatrix(int[][] sudoku) throws RemoteException {

    }
}
