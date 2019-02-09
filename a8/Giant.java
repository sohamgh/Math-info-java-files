//CSE 142
//Professor: Stuart Reges
//Soham Ghose
import java.awt.*;
import java.util.*;

//  Critter class extension for a critter called a 'Bear' 
public class Giant extends Critter {
    private int count;
    
   // costructor for this class
    public Giant (){
        count = 0 ;
    }
    
    //returns the color of the critter
    public Color getColor(){
        return Color.GRAY;
    }
    
    //returns the string value of the critter 
    public String toString(){
        if (count >= 0 && count <= 6) {
            return "fee" ;
        } else if(count > 6 && count <= 12){
            return "fie";
        }else if(count > 12 && count <= 18){
            return "foe";
        }else {
            return "fum";
        }
    }
    
    //returns the move made by the critter
    public Action getMove(CritterInfo info) {
        if(count == 23 ){
            count = 0;
        }else{
            count++ ;
        }
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        }else{return Action.RIGHT;
        }
    }
}

