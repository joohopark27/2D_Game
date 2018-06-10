package org.joohopark;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Canvas canvas;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Screen(String mapName, Dimension dimension){

		frame = new JFrame(mapName);
		frame.setSize(dimension);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(dimension);
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	/*public void updateScreen(int[][] board){
		
		bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, WIDTH, HEIGHT);
		
		for(int y = 4; y < 24; y++){
			for(int x = 0; x < 10; x++){
				//g.drawImage(tile.getBlock(board[y][x]), x * SCALE, (y - 4) * SCALE, SCALE, SCALE, null);
			}
		}

		bs.show();
		g.dispose();
		
	}*/
	
	public JFrame getFrame(){
		return frame;
	}
	
}
