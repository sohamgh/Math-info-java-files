//Soham Ghose (1663396)
//CSE 142 HW4
//This class manages the state of a game of evil hangman
 
import java.util.* ; 
import java.io.* ;

//The computer is going to delay picking a word until it is forced to.  
//As a result, at any given point in time there will be a set of words that are currently being used by the computer  
//Each of those words will have the same pattern to be displayed to the user.
public class HangmanManager{
   //field that stores the set of words being considered by the game
   private Set<String> currentSet ; 
   //field stores the letters guessed by the user 
   private Set<Character> guessed ;
   //field stores the maximum number of incorrect guesses user is allowed to make.   
   private int maxWrongGuesses ; 
   //field stores the word pattern defining the word set being considered. 
   private String currentPattern ;  
   //Constructor 
   //Throws IllegalArgumentException if the specified length is less than 1 
   //or if the maximum number of guesses is less than 0 
   public HangmanManager(Collection<String> dictionary, int length, int max){
      if(length < 1 || max < 0 ){
         throw new IllegalArgumentException() ; 
      }
      guessed = new TreeSet<Character>() ;
      currentPattern = "" ; 
      for(int i = 0 ; i < length ; i++){
         currentPattern += "-" ; 
      }
      currentSet = new TreeSet<String>() ;
      for(String word : dictionary){
         if(word.length() == length){
            currentSet.add(word) ; 
         }
      }  
      maxWrongGuesses = max ;        
   }
   
   //returns the set of words being considered by the game
   public Set<String> words(){
      return currentSet ; 
   }
   
   //returns the number of incorrect guesses the user has left 
   public int guessesLeft(){
      return maxWrongGuesses ; 
   }
   
   //returns a set of characters that the user has already guesses
   public Set<Character> guesses(){
      return guessed ;   
   }
   
   //returns the patters that defines the set of words being considered
   public String pattern(){
      return currentPattern ; 
   }
   
   //takes in a character as the users guess
   //throws an IllegalStateException if the number of guesses left is not at least 1 
   //or if the set of words is empty.
   //throws an IllegalArgumentException if the set of words is nonempty 
   //and the character being guessed was guessed previously.
   //returns the number of times that character appears in every word of the next chosen set. 
   public int record(char guess){
      if(guesses().contains(guess)){
         throw new IllegalArgumentException() ; 
      }
      if(guessesLeft() < 1 || currentSet.size() <= 0){
         throw new IllegalStateException() ; 
      }
      guessed.add(guess) ;
      Map<String, Set<String>> map = new TreeMap<String, Set<String>>() ; 
      for(String word : currentSet){
         String pattern = getPattern(word, guess) ;                 
         if(!map.containsKey(pattern)){
            Set<String> wordList = new TreeSet<String>() ; 
            wordList.add(word) ;
            map.put(pattern , wordList ) ;
         }
         else{ 
            map.get(pattern).add(word) ;     
         }    
      }
      currentSet = getBiggest(map);
      return guessCount(guess) ;
   }
   
   //takes in a word and a guessed character. 
   //returns the pattern of the word after revealing the guessed letter. 
   private String getPattern(String word, char guess){
      String pattern = "" ; 
      for(int i = 0 ; i < word.length() ; i++){
         if(word.charAt(i) == guess){
            pattern += guess ;     
         }
         else{
           pattern += currentPattern.charAt(i) ; 
         }
      }
      return pattern ; 
   }
   
   //takes in a map from a string to a set of strings 
   //returns the largest Set among the set of strings. 
   private Set<String> getBiggest(Map<String, Set<String>> map){
      int max = 0 ;
      Set<String> biggest = null;
      for(String key : map.keySet()){  
         if(map.get(key).size() > max){
            biggest = map.get(key) ; 
            max = map.get(key).size() ; 
            currentPattern = key ; 
         }
      }
      return biggest ; 
   }
   
   //takes in the character guessed by the user 
   //returns the number of times the guessed letter 
   //apears in every word of the chosen set. 
   private int guessCount(char guess){
      int count = 0 ; 
      String word = currentSet.iterator().next() ; 
      for(int i = 0 ; i < word.length() ; i++){
         if(word.charAt(i) == guess){
            count++ ; 
         }
      }
      if(count == 0 ) {
         maxWrongGuesses-- ; 
      }
      return count ;    
   } 
}