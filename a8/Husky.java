//CSE 142
//Professor: stuart Reges
//Soham Ghose
import java.awt.*;

// Critter class extension for a critter called a 'Bear' 
public class Husky extends Critter {
    int count;
    
 // constructor for this class
    public Husky (){
        count = 0;
    }
    
    // returns the color of the critter   
    public Color getColor(){
        return Color.YELLOW ;
    }
    
    //returns the string value of the critter
    public String toString(){
        
        return "H" ;
    }
    
    // returns the move made by the critter
    public Action getMove(CritterInfo info) {
        count++ ;
        if (count == 99){count = 0; }
       
            if (info.getFront() == Neighbor.OTHER) {
                return Action.INFECT;
            } else if(info.getFront() == Neighbor.WALL || info.getFront() == Neighbor.SAME) {
                if(count < 50){
                return Action.RIGHT;}
                else{ return Action.LEFT; 
                }
            } else {
                return Action.HOP;
            }}
                        }          
              
    
