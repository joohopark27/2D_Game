package org.joohopark;

import org.joohopark.Assets.Tiles;
import org.joohopark.Input.KeyManager;
import org.joohopark.Input.MouseManager;
import org.joohopark.State.EditorState;
import org.joohopark.State.MainMenu;
import org.joohopark.State.State;
import org.joohopark.Util.Clock;
import org.joohopark.World.World;

import java.awt.*;

public class Game implements Runnable{

    private boolean isRunning;
    private String mapName;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    private State mainMenu, editor;

    private Thread thread;
    private World map;
    private Clock clock;
    private Screen screen;

    public Game(){

        run();

    }

    private void init(){

        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        clock = new Clock();
        screen = new Screen("2D Game", new Dimension(500, 500));

        Tiles.init();

        isRunning = true;

        mainMenu = new MainMenu(this);

        State.setState(mainMenu);

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
        State.getState().render();
    }

    public void changeState(int state, String mapName){
        State.getState().reset();
        this.mapName = mapName;
        switch (state){
            case 1:
                State.setState(mainMenu);
                return;
            case 2:
                editor = new EditorState(this);
                State.setState(editor);
                return;
        }
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

    public Screen getScreen(){
        return screen;
    }

    public String getMapName(){
        return mapName;
    }

    public static void main(String[] args) {
        new Game();
    }
}
