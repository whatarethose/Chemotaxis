 Bacteria [] cell;
 int setupSize = 600;
 //declare bacteria variables here   
 void setup()   
 {   
   frameRate(30);
   cell = new Bacteria [30];  
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
 void draw()   
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
     direction = (int)(Math.random()*4);
   }  
   void show()
   {
     fill(0);//empty in center
     stroke(bacColor);//outline
     ellipse(bacX,bacY,bacSize,bacSize);//drawn
   }
   void move()
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
           bacX+=5;
           }
         }
         else if (direction ==1)
         {
           if(bacX<=0)
           {
             reset();
             bacX=0;
           }
           else
           {
           bacX-=5;
           }
         }
         else if(direction ==2)
         {
           if(bacY>=setupSize)
           {
             reset();
            bacY = setupSize;
          }
           else
           {
           bacY+=5;
           }  
         }
         else 
         {
           if(bacY<0)
           {
             reset();
             bacY=0;
           }
           else
          {
           bacY-=5;
           }  
         }
         start=start+(int)(Math.random()*3);
       }
  } 
  void reset(){
    start =0;
    direction =(int)(Math.random()*4);
  }  
}
