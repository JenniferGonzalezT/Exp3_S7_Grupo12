/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.primesecure.app_main;

import com.primesecure.servicios.PrimeAdderTask;
import com.primesecure.servicios.PrimesList;

/**
 * Sistema de gestión de números primos para PrimeSecure.
 * 
 * @author Jennifer y Guiselle
 */

public class PrimeSecure {

    public static void main(String[] args) {
        PrimesList primesList = new PrimesList();
        System.out.println("Se ha iniciado la lista de primos.");
        
        // Creación de Rangos que procesarán los hilos
        int rango1Inicio = 1;
        int rango1Fin = 5000;
        int rango2Inicio = 5001;
        int rango2Fin = 10000;
        int rango3Inicio = 10001;
        int rango3Fin = 15000;
        int rango4Inicio = 15001;
        int rango4Fin = 20000;
        
        // Creación de instancia con las tareas para cada rango
        Runnable tarea1 = new PrimeAdderTask(primesList, rango1Inicio, rango1Fin);
        Runnable tarea2 = new PrimeAdderTask(primesList, rango2Inicio, rango2Fin);
        Runnable tarea3 = new PrimeAdderTask(primesList, rango3Inicio, rango3Fin);
        Runnable tarea4 = new PrimeAdderTask(primesList, rango4Inicio, rango4Fin);
        
        // Creacion de Hilos con cada tarea
        Thread thread1 = new Thread(tarea1, "Hilo 1");
        Thread thread2 = new Thread(tarea2, "Hilo 2");
        Thread thread3 = new Thread(tarea3, "Hilo 3");
        Thread thread4 = new Thread(tarea4, "Hilo 4");
        
        // Iniciar los hilos
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        
        // Esperar a que cada hilo termine
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido: " + e.getMessage());
            
            // Restablecer el hilo
            Thread.currentThread().interrupt();
        }
        System.out.println("Todos los hilos han terminado su ejecución.");
        
        // Mostrar la cantidad de primos en la lista
        System.out.println("Cantidad de números primos en la lista: " + primesList.getPrimesCount());
        
    }

}
