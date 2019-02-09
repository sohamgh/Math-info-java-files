import java.io.*;
import java.util.*;
public class Personality{
   public static void main(String[] args) throws FileNotFoundException{
      
      
      Scanner console = new Scanner(System.in);
      System.out.println("input file? ");
      String input = console.next();
      System.out.println("output file? ");
      String output = console.next();
      
      Scanner text = new Scanner(new File(input));
      PrintStream outputFile = new PrintStream(output);
      
      
      
      while(text.hasNextLine())  {
         int[] counterA = new int[4] ;
         int[] counterB = new int[4] ;
         String names = makeArray(text,counterA , counterB);
         int[] percentages = finalCalc(counterA, counterB);
         String personality = getPersonality(percentages);
         printFile(   personality, outputFile,  names, percentages);
      }}
      
      //Method prints intro
      public static void intro(){
         System.out.println("This program processes a file of answers to the");
         System.out.println("Keirsey Temperament Sorter.  It converts the");
         System.out.println("various A and B answers for each person into");
         System.out.println("a sequence of B-percentages and then into a");
         System.out.println("four-letter personality type.");
      }
      
      //this method increments the two primary arrays. i.e. to count number of As and Bs by taking in array counter A
      // array counterB and scanner text as parameters. it also returns the name os the person.
      public static String makeArray( Scanner text, int[] counterA , int[] counterB ){
         
         
         String names = text.nextLine();
         String lines = text.nextLine();
         Scanner data = new Scanner(lines) ;
         char token;
         int counter = 0 ;
         int index = 0 ;
         
         while(counter < lines.length()){
            token = lines.charAt(counter);
            if(token == 'A'){
               if (counter%7 == 0){
                  index = 0 ;
                  counterA[index]++;
                  
               }
               
               if (counter % 7 == 1 ||counter % 7 == 2 ){
                  index = 1 ;
                  counterA[index]++;
                  
               }
               if (counter % 7 == 3 ||counter % 7 == 4 ){
                  index = 2 ;
                  counterA[index]++;
                  
               }
               if (counter % 7 == 5 ||counter % 7 == 6 ){
                  index = 3 ;
                  counterA[index]++;
                  
               }
               
            } else if (token == 'B'){
               if (counter%7 == 0){
                  index = 0 ;
                  counterB[index]++;
                  
               }
               
               if (counter % 7 == 1 ||counter % 7 == 2 ){
                  index = 1 ;
                  counterB[index]++;
                  
               }
               if (counter % 7 == 3 ||counter % 7 == 4 ){
                  index = 2 ;
                  counterB[index]++;
                  
               }
               if (counter % 7 == 5 ||counter % 7 == 6 ){
                  index = 3 ;
               counterB[index]++;}
               
            }
            
            counter++ ;
            
            
            
         }
         return names ;
      }
      
      // this method takes in the two arrays as parametres and converts them into a single array
      public static int[] finalCalc(int[] counterA , int[] counterB){
         int[] percentages = new int[4] ;
         percentages[0] = (int)Math.round(100.0 * counterB[0] / (counterA[0] + counterB[0]));
         percentages[1] = (int)Math.round(100.0 * counterB[1] / (counterA[1] + counterB[1]));
         percentages[2] = (int)Math.round(100.0 * counterB[2] / (counterA[2] + counterB[2]));
         percentages[3] = (int)Math.round(100.0 * counterB[3] / (counterA[3] + counterB[3]));
         return percentages ;
      }
    
      //this method converts tbe new array into individual letters and returns a string 
      //that is the combination of individual letter. 
      public static String getPersonality(int[] percentages){
         String dimension0 = "" ;
         String dimension1 = "" ;
         String dimension2 = "" ;
         String dimension3 = "" ;
         if (percentages[0] > 50){
            dimension0 = "I" ;
         }else if (percentages[0] == 50){
         dimension0 = "x";}
         else{ dimension0 = "E" ;
         }
         if (percentages[1] < 50){
            dimension1 = "S" ;
         }else if (percentages[1] == 50){
            dimension1 = "x";
         }else{ dimension1 = "N" ;
         }
         if (percentages[2] < 50){
            dimension2 = "T" ;
         }else if (percentages[2] == 50){
            dimension2 = "x";
         }else{ dimension2 = "F" ;
         }
         if (percentages[3] < 50){
            dimension3 = "J" ;
         }else if (percentages[3] == 50){
            dimension3 = "x";
         }else{ dimension3 = "P" ;
         }
         
         String personality = dimension0 + dimension1 + dimension2 + dimension3 ;
         return personality ;
         
         
         
         
         
         
      }
      
      //this method prints the letters to the output file. 
      public static void printFile(String Personality, PrintStream output, String names, int[] percentages ) {
         
         output.println(names + ":" + Arrays.toString(percentages) + " " + Personality) ;
         
         
      }
   }