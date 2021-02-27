import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Main {
	
	static MainFrame myMainFrame;
	
	public static void main(String[] args) {
		
		myMainFrame = new MainFrame();
		
		myMainFrame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(myMainFrame, 
		            "Are you sure you want to terminate the game?", "terminado?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		            System.exit(0);
		        }
		    }
		});
	}

}
