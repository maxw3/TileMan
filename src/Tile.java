import java.awt.Graphics;

public class Tile {
	
	boolean visible;
	int x,y;
	
	Tile(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	void place(Graphics g){
		g.fillRect(x, y, 32, 32);
	}
}
