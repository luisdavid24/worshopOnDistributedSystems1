package org.example;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Implement extends UnicastRemoteObject implements remoteInterface{
    protected Implement() throws RemoteException {
    }


    @Override
    public int[][] creatSudoku(int tamaño) throws RemoteException {
        System.out.println("Estamos usando creatSudoku");
        return new int[0][];
    }

    @Override
    public int[][] fillMatrix(int tamaño, int[][] sudoku) throws RemoteException {
        System.out.println("Estamos usando fillMatrix");
        return new int[0][];
    }

    @Override
    public void showMatrix(int[][] sudoku) throws RemoteException {
        System.out.println("Estamos usando showMatrix");
    }
}
