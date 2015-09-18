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
 int setupSize = 600;
 //declare bacteria variables here   
 public void setup()   
 {   
   frameRate(30);
   cell = new Bacteria [40];  
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
   fill(0,0,0,100);
   rect(-1,-1,setupSize,setupSize);
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
    	if(mouseX>bacX) 
    {
      bacX = bacX +  (int)(Math.random()*10)-1;
    }

    if(mouseX<bacX) 
    {
      bacX = bacX +  (int)(Math.random()*10)-9;
    }

    if(mouseY>bacY) 
    {
      bacY = bacY +  (int)(Math.random()*10)-1;
    }

    if(mouseY<bacY) 
    {
      bacY = bacY +  (int)(Math.random()*10)-9;
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
