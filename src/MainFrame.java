import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener, EventListener{
	
	private JLabel title = new JLabel("this is a mess");
	private ImageIcon image = new ImageIcon("logo.png");
	
	static JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	
	MainFrame(){
		//----------------------------------------------------------configure window
		this.setTitle("TileMan");
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.setResizable(true);				//resizable?
		this.setSize(1400, 1050);
		this.setLayout(new BorderLayout(2,2));
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
