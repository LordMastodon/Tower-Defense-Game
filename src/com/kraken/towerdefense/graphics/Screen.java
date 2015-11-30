package com.kraken.towerdefense.graphics;

import com.kraken.towerdefense.TowerDefense;
import com.kraken.towerdefense.scene.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class Screen extends JPanel implements Runnable {

    Thread thread = new Thread(this);

    private int FPS = 0;

    public Scene scene;

    TowerDefense tD;

    private boolean running = false;

    public RoundRectangle2D.Float playGame, quitGame;
    public boolean playGameHighlighted, quitGameHighlighted;

    @Override
    public void run() {
        long lastFrame = System.currentTimeMillis();
        int frames = 0;

        running = true;

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

        addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                playGameHighlighted = playGame.contains(e.getPoint());
                quitGameHighlighted = quitGame.contains(e.getPoint());
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (playGameHighlighted) {
                    scene = Scene.GAME;
                    repaint();

                    System.out.println("playGameHighlighted and mouse clicked");
                }

                if (quitGameHighlighted) {
                    running = false;

                    System.out.println("quitGameHighlighted and mouse clicked");
                }

                System.out.println("mouse clicked");
            }
        });

        this.tD = tD;
        scene = Scene.MENU;

        setBackground(new Color(217, 217, 217));
    }

    @Override
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);

        playGame = new RoundRectangle2D.Float((getWidth() / 2) - 200, (getHeight() / 2) - 100, 400, 100, 10, 10);
        quitGame = new RoundRectangle2D.Float((getWidth() / 2) - 200, (getHeight() / 2) + 20, 400, 100, 10, 10);

        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.clearRect(0, 0, getWidth(), getHeight());

        g.drawString("FPS: " + FPS, 10, 10);

        if (scene == Scene.MENU) {
            if (playGameHighlighted) {
                g.setColor(new Color(255, 152, 56));
            } else {
                g.setColor(new Color(4, 47, 61));
            }
            g.fill(playGame);

            if (quitGameHighlighted) {
                g.setColor(new Color(255, 152, 56));
            } else {
                g.setColor(new Color(4, 47, 61));
            }
            g.fill(quitGame);

            g.setColor(Color.WHITE);
            g.setFont(new Font("Gisha", Font.PLAIN, 20));
            g.drawString("Play", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Play") / 2), (getHeight() / 2) - 45);
            g.drawString("Quit", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Quit") / 2), (getHeight() / 2) + 75);

            g.setColor(Color.BLACK);
            g.setFont(new Font("Gisha", Font.PLAIN, 30));
            g.drawString("Tower Defense Menu", (getWidth() / 2) - (g.getFontMetrics().stringWidth("Tower Defense Menu") / 2), (getHeight() / 4) - 15);
            g.draw(playGame);
            g.draw(quitGame);
        }
    }

}