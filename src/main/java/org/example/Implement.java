package org.example;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class Implement extends UnicastRemoteObject implements remoteInterface{
    protected Implement() throws RemoteException {
    }


    @Override
    public int[][] creatSudoku(int n) throws RemoteException {
        int[][] matrix=new int[n][];
        for (int i=0;i<n;i++){
            matrix[i]=new int[n];
        }

        return matrix;
    }
    /*
    * [ [1,2,3,4],[2,3,4,5],[],[] ]
    * */
    @Override
    public int[][] fillMatrix(int n, int[][] sudoku) throws RemoteException {
        System.out.println("Estamos usando fillMatrix");
        return new int[0][];
    }

    @Override
    public void showMatrix(int[][] sudoku) throws RemoteException {
        System.out.println("Estamos usando showMatrix");
    }
}
