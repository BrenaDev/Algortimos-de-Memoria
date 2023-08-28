/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simumemoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//PARTE 1

//PRIMER AJUSTE (nombre del ejercicio y algoritmo
//Satisfacer la memoria vacia: el tamaño de proceso menor a la de la particion

//EJERCICIO
//Declarar memoria o pedirla
//realizar un programa que pida al usuario la cantidad de particiones y su tamano
//pedir la cantidad de procesos y pedir el nombre (inlcuyendo sistema operrativo)

//imprimir que si no entra pues desocupado
//decir cuantos espacios libres hay en memoria quedan


public class SimuMemoria {

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


