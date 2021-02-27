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
		initUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void initUI() {
		this.setTitle("TileMan by TileMans Studios Inc.");
		
		this.setResizable(false);	//resizable?
		
		this.setSize(1000, 1028);
		this.setVisible(true);
		
		this.add(playField);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
