
import java.util.* ;

public class AssassinManager2{
   private static int total;
   public static AssassinNode killRing ; 
   public static AssassinNode graveyard ;  
   public AssassinManager2(List<String> names){
      total = names.size(); 
      if(names.size() == 0 ){
         throw new IllegalArgumentException() ; 
      }
      killRing = new AssassinNode(names.get(0)) ; 
      AssassinNode current = killRing ; 
      for(int i = 1 ; i < names.size() ; i++){
          current.next = new AssassinNode(names.get(i)) ;  
          current = current.next ;   
      } 
      current.next = killRing;   
   }
   
   public static void printKillRing(){
      AssassinNode current = killRing ; 
      System.out.println("    " + current.name + "  is stalking " + current.next.name); 
      current = current.next ; 
      while(current != killRing) {
         System.out.println("    " + current.name + "  is stalking " + current.next.name); 
         current = current.next;
      }
   }
   
   public static void printGraveyard(){
      AssassinNode current = graveyard ;
         while (current != null) {
            System.out.println("    " + current.name + " was killed by " + current.killer);
            current = current.next;
         }
   } 

   
   public static boolean killRingContains(String name){
      AssassinNode current = killRing ; 
      if(current.name.toLowerCase().equals(name.toLowerCase())){  //make ignore case comparison method
            return true;    
         } 
      current = current.next ; 
      while(current != killRing) {
         if(current.name.toLowerCase().equals(name.toLowerCase())){
            return true;    
         } 
         current = current.next ;
      }
      return false;
   }
   
   public static boolean gameOver(){
      return winner() != null ;   
   }
   
   public static String winner(){
       if(killRing.next.name.equals(killRing.name)){
         return killRing.name ; 
       }
       return null ; 
   }
   
   public static void kill(String name){
      if(!(killRingContains(name))){
         throw new IllegalArgumentException(); 
      }
      if(gameOver()){
         throw new IllegalStateException();
      }
      AssassinNode current = killRing ; 
      int count = 0;
      while (current != null && current.next != null /*&& count < total && count >= 0*/){
         if(current.next.name.toLowerCase().equals(name.toLowerCase())){
            AssassinNode temp = graveyard;
            graveyard = current.next;
            current.next.killer = current.name ; 
            current.next = current.next.next;
            graveyard.next = temp;
            killRing = current;
            //total--;
            //count = -1;
            break;
         }
         current = current.next;
         //count++;
      }
   }
         
         
 
   public static boolean graveyardContains(String name){
       AssassinNode current = graveyard ; 
      while(current != null){
         if(current.name.toLowerCase().equals(name.toLowerCase())){
         return true;    
         } 
         current = current.next ;
      }
      return false;
   }
}