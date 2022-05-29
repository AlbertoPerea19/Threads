package com.threads;

public class HiloMediana extends Thread {
   
   int mediana;
   int totalElementos;
   int[] frecuencias;

   
   //constructor
   public HiloMediana(int[] frecuencias) {
      this.frecuencias = frecuencias;
      this.mediana=0;
      this.totalElementos=Main.a.length;
   }



   @Override
   public void run() {
      int mitadElementos=totalElementos/2;
      int cont=0;
      int frecuenciaAcum=0;

      //Obtener mediana por frecuencia acumulada
      while(frecuenciaAcum<mitadElementos){
         frecuenciaAcum = frecuenciaAcum + frecuencias[cont];
         cont++;
     }
      this.mediana = cont;
   }

   //Getter
   public int getMediana() {
      return mediana;
   }
   
}
