// Matt Hsieh
// 12/6/16
// CSE142
// TA Garrett Deardorff
// Assignment #9
//
// This class creates a Husky critter

import java.awt.*;

public class DatBoi extends Critter {
   
   private int count;
   private int direction;
   
   //this method takes in CritterInfo from the critter main class and returns an action. 
   public Action getMove(CritterInfo info) {
      count++;
      
      if (info.getDirection() == Direction.EAST ||
          info.getDirection() == Direction.NORTH) {
         direction = 0;
      } else {
         direction = 1;
      }
      
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.leftThreat() || info.rightThreat()) {
         return Action.HOP;
      } else if (info.getRight() == Neighbor.OTHER) {
         return Action.RIGHT;
      } else if (info.getLeft() == Neighbor.OTHER) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.WALL) {
         if (count % 3 == 0) {
            return Action.RIGHT;
         } else {
            return Action.LEFT;
         }      
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
   }

   //this method returns a color for the husky critter.
   public Color getColor() {
      if (count % 6 < 3) {
         return Color.RED;
      } else {
         return Color.GREEN;
      }      
   }

   //this method returns the string value for this critter.
   public String toString() {
      if (direction == 0) {
         return "( •_•)";
      } else {
         return "(•_• )";
      }  
   }
}