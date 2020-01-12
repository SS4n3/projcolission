import java.util.ArrayList;

public class Player extends Character {

	boolean moveRight;
	boolean moveLeft;
   private ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	
  
 
	public Player(int x,int y,int s) {
		super(x,y,s);
	
		moveLeft=false;
		moveRight=false;
	
	}
	  public void shoot() {
		    Bullet b=new Bullet(x+5,y-5);
		    bullets.add(b);	
		    }
   
	public ArrayList getBullets() {
    	return bullets;
    }

}

