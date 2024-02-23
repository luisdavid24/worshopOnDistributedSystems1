package org.example;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class server extends UnicastRemoteObject implements remoteInterface{
    public server() throws RemoteException {
        super();
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
    public static void main(String[] args) {
        try {
            server servidor = new server();
            Naming.rebind("GeneradorSudoku", servidor);
            System.out.println("Servidor listo...");
        } catch (Exception e) {
            System.out.println("Excepción en el servidor: " + e.getMessage());
        }
    }
}
