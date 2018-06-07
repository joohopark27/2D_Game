package org.joohopark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launcher {

    JFrame Menu = new JFrame("Launcher");
    JPanel Panel = new JPanel();
    JButton Start = new JButton("Play");
    JButton Exit = new JButton("Exit");
    
    int buttonXSize = 100;
    int buttonYSize = 30;
    int buttonYLocation = 460;
    private final int WIDTH = 490;
    private final int HEIGHT = 530;
	
	public Launcher(){
		
		Menu.setSize(WIDTH, HEIGHT);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.setResizable(false);
        Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		
        Start.setSize(buttonXSize,buttonYSize);
        Start.setLocation(10, buttonYLocation);
        Menu.add(Start);
		
        Exit.setSize(buttonXSize,buttonYSize);
        Exit.setLocation(375, buttonYLocation);
        Menu.add(Exit);
        Exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        });
        
		Menu.setVisible(true);
	}
	
}
