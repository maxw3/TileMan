import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Tile {
	
	boolean isWall;
	private int x,y;
	private final int SCALE = Main.SCALE;
	
	Tile(int x, int y, boolean isFloor){
		this.x = x * SCALE;
		this.y = y * SCALE;
		this.isWall = isFloor;
	}
	
	void place(Graphics g){
		if(isWall) {
			g.setColor(Color.BLACK);
			g.fillRect(x, y, SCALE, SCALE);
		}else {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, SCALE, SCALE);
		}
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
