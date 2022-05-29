package com.threads;

public class HiloMedia extends Thread{
   
   int media;
   int totalElementos;
   int[] frecuencias;

   //constructor
   public HiloMedia(int[] frecuencias) {
      this.media=0;
      this.frecuencias=frecuencias;
      this.totalElementos=Main.a.length;
   }

   @Override
   public void run() {
      int total=0;
      //suma de todos los elementos
      for (int i = 0; i < 100; i++) {
         total= total + (i*frecuencias[i]);
      }
      //sacar media
      media=total/totalElementos;
   }

   //Getter
   public int getMedia() {
      return media;
   }

}
