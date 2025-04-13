package com.bia.dio;

import com.bia.dio.conversor.Conversor;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String saida;
        int option = -1;
        double value;
        Conversor conversor = new Conversor();
        while (true) {
            System.out.println("**********************************************************");

            System.out.println("Welcome to Currency Converter , Choose a option");

            System.out.println("1) Dolar ===> Argentine Peso");
            System.out.println("2) Argentine Peso ====> Dolar");
            System.out.println("3) Dolar ===> Brasilian Real");
            System.out.println("4) Brasilian Real ===> Dolar");
            System.out.println("5) Dolar ===> Colombian peso");
            System.out.println("6) Colombian peso ===> Dolar");
            System.out.println("7) Sair");

            System.out.println("**********************************************************");
            try {
                System.out.println("type a option");
                option = Integer.parseInt(sc.nextLine());
                if(option <= 0){
                    System.out.println("invalid option type again");
                    value = Double.parseDouble(sc.nextLine());
                }
            } catch (NumberFormatException  e) {
                System.out.println("invalid option type again");

                option = Integer.parseInt(sc.nextLine());

            }
            try {
                System.out.println("type a value to be converted");
                value = Double.parseDouble(sc.nextLine());
                if(value <= 0){
                    System.out.println("invalid Value type again");
                    value = Double.parseDouble(sc.nextLine());
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid Value type again");
                value = Double.parseDouble(sc.nextLine());
            }


            switch (option) {
                case 1 -> {
                    conversor.usdToArs(value);
                }
                case 2 -> {
                    conversor.arsToUsd(value);
                }
                case 3 -> {
                    conversor.usdToBrl(value);
                }
                case 4 -> {
                    conversor.brlToUsd(value);
                }
                case 5 -> {
                    conversor.usdToCop(value);
                }

                case 6 -> {
                    conversor.copToUsd(value);
                }
                case 7 -> System.exit(1);
            }
            System.out.println();
            System.out.println("Type any Tecla to continue or exit to Exit");
            saida = sc.nextLine();
            if (saida.equals("exit")) {
                System.exit(1);
            }

        }
    }
}