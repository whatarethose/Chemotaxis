 Bacteria cell;
 //declare bacteria variables here   
 void setup()   
 {     
 	cell = new Bacteria(100,100);
 	size(400,400);
 }	//initialize bacteria variables here      
 void draw()   
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
 	void show(){
 		ellipse(bacX,bacY,10,10);
 	}
 	void move(){
 		cell.bacX=cell.bacX+((int)(Math.random()*3)-1);//-1,0,1,
 		cell.bacY=cell.bacY+((int)(Math.random()*3)-1);//-1,0,1,
 	}
 }    