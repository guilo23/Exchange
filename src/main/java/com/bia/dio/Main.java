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
            option = Integer.parseInt(sc.nextLine());


            switch (option) {
                case 1 -> {
                    System.out.println("Digite  um valor para ser convertido");
                    value = Double.parseDouble(sc.nextLine());
                    conversor.usdToArs(value);
                    break;
                }

                case 2 -> {
                    System.out.println("Digite  um valor para ser convertido");
                    value = Double.parseDouble(sc.nextLine());
                    conversor.arsToUsd(value);
                }

                case 3 -> {
                    System.out.println("Digite  um valor para ser convertido");
                    value = Double.parseDouble(sc.nextLine());
                    conversor.usdToBrl(value);
                }

                case 4 -> {
                    System.out.println("Digite  um valor para ser convertido");
                    value = Double.parseDouble(sc.nextLine());
                    conversor.brlToUsd(value);
                }

                case 5 -> {
                    System.out.println("Digite  um valor para ser convertido");
                    value = Double.parseDouble(sc.nextLine());
                    conversor.usdToCop(value);
                }

                case 6 -> {
                    System.out.println("Digite  um valor para ser convertido");
                    value = Double.parseDouble(sc.nextLine());
                    conversor.copToUsd(value);

                }

                case 7 -> System.exit(1);

                default ->  System.out.println("Choose a valid option");


            }
            System.out.println();
            System.out.println("Type any Tecla to continue or exit to Exit");
            saida = sc.nextLine();
            if(saida.equals("exit")){
                System.exit(1);
            }

        }
        }
}