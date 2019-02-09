import java.io.* ;
import java.util.* ; 

public class GrammarSolver{
   SortedMap<String, String[]> map ; 
   public GrammarSolver(List<String> grammar){
      if(grammar.size() == 0){
         throw new IllegalArgumentException()  ; 
      }
      map = new TreeMap<String, String[]>() ; 
      for(String line : grammar){
         String[] parts = line.split("::=");
         if(map.containsKey(parts[0])){
            throw new IllegalArgumentException() ; 
         }
         else{
            map.put(parts[0] , parts[1].split("\\|")) ;  
         }
      }
   }
   
   public boolean grammarContains(String symbol){
      if(map.containsKey(symbol)){
         return true ; 
      } 
      return false ; 
   }
   
   //generates a random selection for a certain nonterminal. 
   //implement random scene 
   private String generate(String symbol){
      //String phrase = "" ; 
      String result = "";
      if(!map.containsKey(symbol)){
         //phrase += symbol ; 
         result += symbol;      
      }
      else{
         
         String[] rules = map.get(symbol)[0].split("\\s+") ; 
         for(String rule : rules){
            result += generate(rule) + " " ; 
         }
      }  return result; 
   }
   
   public String[] generate(String symbol , int times){
      String[] result = new String[times] ; 
      for(int i = 0 ; i < times ; i++){
         result[i] = generate(symbol) ; 
      }
      return result ;  
   }
   
   public String getSymbols(){
      int i = 0 ; 
      String[] options = new String[map.keySet().size()] ; 
         for(String key : map.keySet()){
            options[i] = key ; 
            i++ ; 
         } 
      return Arrays.toString(options);   
   }
}