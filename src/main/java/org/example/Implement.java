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
            numeroAleatorio = random.nextInt(column+1);
            j=random.nextInt(n);
            i=random.nextInt(n);
            sudoku[i][j]=numeroAleatorio;
            counter++;
        }



        return sudoku;
    }

    @Override
    public void showMatrix(int[][] sudoku) throws RemoteException {
        int size = sudoku.length;

        System.out.println("Te presentamos la matriz de " + size + "x" + size);

        for (int i = 0; i < size; i++) {
            if (i > 0 && i % Math.sqrt(size) == 0) {
                printHorizontalLine(size);
            }

            System.out.print("|");
            for (int j = 0; j < size; j++) {
                if (j > 0 && j % Math.sqrt(size) == 0) {
                    System.out.print(" |");
                }
                if(sudoku[i][j]>=10){
                    System.out.print(" "+sudoku[i][j]);
                }else{
                    System.out.print("  " + sudoku[i][j]);
                }
            }
            System.out.println(" |");
        }

        System.out.println();
    }

    private void printHorizontalLine(int size) {
        int lineLength = (int)Math.sqrt(size) +size+(size/2);
        for (int i = 0; i < lineLength; i++) {
            System.out.print(" -");
        }
        System.out.println();
    }

    public int[][] playSudoku(int[][] sudoku) {
        Random random = new Random();
        int numeroAleatorio ;
        for (int i = 0;i<sudoku.length ; i++) {
            for (int j = 0; j <sudoku.length ; j++) {
                    if(sudoku[i][j]==0){
                        sudoku[i][j]=random.nextInt(sudoku.length)+1;
                    }
            }
        }

        return sudoku;
    }
    public String isSudokuFilledCorrectly(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            if (!isValid(sudoku[i])) {
                return "No sirve";
            }
        }

        for (int j = 0; j < sudoku[0].length; j++) {
            int[] column = new int[sudoku.length];
            for (int i = 0; i < sudoku.length; i++) {
                column[i] = sudoku[i][j];
            }
            if (!isValid(column)) {
                return "No sirve";
            }
        }

        int regionSize = (int) Math.sqrt(sudoku.length);
        for (int row = 0; row < sudoku.length; row += regionSize) {
            for (int col = 0; col < sudoku.length; col += regionSize) {
                if (!isValidRegion(sudoku, row, col, regionSize)) {
                    return "No sirve";
                }
            }
        }

        return "Si sirve";
    }

    private boolean isValid(int[] array) {
        boolean[] seen = new boolean[array.length];
        for (int value : array) {
            if (value != 0) {
                if (seen[value - 1]) {
                    return false; // Número repetido
                }
                seen[value - 1] = true;
            }
        }
        return true;
    }

    private boolean isValidRegion(int[][] sudoku, int startRow, int startCol, int regionSize) {
        boolean[] seen = new boolean[sudoku.length];
        for (int row = startRow; row < startRow + regionSize; row++) {
            for (int col = startCol; col < startCol + regionSize; col++) {
                int value = sudoku[row][col];
                if (value != 0) {
                    if (seen[value - 1]) {
                        return false; // Número repetido en la región
                    }
                    seen[value - 1] = true;
                }
            }
        }
        return true;
    }



}
