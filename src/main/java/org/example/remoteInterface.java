package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface remoteInterface extends Remote {

    int[][] creatSudoku(int tamaño) throws RemoteException;
    int[][] fillMatrix(int tamaño, int[][] sudoku) throws RemoteException;
    void showMatrix(int[][] sudoku) throws RemoteException;
}
