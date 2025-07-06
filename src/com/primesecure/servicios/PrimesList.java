/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.primesecure.servicios;

import java.util.ArrayList;

/**
 * Clase para representar una lista de números primos.
 * 
 * @author Jennifer y Guiselle
 */

public class PrimesList extends ArrayList<Integer> {

    // Método isPrime para verificar si un número es primo
    public boolean isPrime(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Método getPrimesCount que devuelve la cantidad de números primos en la lista
    public synchronized int getPrimesCount() {
        return this.size();
    }

    // Sobreescritura del método add()
    @Override
    public synchronized boolean add(Integer numero) {
        if (numero == null) {
            throw new IllegalArgumentException("Número inválido: No se puede agregar un valor nulo.");
        }
        if (isPrime(numero)) {
            return super.add(numero);
        } else {
            throw new IllegalArgumentException("Número inválido: El número no es primo.");
        }
    }

    // Sobreescritura del método remove()
    @Override
    public synchronized boolean remove(Object o) {
        return super.remove(o);
    }

}
