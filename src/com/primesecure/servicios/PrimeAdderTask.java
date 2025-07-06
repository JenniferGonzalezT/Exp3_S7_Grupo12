/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.primesecure.servicios;

/**
 * Clase que implementa la interfaz Runnable
 * 
 * @author Jennifer y Guiselle
 */

public class PrimeAdderTask implements Runnable {
    private PrimesList primesList;
    private int primerNumero;
    private int ultimoNumero;

    public PrimeAdderTask() {
    }

    public PrimeAdderTask(PrimesList primesList, int primerNumero, int ultimoNumero) {
        this.primesList = primesList;
        this.primerNumero = primerNumero;
        this.ultimoNumero = ultimoNumero;
    }
    
    // Sobreescritura del método run()
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - Inicia agregando números primos desde " + primerNumero + " hasta " + ultimoNumero);
        for (int i = primerNumero; i <= ultimoNumero; i++) {
            try {
                if (primesList.isPrime(i)) {
                    primesList.add(i);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Thread.currentThread().getName() + " error al añadir " + i + ": " + e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " - Finaliza la adición de números primos.");
        System.out.println("Cantidad de primos añadidos en el hilo: " + (primesList.getPrimesCount()));
    }

}
