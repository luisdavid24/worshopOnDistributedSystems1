package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException {
        int choice = 0;
        int[][] Sudoke = null;
        Implement impl = new Implement();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(" ");
            System.out.println("Por favor, sea tan amable de elegir alguna de las opciones ofrecidas:");
            System.out.println("1.Matriz    4x4 ");
            System.out.println("2.Matriz    9x9  ");
            System.out.println("3.Matriz  16x16 ");
            System.out.println("4.Llenar la matriz  ");
            System.out.println("5.Verificar    ");
            System.out.println("6.Salir    ");
            try {
                choice = Integer.parseInt(br.readLine());

                if (choice != 6) {
                    remoteInterface calcinterface = (remoteInterface) Naming.lookup("Implement");
                    Remote lookup = Naming.lookup("Implement");


                    switch (choice) {
                        case 1:
                            Sudoke = impl.creatSudoku(4);
                            Sudoke = impl.fillMatrix(4, Sudoke);
                            break;

                        case 2:
                            Sudoke = impl.creatSudoku(9);
                            Sudoke = impl.fillMatrix(9, Sudoke);
                            break;

                        case 3:
                            Sudoke = impl.creatSudoku(16);
                            Sudoke = impl.fillMatrix(16, Sudoke);
                            break;
                        case 4:
                            Sudoke=impl.playSudoku(Sudoke);
                            break;
                        case 5:
                            System.out.println(impl.isSudokuFilledCorrectly(Sudoke));

                        default:
                            System.out.println("Selecciona una opcion correcta.");
                            break;
                    }
                    System.out.println(" ");
                    impl.showMatrix(Sudoke);

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NotBoundException e) {
                throw new RuntimeException(e);
            }

        } while (choice != 6);
        System.out.println("Gracias por su tiempo, pero el programa a terminado.");
    }
}
