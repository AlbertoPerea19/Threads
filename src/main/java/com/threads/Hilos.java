package com.threads;

public class Hilos extends Thread{

   //Main main= new Main();
   int min,max;

   //arreglo de frecuencias
   int cont[]=new int[100];
   //arreglo de numeros
   int b[]=new int[30];
   
   //constructor
   public Hilos(int min, int max) {
      this.min = min;
      this.max = max;
      inicializar();
      
   }


   @Override
   public void run() {
      //asignacion del arreglo de numeros
      b=Main.a;
      
      //asignacion del arreglo de frecuencias
      for (int i = min; i < max; i++) {
         cont[b[i]]++;
         
      }
   }

   //Inicializar arreglos
   public void inicializar(){
      for(int i=0;i<100; i++){
          cont[i]=0;
      }
  }

   //Getter y Setters
   public int getMin() {
      return min;
   }

   public void setMin(int min) {
      this.min = min;
   }

   public int getMax() {
      return max;
   }

   public void setMax(int max) {
      this.max = max;
   }

   
   
   
}
