/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.siguienteajuste;

/**
 *
 * @author omarb
 */
public class Particion {
    
    int id;
    int tamParti;
    boolean ocupada;
    String nombreProceso;
    
    public Particion(int id,int tamano)
    {
        this.id=id;
        this.tamParti=tamano;
        this.ocupada=false;
        this.nombreProceso = "";
    }
    
}
