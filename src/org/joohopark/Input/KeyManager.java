package org.joohopark.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean num1, num2, num3, num4;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        num1 = keys[KeyEvent.VK_1];
        num2 = keys[KeyEvent.VK_2];
        num3 = keys[KeyEvent.VK_3];
        num4 = keys[KeyEvent.VK_4];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
