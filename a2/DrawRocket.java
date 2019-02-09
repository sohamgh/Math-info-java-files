//Soham Ghosh
//TA: Charles Mihral
//CSE 142
//11th October 2016

public class DrawRocket {
   public static final int SIZE=6; 
   public static void main(String[] args){
      drawcone();
      line();
      drawbody1();
      drawbody2();
      line();
      drawbody2();
      drawbody1();
      line();
      drawcone();
   }
   
   public static void drawcone(){
      for (int i = 1; i<= SIZE*2-1; i++){
         for(int l = (SIZE * 2 - i); l >= 1; l--){
            System.out.print(" ");
         }
         for(int j = 1; j <= i; j++) {
            System.out.print("/");
         }
         System.out.print("**");
         for(int j = 1; j <= i; j++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   public static void line(){
      System.out.print("+");
      for(int b = 1; b <= SIZE * 2; b++){
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   public static void drawbody1(){
      for (int i = 1; i <= SIZE; i++){
         System.out.print("|");
         for(int l = -1 * i + SIZE; l >= 1; l--){
            System.out.print(".");
         }
         for(int j = 1; j <= i; j++) {
            System.out.print("/\\");
         }
         for(int x = -2 * i + (SIZE * 2); x >= 1; x--){
            System.out.print(".");
         }
         for(int n = 1; n <= i; n++){
            System.out.print("/\\");
         }
         for(int l = -1 * i + SIZE; l >= 1; l--){
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println("");
      }
   }
   
   public static void drawbody2(){
      for (int i = 1; i <= SIZE; i++){
         System.out.print("|");
         for(int j = 1; j <= i - 1; j++){
            System.out.print(".");
         }
         for(int l = -1 * i + SIZE; l >= 0; l--) {
            System.out.print("\\/");
         }
         for(int x = 2 * i - 2; x >= 1; x--){
            System.out.print(".");
         }
         for(int l = -1 * i + SIZE; l >= 0; l--){
            System.out.print("\\/");
         }
         for(int n = 1; n <= i - 1; n++){
            System.out.print(".");
         }
         System.out.print("|");
         System.out.println("");
      }
   }
}

