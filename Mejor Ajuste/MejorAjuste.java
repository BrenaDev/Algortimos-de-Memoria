/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mejorajuste;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author omarb
 */
//MEJOR AJUSTE (nombre del ejercicio y algoritmo)

//EJERCICIO
//Elige la mejor particion para el proceso
//En forma ordenada 

//imprimir memoria sobrante
//espacios sobrantes

public class MejorAjuste {
    
    public static void ordenarParticiones(List<Particion> particiones) {
        for (int i = 0; i < particiones.size() - 1; i++) {
            for (int j = 0; j < particiones.size() - i - 1; j++) {
                if (particiones.get(j).tamParti > particiones.get(j + 1).tamParti) {
                    Particion temp = particiones.get(j);
                    particiones.set(j, particiones.get(j + 1));
                    particiones.set(j + 1, temp);
                }
            }
        }
    }

    // Función de ordenamiento burbuja para procesos
    public static void ordenarProcesos(List<Proceso> procesos) {
        for (int i = 0; i < procesos.size() - 1; i++) {
            for (int j = 0; j < procesos.size() - i - 1; j++) {
                if (procesos.get(j).tamProce > procesos.get(j + 1).tamProce) {
                    Proceso temp = procesos.get(j);
                    procesos.set(j, procesos.get(j + 1));
                    procesos.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        //instancia para scanner
        Scanner scanner = new Scanner(System.in);
        
        //memoria total menos  sistema operativo
        System.out.print("Ingrese la memoria total: ");
        int memoriaTotal = scanner.nextInt();
        
        int SO = 100;
        
        //para saber la memoria que queda disponible si no se asigna
        int espacioMemoria = memoriaTotal;
        
        int espacios_sin_asignar = 0;
        
        //pedimos la cantidad de particiones
        System.out.print("Ingrese la cantidad de particiones que habrá: \n");
        int numParti = scanner.nextInt();
        
        List<Particion> particiones = new ArrayList<>(); //arreglo
        //pediremos e ingresaremos los datos de particiones
        for(int i=0; i<numParti;i++){
            System.out.print("Ingrese el tamaño de la particion "+(i+1)+": ");
            int tamParti = scanner.nextInt();
            
            particiones.add(new Particion(i+1, tamParti));  
        }
        
        //ORDENAMIENTO DE LAS PARTICIONES
        ordenarParticiones(particiones);
        
        //ingresamos los procesos cantidad
        System.out.print("Ingrese la cantidad de procesos que habrá: ");
        int numProce = scanner.nextInt();
        
        List<Proceso> procesos = new ArrayList<>();
        
        procesos.add(new Proceso("S0", SO));
        //ingresamos los nombres de los proceso
        for(int i=0;i<numProce;i++){
            scanner.nextLine(); //consumir la nueva linea independiente
            System.out.print("Ingrese el nombre del proceso "+(i+1)+": ");
            String nombreProceso = scanner.nextLine();

            System.out.print("Ingrese el tamaño del proceso: ");
            int tamProce = scanner.nextInt();
            
            
            procesos.add(new Proceso(nombreProceso, tamProce));
           
        }
        
        //ORDENAMIENTO DE LOS PROCESOS
        ordenarProcesos(procesos);
        
        
        System.out.print("----------------------------------------\n");
        
        
        
        //proceso para meter cada proceso en particion
        for( int i=0; i<procesos.size();i++){ //mide el tamaño
            Proceso proceso = procesos.get(i); //.get se le asigna a proceso
            boolean asignado = false;
            
            for (int j=0; j<particiones.size();j++){
                Particion particion = particiones.get(j);
                if (!particion.ocupada && particion.tamParti >= proceso.tamProce){
                    particion.ocupada = true;
                    particion.nombreProceso = proceso.nombre;
                    asignado = true;
                    
                    espacioMemoria -= proceso.tamProce;
                    
                    System.out.print(proceso.nombre +" asignado a la Particion "+particion.id+"\n");
                    break;
                }
            }
            if(!asignado){
                System.out.println(proceso.nombre+" No fuiste asignado a memoria");
                espacios_sin_asignar ++;
            }
        }
        System.out.println("Los espacios libres en memoria son de: "+ espacios_sin_asignar);
        System.out.println("La memoria disponible final es de: "+espacioMemoria);
  
    }
}
