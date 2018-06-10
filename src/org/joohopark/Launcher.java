package org.joohopark;

import org.joohopark.Util.Util;
import org.joohopark.World.EditWorld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Launcher {

    public static JFrame Menu = new JFrame("Launcher");
    private JPanel Panel = new JPanel();
    private JButton Start = new JButton("Play");
    private JButton Exit = new JButton("Exit");
    private JButton Edit = new JButton("Edit Map");
    private JLabel Background = new JLabel(new ImageIcon("res/TestBackgroundImg.png"));
    private JComboBox<String> MapList;

    private String selectedMap;
    
    private final int buttonXSize = 100;
    private final int buttonYSize = 30;
    private final int WIDTH = 490;
    private final int HEIGHT = 530;
    private final int buttonYLocation = HEIGHT - buttonYSize - 40;
	
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
                if(selectedMap != "New Map"){
                    Menu.setVisible(false);
                    new Game(selectedMap);
                }
            }
        });

        Edit.setSize(buttonXSize, buttonYSize);
        Edit.setLocation(120, buttonYLocation);
        Menu.add(Edit);
        Edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.setVisible(false);
                if(selectedMap != "New Map"){
                    Menu.setVisible(false);
                    new EditWorld(selectedMap);
                }
            }
        });

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
                selectedMap = MapList.getSelectedItem().toString();
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

        Background.setSize(WIDTH - 20, buttonYLocation - 20);
        Background.setLocation(10, 10);
        Menu.add(Background);
        
		Menu.setVisible(true);
	}
	
}
