package org.joohopark.World;

import org.joohopark.Assets.Tiles;
import org.joohopark.Input.KeyManager;
import org.joohopark.Input.MouseManager;
import org.joohopark.Screen;
import org.joohopark.Util.Clock;
import org.joohopark.Util.Util;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EditWorld implements Runnable{

    private boolean isRunning;
    private String mapName;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    private Thread thread;
    private World map;
    private Clock clock;
    private Screen editor;

    public EditWorld(String mapName){

        this.mapName = mapName;

        start();

    }

    private void init(){

        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        map = new World(mapName);
        clock = new Clock();

        editor = new Screen(mapName, new Dimension(500, 500));
        editor.getFrame().addKeyListener(keyManager);
        editor.getFrame().addMouseListener(mouseManager);
        editor.getFrame().addMouseMotionListener(mouseManager);
        editor.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Util.saveMap(mapName, map.getxLength(), map.getyLength(), map.getMap());
                editor.getFrame().dispose();
                stop();
            }
        });

        Tiles.init();

        isRunning = true;

    }

    public void run(){
        init();
        while(isRunning){
            if(clock.timer()) {
                tick();
                update();
            }
        }
        stop();
    }

    private void tick(){
        keyManager.tick();
    }

    private void update(){

    }

    public synchronized void start(){
        if(isRunning){
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!isRunning){
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
