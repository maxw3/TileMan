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
		this.x = x * 25;
		this.y = y * 25;
		this.w = w * 25;
		this.h = h * 25;
		
		center = new Point(x + w/2, y + h/2);
		
	}
	
	public void paint(Graphics g){
		g.fillRect(x, y, w, h);
	}
}
