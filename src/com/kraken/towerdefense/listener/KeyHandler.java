package com.kraken.towerdefense.listener;

import com.kraken.towerdefense.graphics.Screen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private Screen screen;
    private Screen.KeyTyped keyTyped;

    public KeyHandler(Screen screen) {
        this.screen = screen;

        keyTyped = screen.new KeyTyped();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
            keyTyped.keyESC();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
