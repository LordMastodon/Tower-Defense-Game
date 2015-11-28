package com.kraken.towerdefense.graphics;

import com.kraken.towerdefense.TowerDefense;
import com.kraken.towerdefense.listener.KeyHandler;
import com.kraken.towerdefense.scene.Scene;

import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel implements Runnable {

    Thread thread = new Thread(this);

    private int FPS = 0;

    public Scene scene;

    TowerDefense tD;

    private boolean running = false;

    @Override
    public void run() {
        long lastFrame = System.currentTimeMillis();
        int frames = 0;

        running = true;
        scene = Scene.MENU;

        while (running) {
            repaint();

            frames++;

            if (System.currentTimeMillis() - 1000 >= lastFrame) {
                FPS = frames;
                frames = 0;

                lastFrame = System.currentTimeMillis();
            }
        }

        System.exit(0);
    }

    public Screen(TowerDefense tD) {
        thread.start();

        tD.addKeyListener(new KeyHandler(this));

        this.tD = tD;
    }

    @Override
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

//        g.clearRect(0, 0, getWidth(), getHeight());

        g.drawString("FPS: " + FPS, 10, 10);

        if (scene == Scene.MENU) {
            g.setColor(Color.BLACK);

            g.fillRoundRect((getWidth() / 2) - 100, (getHeight() / 2) - 50, 200, 100, 25, 25);
        }
    }

    public class KeyTyped {
        public void keyESC() {
            running = false;
        }
    }

}