//Soham Ghose 
//CSE 142
//Charles Mihran
// 10/18/16
import java.awt.*;

public class CafeWall {

   public static final int MORTAR =2;
   
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(650,400);
      p.setBackground(Color.GRAY);
      Graphics g = p.getGraphics();
      makeRow(g,0,0,20,4);
      makeRow(g,50,70,30,5);
      makePattern(g,425,180, 20, 5,10);
      makePattern(g,400,20,35,2,35);
      makePattern(g,250,200,25,3,10);
      makePattern(g,10,150,25,4,0); 
   }
   //This method creates rows of varying length, size and location. 
   public static void makeRow(Graphics g, int x, int y, int size, int pair) {
      for(int i = 0; i < pair; i++){
         
         g.setColor(Color.BLACK);
         g.fillRect(x+i*2*size,y,size,size);
         g.setColor(Color.WHITE);
         g.fillRect(x+size+i*2*size,y,size,size);
         g.setColor(Color.BLUE);
         g.drawLine(x+i*2*size,y, x+size+i*2*size, y+size);
         g.drawLine(x+i*2*size,y+size, x+size+i*2*size, y);
      }
   }
   // This method creates grids of varying size and location. 
   public static void makePattern(Graphics g, int x, int y, int size, int pair, int offset ) {
      for( int j=0; j<pair; j++) {
         makeRow(g,x,y+2*j*(MORTAR+size),size,pair);  
      }
      
      for( int j=0; j<pair; j++) {
         makeRow(g,x+offset,y+2*j*(size+MORTAR)+size+MORTAR,size,pair);  
      }   
   }
}