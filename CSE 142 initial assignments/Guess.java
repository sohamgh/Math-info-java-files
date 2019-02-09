//Soham Ghose 
//TA: Charles Mihran 
// CSE 142 
// 1st november 2016
// homework 5
import java.util.*;
// This program simulates a guessing game. 
public class Guess {
// creates a constant that changes the maximum value of the random number 
   public static final int CONS = 100; 
   public static void main(String[] args){
      intro();
            Scanner console = new Scanner(System.in);
      String yesorno = "Yes"; // priming the loop 
      int numGames = 0;
      int totalGuesses = 0;
      int bestGuess = 9999;
      while(yesorno.toUpperCase().startsWith("Y")){
         numGames++;
         System.out.println("I'm thinking of a number between 1 and " + CONS + "...");
         int numGuess = thinkNumber();
         bestGuess = Math.min(numGuess, bestGuess);
         totalGuesses = numGuess+ totalGuesses;
         System.out.print("Do you want to play again? ");
         yesorno = console.nextLine();
         System.out.println();
      }
      overall(numGames, totalGuesses, bestGuess);
      
      
   }
   
   // prints introduction
   public static void intro(){
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(CONS +" and will allow you to guess until");
      System.out.println("you get it.  For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   // this method draws a number at random as well as asks for the users guess
   public static int thinkNumber(){
      int compChoice = 1; // priming the loop
      int userChoice = 0; // priming the loop
      int numGuess = 0;
      int totalGuesses = 0;
      Random r = new Random();
      compChoice = r.nextInt(CONS);
      
      while (userChoice != compChoice) {
         Scanner console = new Scanner(System.in);
         System.out.print("Your guess? ");
         userChoice = console.nextInt();
         if (userChoice > compChoice){
            System.out.println("It's lower. ");
         }else if(userChoice < compChoice){
            System.out.println("It's higher. ");
         }
         numGuess = numGuess + 1 ;
      }
      if (numGuess==1){
         System.out.println("you got it right in " + numGuess + " guess ");
      }else{
         System.out.println("you got it right in " + numGuess + " guesses ");
      }
      return numGuess;
   }
   
   // method to print overall results 
   public static void overall(int numGames, int totalGuesses, int bestGuess) {
      System.out.println("Overall results:");
      System.out.println("    total games   = " + numGames);
      System.out.println("    total guesses = " + totalGuesses);
      System.out.println("    guesses/game  = " + round(totalGuesses * 1.0 /numGames ));
      System.out.println("    best game     = " + bestGuess);
   }
   
   //method to round off values to one decimal place. 
   public static double round(double number) {
      return (Math.round(number * 10.0)) / 10.0;
   }
}
