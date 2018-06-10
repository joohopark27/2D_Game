package org.joohopark.World;

import org.joohopark.Assets.Tiles;
import org.joohopark.Launcher;
import org.joohopark.Screen;
import org.joohopark.Util.Clock;
import org.joohopark.Util.Util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditWorld {

    private boolean isRunning;

    private World map;
    private Clock clock;
    private Screen editor;

    public EditWorld(String mapName){

        init(mapName);

    }

    private void init(String mapName){

        editor = new Screen("Editor", new Dimension(500, 500));
        editor.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Util.saveMap(mapName, map.getxLength(), map.getyLength(), map.getMap());
                Launcher.Menu.setVisible(true);
            }
        });

        map = new World(mapName);
        clock = new Clock();

        Tiles.init();

        isRunning = false;

    }

    private void run(){
        while(isRunning){
            if(clock.timer()){
                update();
            }
        }
    }

    private void update(){

    }

}
