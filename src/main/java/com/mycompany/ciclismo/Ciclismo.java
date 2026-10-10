/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ciclismo;
import modelo.atleta;
import modelo.competidor;
/**
 *
 * @author Daniel Alejandro
 */
public class Ciclismo {
public static void main(String[] args) {
        System.out.println("=== COMPROBACIÓN DEL EJERCICIO DEL CICLISTA / COMPETIDOR ===");

        // 1. Instanciación y comprobación de herencia
        // Parámetros: nombre, edad, país, ranking inicial, estatura, peso
        competidor ciclista = new competidor("Egan Bernal", 27, "Colombia", 100, 1.75, 60.0);

        // 2. Comprobación de sobreescritura (toString) con super.toString()
        System.out.println("\n--- 1. Datos iniciales (Comprobación de toString) ---");
        System.out.println(ciclista.toString());

        // 3. Comprobación de sobrecarga 1: actualizarRanking(puntos)
        System.out.println("\n--- 2. Sobrecarga 1: Sumar 20 puntos simples ---");
        ciclista.actualizarRanking(20);
        System.out.println("Ranking esperado: 120 -> Obtenido: " + ciclista.getRanking());

        // 4. Comprobación de sobrecarga 2 y estructura anidada:
        // Caso A: Ganó medalla con más de 50 puntos (bonificación alta = +30)
        System.out.println("\n--- 3. Sobrecarga 2 (Caso A): Ganó medalla con 60 puntos (>50) ---");
        // Ranking actual (120) + 60 puntos + 30 bonificación = 210
        ciclista.actualizarRanking(60, true);
        System.out.println("Ranking esperado: 210 -> Obtenido: " + ciclista.getRanking());

        // Caso B: Ganó medalla con 40 puntos (<=50, bonificación estándar = +15)
        System.out.println("\n--- 4. Sobrecarga 2 (Caso B): Ganó medalla con 40 puntos (<=50) ---");
        // Ranking actual (210) + 40 puntos + 15 bonificación = 265
        ciclista.actualizarRanking(40, true);
        System.out.println("Ranking esperado: 265 -> Obtenido: " + ciclista.getRanking());

        // Caso C: No ganó medalla (sin bonificación extra = +0)
        System.out.println("\n--- 5. Sobrecarga 2 (Caso C): No ganó medalla con 10 puntos ---");
        // Ranking actual (265) + 10 puntos + 0 bonificación = 275
        ciclista.actualizarRanking(10, false);
        System.out.println("Ranking esperado: 275 -> Obtenido: " + ciclista.getRanking());

        System.out.println("\n--- Estado final del competidor ---");
        System.out.println(ciclista.toString());
        System.out.println("\n=== TODAS LAS PRUEBAS EJECUTADAS ===");
    }
}
