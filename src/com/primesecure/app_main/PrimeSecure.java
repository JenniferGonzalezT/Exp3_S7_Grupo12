/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.primesecure.app_main;

import com.primesecure.servicios.PrimesList;
import java.util.Scanner;

/**
 * Sistema de gestión de números primos para PrimeSecure.
 * 
 * @author Jennifer y Guiselle
 */

public class PrimeSecure {

    private static Scanner scanner = new Scanner(System.in);
    private static PrimesList primesList = new PrimesList();

    public static void main(String[] args) {
        showMenu();
    }

    /**
     * Muestra el menú principal con opciones para gestionar números primos.
     */
    public static void showMenu() {
        int option;

        do {
            System.out.println("\n=== PRIMESECURE - NÚMEROS PRIMOS ===");
            System.out.println("1. Verificar si un número es primo");
            System.out.println("2. Agregar número primo a la lista");
            System.out.println("3. Mostrar lista de números primos");
            System.out.println("4. Contar números primos en la lista");
            System.out.println("5. Eliminar número primo de la lista");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkPrime();
                    break;
                case 2:
                    addPrimeNumber();
                    break;
                case 3:
                    showPrimesList();
                    break;
                case 4:
                    showPrimesCount();
                    break;
                case 5:
                    removePrimeNumber();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar PrimeSecure!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (option != 0);

        scanner.close();
    }

    public static void checkPrime() {
        System.out.print("Ingrese un número para verificar si es primo: ");
        int number = scanner.nextInt();

        if (primesList.isPrime(number)) {
            System.out.println("El número " + number + " ES primo.");
        } else {
            System.out.println("El número " + number + " NO es primo.");
        }
    }

    public static void addPrimeNumber() {
        System.out.print("Ingrese un número primo para agregar a la lista: ");
        int number = scanner.nextInt();

        try {
            primesList.add(number);
            System.out.println("El número primo " + number + " ha sido agregado exitosamente a la lista.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void showPrimesList() {
        if (primesList.isEmpty()) {
            System.out.println("La lista de números primos está vacía.");
        } else {
            System.out.println("Lista de números primos: " + primesList);
        }
    }

    public static void showPrimesCount() {
        int count = primesList.getPrimesCount();
        System.out.println("Cantidad de números primos en la lista: " + count);
    }

    public static void removePrimeNumber() {
        if (primesList.isEmpty()) {
            System.out.println("La lista de números primos está vacía.");
            return;
        }

        System.out.println("Lista actual: " + primesList);
        System.out.print("Ingrese el número primo que desea eliminar: ");
        int number = scanner.nextInt();

        try {
            boolean removed = primesList.remove(Integer.valueOf(number));
            if (removed) {
                System.out.println("El número primo " + number + " ha sido eliminado de la lista.");
            } else {
                System.out.println("El número " + number + " no se encontró en la lista.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
