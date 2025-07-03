/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.primesecure.app_main;

import com.primesecure.servicios.PrimesList;

/**
 * Sistema de gestión de números primos para PrimeSecure.
 * 
 * @author Jennifer y Guiselle
 */

public class PrimeSecure {

    public static void main(String[] args) {
        PrimesList primesList = new PrimesList();
        System.out.println(primesList.isPrime(5));
    }

}
