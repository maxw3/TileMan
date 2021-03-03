import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Tile {
	
	boolean isFloor = true;
	int x,y;
	
	Tile(int x, int y, boolean isFloor){
		this.x = x;
		this.y = y;
		this.isFloor = isFloor;
	}
	
	void place(Graphics g){
		if(isFloor) {
			g.setColor(Color.WHITE);
			g.fillRect(x * 32, y * 32, 32, 32);
		}else {
			g.setColor(Color.BLACK);
			g.fillRect(x * 32, y * 32, 32, 32);
		}
	}
}
