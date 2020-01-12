import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;


public class Board  extends JPanel implements Runnable, MouseListener
{
boolean ingame = true;
private Dimension d;
int BOARD_WIDTH=500;
int BOARD_HEIGHT=500;
int x = 0;
BufferedImage img;
String message = "";
 private Thread animator;
 Player p;
 Badguy[] a=new Badguy[15];
 
    public Board()
    {
          addKeyListener(new TAdapter());
         addMouseListener(this);
        setFocusable(true);
        d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
        p=new Player(BOARD_WIDTH/2,BOARD_HEIGHT-60,5);
        
        int bx=10;
        int by=10;
        
        for(int i=0;i<a.length;i++)
        {
        	a[i]=new Badguy(bx,by,10);
        	bx+=40;
        	if(i==4||i==9) {
        		bx=10;
        		by+=40;
        	}
        }
        
        setBackground(Color.black);
       
           /*         
             try {
                img = ImageIO.read(this.getClass().getResource("mount.jpg"));
            } catch (IOException e) {
                 System.out.println("Image could not be read");
            // System.exit(1);
            }
            */
            if (animator == null || !ingame) {
            animator = new Thread(this);
            animator.start();
            }
                    
  
        setDoubleBuffered(true);
    }
    
    public void paint(Graphics g)
{
super.paint(g);

g.setColor(Color.white);
g.fillRect(0, 0, d.width, d.height);
//g.fillOval(x,y,r,r);


//jucatorul
g.setColor(Color.red);

g.fillRect(p.x, p.y, 20, 20);

if(p.moveRight==true)
	p.x+=p.speed;
if(p.moveLeft==true)
	p.x-=p.speed;

ArrayList bulletz=p.getBullets();
for(int i=0;i<bulletz.size();i++) {
	Bullet b=(Bullet) bulletz.get(i);
	if(b.isVisible==true) {
		b.update();
	}else {
		bulletz.remove(i);
	}
}

ArrayList bullets=p.getBullets();
for(int i=0;i<bullets.size();i++) {
	Bullet b=(Bullet) bullets.get(i);
	if(b.isVisible) {
	g.setColor(Color.BLUE);
	g.fillRect(b.getX(),b.getY(),5,10);
	for(int j=0;j<a.length;j++) {
	if(b.isColliding(a[j])) {
		b.isVisible=false;
		a[i].isVisible=false;
		}
	
	}}
}

moveBadguys();
for(int i=0;i<a.length;i++) {
	if(a[i].isVisible) {
	g.fillRect(a[i].x,a[i].y, 30,30);
}}


        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = this.getFontMetrics(small);
        g.setColor(Color.black);
       g.setFont(small);
        g.drawString(message, 10, d.height-60);

    if (ingame) {
        
    
        
       
        
    // g.drawImage(img,0,0,200,200 ,null);
     
    
   
    }
Toolkit.getDefaultToolkit().sync();
g.dispose();
}
    
    public void moveBadguys() {
    	for(int i=0;i<a.length;i++) {
    		if(a[i].moveLeft==true) {
    		 	a[i].x-=2;//a[i].speed;
    		}
            if(a[i].moveRight==true) {
             	a[i].x+=2;//a[i].speed;
    		}

    	}
    	
    	
    	//a[i].y+=a[i].speed;
    	
    	for(int i=0;i<a.length;i++) {
    	if(a[i].x>=BOARD_WIDTH) {
    		for(int j=0;j<a.length;j++) { 
    		a[j].moveLeft=true;
    		a[j].moveRight=false;
    		a[j].y+=5;
    		
    	}
    	}
    	if(a[i].x<0) {
    		for(int j=0;j<a.length;j++) {
        		a[j].moveRight=true;
    		    a[j].moveLeft=false;
                a[j].y+=5;    	
    		}
    	
    }
    	}
    	}
    
    
    
private class TAdapter extends KeyAdapter {

public void keyReleased(KeyEvent e) {
     int key = e.getKeyCode();
     p.moveRight=false;
    p.moveLeft=false;
}

public void keyPressed(KeyEvent e) {
//System.out.println( e.getKeyCode());
   // message = "Key Pressed: " + e.getKeyCode();
    int key = e.getKeyCode();
        if(key==39){
          p.moveRight=true;
        }
        
        if(key==37){
            p.moveLeft=true;
          }
        if(key==32) {
        	p.shoot();
        }
       

}

}




public void mousePressed(MouseEvent e) {
    int x = e.getX();
     int y = e.getY();

}

public void mouseReleased(MouseEvent e) {

}

public void mouseEntered(MouseEvent e) {

}

public void mouseExited(MouseEvent e) {

}

public void mouseClicked(MouseEvent e) {

}

public void run() {

long beforeTime, timeDiff, sleep;

beforeTime = System.currentTimeMillis();
 int animationDelay = 5;
 long time = 
            System.currentTimeMillis();
    while (true) {//infinite loop
     // spriteManager.update();
      repaint();
      try {
        time += animationDelay;
        Thread.sleep(Math.max(0,time - 
          System.currentTimeMillis()));
      }catch (InterruptedException e) {
        System.out.println(e);
      }//end catch
    }//end while loop

    


}//end of run

}//end of class