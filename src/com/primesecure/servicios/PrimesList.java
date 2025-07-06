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

        if (numero <= 3) {
            return true;
        }

        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Método getPrimesCount que devuelve la cantidad de números primos en la lista
    public int getPrimesCount() {
        return this.size();
    }

    // Sobreescritura del método add()
    @Override
    public boolean add(Integer numero) {
        if (isPrime(numero)) {
            return super.add(numero);
        } else {
            throw new IllegalArgumentException("Número inválido: El número no es primo.");
        }
    }

    // Sobreescritura del método remove()
    @Override
    public boolean remove(Object o) {
        if (o instanceof Integer && isPrime((Integer) o)) {
            return super.remove(o);
        } else {
            throw new IllegalArgumentException("Eliminación inválida: Solo se pueden eliminar números primos.");
        }
    }

}
