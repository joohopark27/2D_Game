package org.joohopark.State;

import org.joohopark.Game;
import org.joohopark.Util.Util;
import org.joohopark.World.EditWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends State{

    private JButton Start = new JButton("Play");
    private JButton Exit = new JButton("Exit");
    private JButton Edit = new JButton("Edit Map");
    private JLabel Background = new JLabel(new ImageIcon("res/TestBackgroundImg.png"));
    private JComboBox<String> MapList;

    private String selectedMap;
    private final int buttonXSize = 100;
    private final int buttonYSize = 30;
    private final int buttonYLocation = 500 - buttonYSize - 40;

    public MainMenu(Game game){
        super(game);

        Start.setSize(buttonXSize, buttonYSize);
        Start.setLocation(10, buttonYLocation);
        Start.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedMap != "New Map"){

                }
            }
        });

        Edit.setSize(buttonXSize, buttonYSize);
        Edit.setLocation(120, buttonYLocation);
        Edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedMap != "New Map"){
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
        screen.add(MapList);
        MapList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMap = MapList.getSelectedItem().toString();
            }
        });

        Exit.setSize(buttonXSize, buttonYSize);
        Exit.setLocation(370, buttonYLocation);
        screen.add(Exit);
        Exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Background.setSize(490 - 20, buttonYLocation - 20);
        Background.setLocation(10, 10);
        screen.add(Background);
    }

    private void remove(){
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
        screen.add(Start);
        screen.add(Edit);

    }
}
