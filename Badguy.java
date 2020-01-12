
public class Badguy extends Character {

	boolean moveRight;
	boolean moveLeft;
	boolean isVisible;
	
	public Badguy(int x,int y,int s) {
		super(x,y,s);
	
		moveLeft=false;
		moveRight=true;
		isVisible=true;
	
	}
	
	
	public boolean isColliding(Character other) {
		return bbox().isColliding(other.bbox());
	
	/*
	 * Badguy b; public BBox bbox() { return new BBox(x,x+b.x,y,y+b.y); }
	 * 
	 * public boolean isColliding(Character other) { return
	 * bbox().isColliding(other.bbox()); }
	 */
}
}

