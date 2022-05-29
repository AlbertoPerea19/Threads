package com.threads;

public class HiloModa extends Thread{

   int totalElementos;
   int[] frecuencias;
   int[] moda;
   int mayor;

   
   //contructor
   public HiloModa(int[] frecuencias) {
      this.frecuencias = frecuencias;
      this.totalElementos=Main.a.length;
      this.mayor=0;
   }



   @Override
   public void run() {
      //asignar mayor
      for (int i = 0; i < 100; i++) {
         if (mayor<frecuencias[i]) {
            mayor=frecuencias[i];
         }
      }
      
   }
   //Obtener arreglo moda
   public void getModa(){
      //Obtener cuantos datos repiten moda
      int cont=0;
      for (int i = 0; i < frecuencias.length; i++) {
         if (frecuencias[i]==mayor) {
            cont++;
         }
      }
      //asignar las modas al arreglo
      moda=new int[cont];
      int j=0;
      for (int i = 0; i < frecuencias.length; i++) {
         if (frecuencias[i]==mayor) {
            moda[j]=i;
            j++;
         }
      }
      
   }

   //Pasarlo a string para su facil lectura
   public String toString(){
      getModa();
      String multimoda="[";
      for (int i = 0; i < moda.length; i++) {
         multimoda=multimoda+(moda[i] +" ");
      }
      multimoda=multimoda+"]";
      return multimoda;
   }

   

   

}
