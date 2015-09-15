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

 Bacteria cell;
 //declare bacteria variables here   
 public void setup()   
 {     
 	cell = new Bacteria(100,100);
 	size(400,400);
 }	//initialize bacteria variables here      
 public void draw()   
 {    
 	background(255);
 	fill(255);	
 	cell.show();
 	cell.move();
 	//move and show the bacteria   
 }  
 class Bacteria    
 {     
 	int bacX,bacY;
 	Bacteria(int x,int y){
 		bacX=x;
 		bacY=y;
 	}	
 	public void show(){
 		ellipse(bacX,bacY,10,10);
 	}
 	public void move(){
 		cell.bacX=cell.bacX+((int)(Math.random()*3)-1);//-1,0,1,
 		cell.bacY=cell.bacY+((int)(Math.random()*3)-1);//-1,0,1,
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
