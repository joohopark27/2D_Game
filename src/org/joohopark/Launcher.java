package org.joohopark;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Launcher {

    JFrame Menu = new JFrame("Launcher");
    JPanel Panel = new JPanel();
    JButton Start = new JButton("Play");
    JButton Exit = new JButton("Exit");
    JButton Edit = new JButton("Edit Map");
    JComboBox<String> MapList;

    private String selectedMap;
    
    private int buttonXSize = 100;
    private int buttonYSize = 30;
    private final int WIDTH = 480;
    private final int HEIGHT = 530;
    private int buttonYLocation = HEIGHT - buttonYSize - 40;
	
	public Launcher(){
		
		Menu.setSize(WIDTH, HEIGHT);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Menu.setResizable(false);
        Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		
        Start.setSize(buttonXSize, buttonYSize);
        Start.setLocation(10, buttonYLocation);
        Menu.add(Start);
        Start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Edit.setSize(buttonXSize, buttonYSize);
        Edit.setLocation(120, buttonYLocation);
        Menu.add(Edit);

        String[] mapList = (Util.readFile("res/MapList.map")).split("\\s+");
        selectedMap = mapList.length > 0 ?  mapList[0] : "New Map";
        MapList = new JComboBox<>(mapList);
        MapList.addItem("New Map");
        MapList.setSize(buttonXSize + 30, buttonYSize);
        MapList.setLocation(230, buttonYLocation);
        Menu.add(MapList);
        MapList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Exit.setSize(buttonXSize, buttonYSize);
        Exit.setLocation(370, buttonYLocation);
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
