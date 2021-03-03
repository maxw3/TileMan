import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Robot;
import java.awt.geom.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.*;

public class PlayField extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	Enemy enemy = new Enemy();
	Player player = new Player();
	
	private final int SCALE = Main.SCALE;

	public Random random = new Random();
	
	private Timer timer;

	public PlayField() {
		initBoard();
	}
	
	//k
	public void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        this.setBackground(new Color(69,69,180));

        initGame();
	}
	
	private void initGame() {
        timer = new Timer(100, this);
        timer.start();
    }
	
	@Override
    public void paintComponent(Graphics g) {
		MapGen.paintMap(g);
		
		g.setColor(Color.WHITE);
        
        //g.drawImage(enemy.getCurrImage(), enemy.enemyx, enemy.enemyy, this);
        
        g.drawImage(player.getCurrImage(),player.getX(),player.getY(),this); 
    }
	
	public boolean checkLeft(){
//		Point pPoint = new Point(player.getX() + SCALE,player.getY());
//		Point tPoint = pPoint;
//		tPoint.move(tPoint.x - SCALE, tPoint.y); 
//		
//		for(Tile t: MapGen.tiles) {
//			if(t.getY() == tPoint.y && t.getX() == tPoint.x) {
//			}
//		}
		
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {

            int key = keyEvent.getKeyCode();

            if (key == KeyEvent.VK_LEFT && checkLeft()) {
            	player.left();
            }

            if (key == KeyEvent.VK_RIGHT) {
            	player.right();
            }

            if (key == KeyEvent.VK_UP) {
            	player.up();
            }

            if (key == KeyEvent.VK_DOWN) {
            	player.down();
            }
        }
    }
	
	
}
