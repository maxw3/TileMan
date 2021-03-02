import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapGen {
	
	private static final int MAP_SIZE_X = 5;
	private static final int MAP_SIZE_Y = 5;
	
	private static File mapFile = new File("map.txt");
	private static Scanner mapScan;
	
	private static ArrayList<String> mapLines = new ArrayList<String>();
	
	public static void init() throws FileNotFoundException {
		scanMap();
		testPrint();
	}
	
	public static void paintMap(Graphics g) {
		int y = 0;
		for(String s: mapLines) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') {
					g.setColor(Color.BLACK);
					g.fillRect(i * 32, y * 32, 32, 32);
				}else {
					g.setColor(Color.WHITE);
					g.fillRect(i * 32, y * 32, 32, 32);
				}
			}
			y++;
		}
	}
	
	public static void testPrint() {
		for(String s: mapLines) {
			System.out.println(s);
		}
	}

	private static void scanMap() throws FileNotFoundException {
		mapScan = new Scanner(mapFile);
		while(mapScan.hasNextLine()) {
			mapLines.add(mapScan.nextLine());
		}
	}

}