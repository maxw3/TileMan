import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Player extends JPanel implements ActionListener{
	
	private int maxDots;
	private int dots;
	
	private int dotSize = 50;

	private final int x[] = new int[maxDots];
    private final int y[] = new int[maxDots];

	private boolean moveLeft = false;
    private boolean moveRight = true;
    private boolean moveUp = false;
    private boolean moveDown = false;
    private boolean activeGame = true;
	
	private BufferedImage image;

	 private void move() {

        for (int i = dots; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if (moveLeft) {
            x[0] -= dotSize;
        }

        if (moveRight) {
            x[0] += dotSize;
        }

        if (moveUp) {
            y[0] -= dotSize;
        }

        if (moveDown) {
            y[0] += dotSize;
        }
    }
	
	public Player() {
		
		try {
			image = ImageIO.read(new File("player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setVisible(true);
		this.setBounds(100, 100, 50, 50);

	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters
        Toolkit.getDefaultToolkit().sync();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (activeGame) {

            move();
        }

        repaint();	
	}

	private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            int key = keyEvent.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!moveRight)) {
                moveLeft = true;
                moveUp = false;
                moveDown = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!moveLeft)) {
                moveRight = true;
                moveUp = false;
                moveDown = false;
            }

            if ((key == KeyEvent.VK_UP) && (!moveDown)) {
                moveUp = true;
                moveRight = false;
                moveLeft = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!moveUp)) {
                moveDown = true;
                moveRight = false;
                moveLeft = false;
            }
        }
    }
}
