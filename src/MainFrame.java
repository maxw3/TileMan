import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener, EventListener{
	
	private static final long serialVersionUID = 1L;
	
	PlayField playField = new PlayField();
	
	MainFrame(){
		initUI();
		
	}

	public void initUI() {
		this.setTitle("TileMan by TileMans Studios Inc.");
		this.setResizable(false);
		this.setSize(1000, 1028);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//------[FIRST]-------//
		
		//_____[ADD_STUFF]____//
		this.add(playField);
		
		//_______[LAST]_______//
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
