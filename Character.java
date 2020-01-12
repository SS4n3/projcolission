
public class Character {

	int x;
	int y;
	int speed;
	
	public Character() {
		
	}
	
	public Character(int x,int y,int speed)
	{
		this.x=x;
		this.y=y;
		this.speed=speed;
		
	}
	
	public BBox bbox() {
		return new BBox(x,x+speed,y,y+speed);
	}
	
	public boolean isColliding(Character other) {
		return bbox().isColliding(other.bbox());
	}
	
}
