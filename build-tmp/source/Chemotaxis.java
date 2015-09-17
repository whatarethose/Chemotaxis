import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria [] cell;
 int setupSize = 400;
 //declare bacteria variables here   
 public void setup()   
 {   
   frameRate(30);
   cell = new Bacteria [20];  
   for(int x= 0;x<cell.length;x++)
   {//use local variables to shorten the length
     int xPos=(int)(Math.random()*setupSize);
     int yPos= (int)(Math.random()*setupSize);
     int big = ((int)(Math.random()*20))+5;
     cell[x]= new Bacteria(xPos,yPos,big,color((int)(Math.random()*255),
     (int)(Math.random()*255),
    (int)(Math.random()*255)));
   }
   size(setupSize,setupSize);
 }  //initialize bacteria variables here      
 public void draw()   
 {    
   background(0,0,0);
   for(int a = 0;a < cell.length;a++)
   {
     cell[a].show();
     cell[a].move();
   }
   //move and show the bacteria   
 }  
 class Bacteria    
 {     
   int bacX,bacY,bacColor,bacSize;
   Bacteria(int x,int y,int size,int myColor)
   {
     bacX=x;
     bacY=y;
     bacSize=size;
     bacColor = myColor;
   }  
   public void show()
   {
     fill(bacColor);//empty in center
     stroke(bacColor);//outline
     ellipse(bacX,bacY,bacSize,bacSize);//drawn
   }
   public void move()
   {
     int direction = (int)(Math.random()*4);//will only go in 1 direction at a time
     if (direction == 0)//right
     {
       if(bacX>mouseX)
       {//if the x is more right than mouse, more biased to left
         bacX=bacX+((int)(Math.random()*6)+1);///1,2,6
       }
       else
       {//if x is more left than mouse.biased right
         bacX=bacX+((int)(Math.random()*10)+1);///1,2,6,4,10
       }
     }
     else if(direction ==1)//left
     {
       if(bacX>mouseX)//if x is greater than mouseX,biased left
       {
         bacX=bacX-((int)(Math.random()*10)+1);//0,1,2,6,4
       }
       else//if x is less than mouse X,biased right
       {
         bacX=bacX-((int)(Math.random()*6)+1);//1,2,6
       }
     }
     else if(direction ==2)//up
     {
       if(bacY >mouseY)//if y is greater than mouse Y, biased down
       {
         bacY=bacY+((int)(Math.random()*6)+1);//1,2,6
       }
       else//if y is less than mouse Y, biased up
       {
         bacY=bacY+((int)(Math.random()*10)+1);//1,2,6,4,10
       }
     }
     else //down
     {
       if(bacY>mouseY)//if y is greater than mouseY, biased down
       {
         bacY=bacY-((int)(Math.random()*10)+1);//1,2,6,4,10
       }
       else//if y is less than mouse Y.biased up
       {
         bacY=bacY-((int)(Math.random()*6)+1);//1,2,3
       }
     }
   }
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
