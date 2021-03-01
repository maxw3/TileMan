import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapGen {
	private File map = new File("map.txt");
	private Scanner mapScan = readMap();
	
	public Scanner readMap() {
		try {
			mapScan = new Scanner(map);
		}catch (FileNotFoundException e){
			System.out.println("File Not Found!, check yo' directory");
		}
		return mapScan;
	}

}
