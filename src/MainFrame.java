import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener, EventListener{
	
	private PlayField playField = new PlayField();
	
	MainFrame(){
		//----------------------------------------------------------configure window
		this.setTitle("TileMan by TileMans Studios Inc.");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.setResizable(false);	//resizable?
		
		this.setSize(1000, 1000);
		this.setLayout(null);
		this.setVisible(true);
		
		this.add(playField);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
