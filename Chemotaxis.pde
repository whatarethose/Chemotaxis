Bacteria [] cell;
 int setupSize = 600;
 player user = new player((setupSize/2),(setupSize/2),10);
 //declare bacteria variables here   
 void setup()   
 { 
   size(600,600);
   frameRate(30);
   cell = new Bacteria [35];  
   for(int x= 0;x<cell.length;x++)
   {//use local variables to shorten the length
     int xPos=(int)(Math.random()*600);
     int yPos= (int)(Math.random()*600);
     int big = ((int)(Math.random()*20))+5;
     cell[x]= new Bacteria(xPos,yPos,big,color((int)(Math.random()*255),
     (int)(Math.random()*255),
    (int)(Math.random()*255)));
   }
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
   user.show();
   user.move();
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
     start =10;//time to begin
     end =10;//time to end
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
       if(start >= end)//if the start reaches the end then restart
       {
         reset();
       }
       else
       {
         if(direction == 0)//if it equals 0 go right
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
         else if (direction ==1)//if it equals 1 go left
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
         else if(direction ==2)//if it equals 2 then go down
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
         else // if it equals 3 then goes up
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
  void reset(){//reset the time and direction
    start =0;
    direction =(int)(Math.random()*4);
  }  
}
class player
{
 boolean alive;
 int myX,myY,mySide,timer,best;
 player(int x, int y,int side)
 {
   myX=x;
   myY=y;
   mySide= side;
   alive = true;
   timer =0;
   best = 0;
 }
 void show()
 {
   if(timer > best)
   {
     best= timer;
   }
   timer+=1;
   fill(255);
   text("SCORE :"+timer,500,10);
   text("BEST :"+best,400,10);
   if(get(myX,myY) != color(0,0,0))
   {
    alive = false;
   }
   if(alive == true)
   {
     timer +=1;
   }
   else
   {
     timer=0;
     //myX= setupSize/2;
     //myY= setupSize/2;
   }
   stroke(255,0,0);
   fill(255,0,0);
   rect(myX,myY,10,10);
 }
 void move()
 {
   if(keyCode == UP && myY>=mySide+5)
   {
     if(myY <=0)
     {
       myY-=0;
     }
     else
     {
     myY-=6;
     }
   }
   else if(keyCode == DOWN && myY<=setupSize-mySide-10)
   {
     if(myY >=setupSize)
     {
       myY+=0;
     }
     else
     {
     myY+=6;
     }
   }
   else if(keyCode == LEFT && myX >=mySide)
   {
     if(myX<= 0)
     {
       myX-=0;
     }
     else 
     {
     myX-=6;
     }
   }
   else if(keyCode == RIGHT && myX <= setupSize-mySide-10)
   {
     if(myX>=setupSize)
     {
       myX+=0;
     }
     else
     {
     myX+=6;
     }
   }
   else
   {
     myX+=0;
     myY+=0;
   }
 }
}
