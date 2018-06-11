package org.joohopark;

import org.joohopark.Assets.Tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Canvas canvas;
	
	private BufferStrategy bs;
	private Graphics g;
	
	public Screen(String Title, Dimension dimension){

		frame = new JFrame(Title);
		frame.setSize(dimension);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	
	public void updateScreen(int[][] map){
		
		bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		g.clearRect(0, 0, WIDTH, HEIGHT);

        for(int y = 0; y < map.length; y++){
            for(int x = 0; x < map[y].length; x++){
                g.drawImage(Tiles.getTile(map[y][x]), x * 10, y * 10, 10, 10, null);
            }
        }

		//end drawing
		bs.show();
		g.dispose();
		
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
}
