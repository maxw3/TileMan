import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Corridor {
	
	Point start,end;
	
	Corridor(){
		
	}
	
	Corridor(Point start, Point end){
		this.start = start;
		this.end = end;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(start.x, start.y, end.x, 25);
		
		g.fillRect(end.x-25, start.y, 25, end.y);
	}

}
