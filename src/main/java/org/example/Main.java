package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float n1, n2, res; int choice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.Matriz 4x4 ");
            System.out.println("2.Matriz 9x9     ");
            System.out.println("3.Matriz 16x16    ");
            System.out.println("4.Salir    ");
            try {
                choice=Integer.parseInt(br.readLine());
                Implement impl= new Implement();
                
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } while (choice != 4);

    }
}


