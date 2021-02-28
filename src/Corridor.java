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
		if(start.x < end.x) {
			g.fillRect(start.x, start.y, start.x + end.x, start.y + end.y);
		}else {
			g.fillRect(0, 0, 0, 0);
		}
	}

}
