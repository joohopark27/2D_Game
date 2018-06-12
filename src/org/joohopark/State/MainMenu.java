package org.joohopark.State;

import org.joohopark.Game;
import org.joohopark.Screen;
import org.joohopark.Util.Util;
import org.joohopark.World.EditWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends State{

//    private JPanel jPanel = new JPanel(new BorderLayout());
    private JButton Start = new JButton("Play");
    private JButton Edit = new JButton("Edit Map");
    private JButton Exit = new JButton("Exit");
    private JLabel Background = new JLabel(new ImageIcon("res/TestBackgroundImg.png"));
    private JComboBox<String> MapList;

    private String selectedMap;
    private final int buttonXSize = 100;
    private final int buttonYSize = 30;
    private final int buttonYLocation = 500 - buttonYSize - 40;

    public MainMenu(Game game){
        super(game);

//        jPanel.setBackground(Color.WHITE);

        Start.setSize(buttonXSize, buttonYSize);
        Start.setLocation(10, buttonYLocation);
        screen.add(Start);
//        jPanel.add(Start);
        Start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedMap != "New Map"){

                }
            }
        });

        Edit.setSize(buttonXSize, buttonYSize);
        Edit.setLocation(120, buttonYLocation);
        screen.add(Edit);
//        jPanel.add(Edit);
        Edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedMap != "New Map"){
                    game.changeState(2, selectedMap);
                }
            }
        });

        String[] mapList = (Util.readFile("res/MapList.map")).split("\\s+");
        selectedMap = mapList.length > 0 ?  mapList[0] : "New Map";
        MapList = new JComboBox<>(mapList);
        MapList.addItem("New Map");
        MapList.setSize(buttonXSize + 30, buttonYSize);
        MapList.setLocation(230, buttonYLocation);
        screen.add(MapList);
//        jPanel.add(MapList);
        MapList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMap = MapList.getSelectedItem().toString();
            }
        });

        Exit.setSize(buttonXSize, buttonYSize);
        Exit.setLocation(370, buttonYLocation);
        screen.add(Exit);
//        jPanel.add(Exit);
        Exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Background.setSize(440 - 20, buttonYLocation - 20);
        Background.setLocation(10, 10);
        screen.add(Background);
//        jPanel.add(Background);

//        screen.add(jPanel);

        screen.setVisible(true);

    }

    @Override
    public void reset(){
        screen.remove(Start);
        screen.remove(Edit);
        screen.remove(MapList);
        screen.remove(Exit);
        screen.remove(Background);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {
    }
}
