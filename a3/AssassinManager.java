//Soham Ghose 1663396
//Cse 143 HW 3
//This class uses AssassinNodes to manage a linked list of people in a kill ring
// and another of people killed.

import java.util.* ;
public class AssassinManager{
   // reference to first node in killRing
   public static AssassinNode killRing ;
   // reference to first node in graveyard
   public static AssassinNode graveyard ;
   //constructor
   //takes in a list of names
   //throws IllegalArgumentException if list is empty
   //constructs a linked list of assassin nodes for each name.
   public AssassinManager(List<String> names) {
      if(names.size() == 0 ) {
         throw new IllegalArgumentException() ;
      }
      killRing = new AssassinNode(names.get(0)) ;
      AssassinNode current = killRing ;
      for(int i = 1 ; i < names.size() ; i++) {
         current.next = new AssassinNode(names.get(i)) ;
         current = current.next ;
      }
      current.next = killRing;
   }
   
   //prints all the names in the killRing and who each person is stalking stalking
   public static void printKillRing() {
      AssassinNode current = killRing ;
      System.out.println("    " + current.name + "  is stalking " + current.next.name);
      current = current.next ;
      while(current != killRing) {
         System.out.println("    " + current.name + "  is stalking " + current.next.name);
         current = current.next;
      }
   }
   
   //prints all the names in the graveyard and who they were killed by
   //prints the name of the last person killed, first
   public static void printGraveyard() {
      AssassinNode current = graveyard ;
      while (current != null) {
         System.out.println("    " + current.name + " was killed by " + current.killer);
         current = current.next;
      }
   }
   
   //takes in a name
   //returns true if the name is in the killRing and false otherwise
   public static boolean killRingContains(String name) {
      AssassinNode current = killRing ;
      if(IsTarget(current.name, name)) {
         return true;
      }
      current = current.next ;
      while(current != killRing) {
         if(IsTarget(current.name , name)) {
            return true;
         }
         current = current.next ;
      }
      return false;
   }
   
   // returns true if there is only one person in the killRing
   public static boolean gameOver() {
      return winner() != null ;
   }
   
   // returns the last name left in the killring
   // returns null if more than one person is in the killRing
   public static String winner() {
      if(killRing.next.name.equals(killRing.name)) {
         return killRing.name ;
      }
      return null ;
   }
   
   //takes in a name
   //moves the name from killRing to the graveyard
   //throws IllegalArgument exception if the name is not in killRing
   //throws IllegalStateException if the game is over
   public static void kill(String name) {
      if(!(killRingContains(name))) { 
         throw new IllegalArgumentException();
      }
      if(gameOver()) {
         throw new IllegalStateException();
      }
      AssassinNode current = killRing ;
      while (current != null && current.next != null) {
         if(IsTarget(current.next.name , name)) {
            AssassinNode temp = graveyard;
            graveyard = current.next;
            current.next.killer = current.name ;
            current.next = current.next.next;
            graveyard.next = temp;
            killRing = current;
            break;
         }
         current = current.next;
      }
   }
   
   //takes in a name
   //returns true if the person has been killed
   //returns false otherwise
   public static boolean graveyardContains(String name) {
      AssassinNode current = graveyard ;
      while(current != null) {
         if(IsTarget(current.name , name)) {
            return true;
         }
         current = current.next ;
      }
      return false;
   }
   
   //takes in two names
   //checks if they are the same, ignoring case.
   private static boolean IsTarget(String name1, String name2) {
      if(name1.toLowerCase().equals(name2.toLowerCase())) {
         return true;
      }
      return false;
   }
}