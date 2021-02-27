import java.awt.Graphics;

public class Room {
	
	public int x;
	public int y;
	public int w;
	public int h;
	
	Room(){
		
	}
	
	Room(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void paint(Graphics g){
		g.fillRect(x, y, w, h);
	}
}
