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
   cell = new Bacteria [1];  
   for(int x= 0;x<cell.length;x++)
   {//use local variables to shorten the length
     int xPos=(int)(Math.random()*600);
     int yPos= (int)(Math.random()*600);
     int big = ((int)(Math.random()*20))+5;
     cell[x]= new Bacteria(xPos,yPos,big,color((int)(Math.random()*255),
     (int)(Math.random()*255),
    (int)(Math.random()*255)));
   }
   size(600,600);
 }  //initialize bacteria variables here      
 public void draw()   
 {    
   fill(0,0,0,100);
   rect(-1,-1,600,600);
   for(int a = 0;a < cell.length;a++)
   {
     cell[a].show();
     cell[a].move();
   }
   //move and show the bacteria   
 }  
 class Bacteria    
 {   
   int bacX,bacY,bacColor,bacSize,direction,start,end;
   Bacteria(int x,int y,int big,int myColor)
   {
     bacX=x;
     bacY=y;
     bacSize=big;
     bacColor = myColor;
     start =10;
     end =10;
     direction = (int)(Math.random()*10);
   }  
   public void show()
   {
     fill(0);//empty in center
     stroke(bacColor);//outline
     ellipse(bacX,bacY,bacSize,bacSize);//drawn
   }
   public void move()
   {
   		if(start >= end)
   		{
   			reset();
   		}
   		else
   		{
   			if(direction == 0)
   			{ 
   				if(bacX>=setupSize)
   				{
   					reset();
   					bacX = setupSize;
   				}
   				else 
   				{
   				bacX= bacX+5;
   				}
   			}
   			else if (direction >=1 && direction <=4)
   			{
   				if(bacX<=setupSize)
   				{
   					reset();
   					//bacX=0;
   				}
   				else
   				{
   				bacX=bacX-5;
   				}
   			}
   			else if(direction ==5)
   			{
   				if(bacY>=setupSize)
   				{
   					reset();
   					bacY = setupSize;
   				}
   				else
   				{
   				bacY=bacY+5;
   				}	
   			}
   			else 
   			{
   				if(bacY<setupSize)
   				{
   					reset();
   					//bacY=0;
   				}
   				else
   				{
   				bacY=bacY-5;
   				}	
   			}
   			start++;
   			System.out.print(direction);
   		}
	} 
	public void reset(){
		start =0;
		direction =(int)(Math.random()*10);
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
