
public class BBox {

		 private int minx, maxx, miny, maxy;

		public BBox(int minx, int maxx, int miny, int maxy) {
			super();
			this.minx = minx;
			this.maxx = maxx;
			this.miny = miny;
			this.maxy = maxy;
		}
		public boolean isColliding(BBox other) {
			return maxx >= other.minx && minx <= other.maxx 
					&& maxy >= other.miny && miny <= other.maxy;
		}
		
		
		
		
	}

