package org.example;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

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
    @Override
    public int[][] fillMatrix(int n, int[][] sudoku) throws RemoteException {
        int column=sudoku.length, rows=sudoku[0].length,counter=0;
        Random random = new Random();
        int i=0,j=0,numeroAleatorio ;
        while(counter<column*rows){
            numeroAleatorio = random.nextInt(10);
            j=random.nextInt(n);
            i=random.nextInt(n);
            sudoku[i][j]=numeroAleatorio;
            counter++;
        }



        return sudoku;
    }

    @Override
    public void showMatrix(int[][] sudoku) throws RemoteException {
        
        System.out.println("Estamos usando showMatrix");
    }
}
