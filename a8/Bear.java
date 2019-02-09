//CSE 142
//Professor: stuart Reges
//Soham Ghose 

import java.awt.*;
// Critter class extension for a critter called a 'Bear' 
public class Bear extends Critter {
   private boolean polar;
    private int count;
    
    //constructor for this class
    public Bear (boolean polar){
        count = 0 ;
        if ( polar == true){
            polar = true ;
        }else{
            polar = false;
        } 
    }
    
    //returns the desired color for the bear 
    public Color getColor(){
        if (polar == true){
            return Color.WHITE ;
        }else{
            return Color.BLACK ;
        }
    }
    
    //returns the string value of the critter
    public String toString(){
        if(count % 2 == 0){
            return "/" ;
        }else{
            return "\\" ;
        }}
        
        //returns the move that the critter will make
        public Action getMove(CritterInfo info) {
            count++ ;
            if (info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            } else if(info.getFront() == Neighbor.EMPTY){
                return Action.HOP;
            }else{return Action.LEFT;
            }
        }
    }