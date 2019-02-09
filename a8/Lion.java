//CSE 142
//Professor: stuart Reges
//Soham Ghose

import java.awt.*;
import java.util.*;

// Critter class extension for a critter called a 'Bear' 
public class Lion extends Critter {
    private Random lionColor;
    private Color fixColor;
    private int count;
    
    //constructor for this class
    public Lion (){
        lionColor = new Random();
        count = 0;
    }
    
    //reurns the color of the critter
    public Color getColor(){
        if(count == 0){
            int random = lionColor.nextInt(3);
            if (random == 0){
                fixColor = Color.GREEN;
                return Color.GREEN ;
            }else if(random == 1){
                fixColor = Color.BLUE;
                return Color.BLUE ;
            }else{
                fixColor = Color.RED;
                return Color.RED;  
            }
        }else{
            return fixColor;
        }
    }
    
    //returns the string value of the critter
    public String toString(){
        return "L" ;
    }
    
    //returns the move made by the critter
    public Action getMove(CritterInfo info) {
        if(count == 2 ){
            count = 0;
        }else{
            count++ ;
        }
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
            return Action.LEFT;
        }else if(info.getFront() == Neighbor.SAME){
            return Action.RIGHT;
        }
        else{return Action.HOP;   
        }
    }
}
