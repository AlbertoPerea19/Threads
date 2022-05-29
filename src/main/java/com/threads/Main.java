package com.threads;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Main 
{

    //Arreglo de numeros
    static int a[]= new int[600000];
    //Arreglo de frecuencias
    static int[] frecuencias = new int[100];
    public static void main( String[] args )
    {
        
        Main main=new Main();
        //Arreglo de threads
        Hilos [] h= new Hilos[3];
        //Arreglo de numeros
        
        
        //Generar numero random desde 0-99
        for (int i = 0; i < a.length; i++) {
            int num=(int)(Math.random()*100);
            a[i]=num;
        }

        //Crear threads con sus min y max
        for (int i = 0; i < 3; i++) {
            int minimo=i*(a.length/3);
            int maximo=(i+1)*(a.length/3);
            
           h[i]= new Hilos(minimo,maximo);
        }

        //Inicializarlos
        h[0].start();
        h[1].start();
        h[2].start();
       
        try {
            //Ponemos a mimir para que termine la operacion
            Thread.sleep(3000);//3 segundos
         } catch (Exception e) {
            System.out.println(e);
         }
         
         //juntar los arreglos de frecuencia
         main.sumaTotal(h[0].cont, h[1].cont, h[2].cont);
          
         //impresion del arreglo de frecuencia
        int suma=0;
        for (int i = 0; i <100; i++) {
            System.out.println(i+"| "+frecuencias[i]);
            suma=suma+frecuencias[i];
        }
        System.out.println("Total de elementos: "+suma);
        
        //Creamos el threads de cada operacion
        HiloMedia media= new HiloMedia(frecuencias);
        HiloMediana mediana= new HiloMediana(frecuencias);
        HiloModa moda= new HiloModa(frecuencias);

        //inicializamos
        media.start();
        mediana.start();
        moda.start();


        try {
            //Ponemos a mimir para que termine la operacion
            Thread.sleep(3000);//3 segundos
         } catch (Exception e) {
            System.out.println(e);
         }

         //Impresion de los resultados
        System.out.println("Media: "+media.getMedia());
        System.out.println("Mediana: "+mediana.getMediana());
        System.out.println("Moda: "+ moda.toString());
            
        //impresion del arreglo de números (para su verificacion)
        /*Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
        */
    }

    //Método para juntar los threads
    public void sumaTotal(int[]a,int[]b,int[]c) {
        
        for (int i = 0; i < 100; i++) {
            frecuencias[i]=a[i]+b[i]+c[i];
        }
        
    }

}
