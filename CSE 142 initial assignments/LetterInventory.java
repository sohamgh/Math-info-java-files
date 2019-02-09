// Soham Ghose (1663396)
// CSE 143 HW1
// This object makes an inventory of the counts of each letter available in a word or phrase.
import java.util.* ;
public class LetterInventory {
   //class constant for the number of letters in the alphabet. 
	public static final int NUM_TOTAL_ALPHABETS = 26;
   //field that stores the number of each letter in the word/phrase
	private int[] countArray ;
   //field stores the number of total letters in the letter inventory
	private int size ;
   // boolean that indicates whether the letter inventory is empty. 
	private boolean empty ;
   //constructor
   //Takes in phrase/word whose letters we want to put in the letter Inventory, as argument. 
   //creates an array that stores the number of each letter in the word/phrase.
	public LetterInventory(String data) {
		countArray = new int[NUM_TOTAL_ALPHABETS];
		size = 0 ;
		empty = false ;
		String dataLower = data.toLowerCase() ;
		for(int i = 0; i < data.length(); i++) {
			if(isLetter(data.charAt(i))) {
				countArray[letterIndex(data.charAt(i))] += 1 ;
				size++ ; //increment size everytime new letter is counted. 
			}
		}
		if(size == 0) {
			empty = true;
		}
	}
	
   //takes in a letter as argument
   //throws illegalArgumentException if argument is not a letter
   //returns the number of times that letter appears in the word/phrase. 
	public int get(char letter) {
		if(!(isLetter(letter))) {
			throw new IllegalArgumentException() ;
		}
		return countArray[letterIndex(letter)];
	}
   
   //takes in a letter and a positive integer value as arguments 
   //throws IllegalArgumentException if the arguement is not a letter
   //or if the integer is not positive. 
   //sets the number of the input letter available in the inventory to the input value. 
	public void set(char letter, int value) {
		if(!(isLetter(letter))|| (value < 0) ) {
			throw new IllegalArgumentException() ;
		}
		size = size - countArray[letterIndex(letter)] + value ;
		countArray[letterIndex(letter)] =  value;
	}
	
   //returns the size of the letter inventory
   //this is equal to the number of lettters in the word/phrase
	public int size() {
		return size ;
	}
	
   //returns true if the letter inventory is empty
   //returns false if it is not empty. 
	public boolean isEmpty() {
		return empty ;
	}
	
   //returns a string containing all the letters in the 
   //letter inventory (including duplicates) in alphabetic order. 
	public String toString() {
		String inventory =  "[" ;
		for(int i = 0 ; i < NUM_TOTAL_ALPHABETS; i++) {
			int letterCount = countArray[i];
			for(int j = 0 ; j < letterCount ; j++) {
				inventory += (char)('a' + i ) + "" ;
			}
		}
		inventory += "]" ;
		return inventory ;
	}
	
   //takes in another letter inventory as argument 
   //adds the letters of one letter inventory to the other and stores the counts of each letter 
   //in a new letter inventory.
   //returns the new letter inventory.
	public LetterInventory add(LetterInventory other) {
		LetterInventory Added = new LetterInventory("");
		for(int i = 0 ; i < NUM_TOTAL_ALPHABETS ; i++) {
			Added.countArray[i] = this.countArray[i] + other.countArray[i] ;
		}
		Added.size = this.size + other.size;
		return Added ;
	}
	
   //takes in another letter inventory as argument 
   //Subtracts the letters of the letter inventory from the other and stores the counts of each letter 
   //in a new letter inventory.
   //returns null if the other letter inventory has letters that the are not there in the letter inventory. 
   //returns the new letter inventory.
	public LetterInventory subtract(LetterInventory other) {
		LetterInventory Subtracted = new LetterInventory("");
		for (int i = 0; i < NUM_TOTAL_ALPHABETS; i++) {
			if(this.countArray[i] < other.countArray[i]) {
				return null;
			}
			else {
				Subtracted.countArray[i] = this.countArray[i] - other.countArray[i];
				Subtracted.size = this.size - other.size ;
			}
		}
		return Subtracted;
	}
	
   //accepts a character as an argument 
   //returns the characacters index in the Alphabet.
	private static int letterIndex(char letter) {
		return letter -'a';
	}
   
   //accepts a character as an argument 
   //returns true if the character is a letter
   //otherwise returns false
	private static boolean isLetter(char letter){
		if((letter >= 'a') && (letter <= 'a' + 26 )){
			return true ;
		}
		return false;
	}
}