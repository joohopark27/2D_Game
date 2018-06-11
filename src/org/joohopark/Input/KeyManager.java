package org.joohopark.Input;

import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public int lastPressed;
    public boolean num1, num2, num3, num4;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){

        num1 = keys[KeyEvent.VK_1];
        num2 = keys[KeyEvent.VK_2];
        num3 = keys[KeyEvent.VK_3];

    }

    @Override
    public void keyPressed(KeyEvent e) {
        lastPressed = e.getKeyCode();
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
            return;
        }
        keys[e.getKeyCode()] = true;
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length){
            return;
        }
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
