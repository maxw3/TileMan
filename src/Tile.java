import java.awt.Graphics;
import java.awt.Point;

public class Tile {
	
	boolean isFloor = true;
	int x,y;
	Point pos;
	
	Tile(int x, int y){
		this.x = x;
		this.y = y;
		pos = new Point(this.x,this.y);
	}
	
	void place(Graphics g){
		g.fillRect(x, y, 32, 32);
	}
	
	public Point getPos() {
		return pos;
	}
}
