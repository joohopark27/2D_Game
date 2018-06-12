package org.joohopark;

import org.joohopark.Assets.Tiles;
import org.joohopark.State.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Screen extends Canvas{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public Screen(String Title, Dimension dimension){

		frame = new JFrame(Title);
		frame.setSize(dimension);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		
	}

	public JFrame getFrame(){
		return frame;
	}
	
}
