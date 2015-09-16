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
 	cell = new Bacteria [20];	
 	for(int x= 0;x<cell.length;x++)
 	{
 		int xPos=(int)(Math.random()*setupSize);
 		int yPos= (int)(Math.random()*setupSize);
 		int big = ((int)(Math.random()*20))+5;
 		cell[x]= new Bacteria(xPos,yPos,big);
 	}
 	size(setupSize,setupSize);
 }	//initialize bacteria variables here      
 public void draw()   
 {    
 	background(0,0,0,50);
 	for(int a = 0;a < cell.length;a++)
 	{
	 	cell[a].show();
	 	cell[a].move();
 	}
 	//move and show the bacteria   
 }  
  public int randomColor()
 	{
  	return color((int)(Math.random()*255),(int)(Math.random()*255),
    (int)(Math.random()*255));//random colors
  	}
 class Bacteria    
 {     
 	int bacX,bacY,bacColor,bacSize;
 	Bacteria(int x,int y,int size)
 	{
 		stroke(randomColor());
 		bacX=x;
 		bacY=y;
 		bacSize=size;
 	}	
 	public void show()
 	{
 		fill(0);//empty in center
 		ellipse(bacX,bacY,bacSize,bacSize);
 	}
 	public void move()
 	{
 		bacX=bacX+((int)(Math.random()*3)-1);//-1,0,1,
 		bacY=bacY+((int)(Math.random()*3)-1);//-1,0,1,
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
