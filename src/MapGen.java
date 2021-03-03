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
	public static ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public static void init() throws FileNotFoundException {
		scanMap();
		testPrint();
	}
	
	public static void paintMap(Graphics g) {
		addToTileList();
		for(Tile t: tiles) {
			t.place(g);
		}
	}
	
	public static void addToTileList() {
		int y = 0;
		for(String s: mapLines) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '0') {
					tiles.add(new Tile(i,y,false));
				}else {
					tiles.add(new Tile(i,y,true));
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