package org.joohopark.State;

import org.joohopark.Game;

import javax.swing.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getState(){
        return currentState;
    }

    protected Game game;
    protected JFrame screen;

    protected State(Game game){
        this.game = game;
        this.screen = game.getScreen().getFrame();
    }

    public abstract void tick();
    public abstract void render();

}
