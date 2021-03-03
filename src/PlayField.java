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
        
        g.drawImage(enemy.getCurrImage(), enemy.enemyX, enemy.enemyY, this);
        
        g.drawImage(player.getCurrImage(),player.getX(),player.getY(),this); 
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public boolean checkLeft() {
		
		int goToX = player.getX() - SCALE;
		int goToY = player.getY();
		
		for(Tile t: MapGen.tiles) {
			if(t.getX() == goToX) {
				if(t.getY() == goToY) {
					if(t.isWall) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean checkRight() {
		
		int goToX = player.getX() + SCALE;
		int goToY = player.getY();
		
		for(Tile t: MapGen.tiles) {
			if(t.getX() == goToX) {
				if(t.getY() == goToY) {
					if(t.isWall) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean checkUp() {
		
		int goToX = player.getX();
		int goToY = player.getY() - SCALE;
		
		for(Tile t: MapGen.tiles) {
			if(t.getX() == goToX) {
				if(t.getY() == goToY) {
					if(t.isWall) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean checkDown() {
		
		int goToX = player.getX();
		int goToY = player.getY() + SCALE;
		
		for(Tile t: MapGen.tiles) {
			if(t.getX() == goToX) {
				if(t.getY() == goToY) {
					if(t.isWall) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent) {
        	
        	System.out.print("From:(" + player.getX() + "," + player.getY() + ")");

            int key = keyEvent.getKeyCode();

            if (key == KeyEvent.VK_LEFT && checkLeft()) {
            	player.left();
            }

            if (key == KeyEvent.VK_RIGHT && checkRight()) {
            	player.right();
            }

            if (key == KeyEvent.VK_UP && checkUp()) {
            	player.up();
            }

            if (key == KeyEvent.VK_DOWN && checkDown()) {
            	player.down();
            }
            
            System.out.print(" To:(" + player.getX() + "," + player.getY() + ")");
            System.out.println();
            
        }
    }
	
	
}
