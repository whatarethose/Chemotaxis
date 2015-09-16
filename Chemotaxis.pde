 Bacteria [] cell;
 int setupSize = 400;
 //declare bacteria variables here   
 void setup()   
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
 void draw()   
 {    
 	background(0,0,0,50);
 	for(int a = 0;a < cell.length;a++)
 	{
	 	cell[a].show();
	 	cell[a].move();
 	}
 	//move and show the bacteria   
 }  
  color randomColor()
 	{
  	return color((int)(Math.random()*255),(int)(Math.random()*255),
    (int)(Math.random()*255));//random colors
  	}
 class Bacteria    
 {     
 	int bacX,bacY,bacColor,bacSize;
 	Bacteria(int x,int y,int size)
 	{
 		bacX=x;
 		bacY=y;
 		bacSize=size;
 	}	
 	void show()
 	{
 		fill(0);//empty in center
 		ellipse(bacX,bacY,bacSize,bacSize);
 	}
 	void move()
 	{
 		bacX=bacX+((int)(Math.random()*3)-1);//-1,0,1,
 		bacY=bacY+((int)(Math.random()*3)-1);//-1,0,1,
 	}
 }    