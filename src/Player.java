import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel{
	private ImageIcon image = new ImageIcon("player.png");
	
	
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent();
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }
}
