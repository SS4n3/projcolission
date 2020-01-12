
public class Bullet extends Character{
	int x,y,speedx;
	boolean isVisible;

	public Bullet(int startx,int starty) {
		x=startx;
		y=starty;
		speedx=6;
		isVisible=true;
		
	}
	public void update() {
		y-=speedx/2;
		if(x>800) {
			isVisible=false;
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getSpeedx() {
		return speedx;
	}
	public void setSpeedx(int speedx) {
		this.speedx = speedx;
	}
	public boolean isisVisible() {
		return isVisible;
	}
	public void setisVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public boolean isColliding(Character other) {
		return bbox().isColliding(other.bbox());
	}
	
	
}
