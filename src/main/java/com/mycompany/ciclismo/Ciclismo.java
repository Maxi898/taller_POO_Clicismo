/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ciclismo;

import controlador.ControladorMundial;
import vista.VistaMundial;

/**
 * 
 *
 * @author Daniel Alejandro
 */
public class Ciclismo {

    public static void main(String[] args) {
        VistaMundial vista = new VistaMundial();
        ControladorMundial controlador = new ControladorMundial(vista);
        controlador.iniciar();
    }
}
