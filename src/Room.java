import java.awt.Graphics;
import java.awt.Point;

public class Room {
	
	public int x;
	public int y;
	public int w;
	public int h;
	
	public Point center;
	
	Room(){
		
	}
	
	Room(int x, int y, int w, int h){
		this.x = x * 32;
		this.y = y * 32;
		this.w = w * 32;
		this.h = h * 32;
		
		center = new Point(this.x + Math.round( this.w % 3 * 32), this.y + Math.round( this.h % 4 * 32));
		
	}
	
	public void paint(Graphics g){
		g.fillRect(x, y, w, h);
	}
}
