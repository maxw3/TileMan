import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
Avery: Movement
Max: Level Generation
Johnnie: Enemy AI
Walker: Art
**/

public class Main {
	
	public final static int SCALE = 32;
	static MainFrame myMainFrame;
	
	public static void main(String[] args) throws FileNotFoundException {
		myMainFrame = new MainFrame();
		MapGen.init();
	}
}

//This is a much better comment