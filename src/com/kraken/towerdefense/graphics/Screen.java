package com.kraken.towerdefense.graphics;

import com.kraken.towerdefense.TowerDefense;
import com.kraken.towerdefense.logic.User;
import com.kraken.towerdefense.scene.Scene;
import com.kraken.towerdefense.tower.Tower;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

public class Screen extends JPanel implements Runnable {

    Thread thread = new Thread(this);

    public Scene scene;

    TowerDefense tD;

    public RoundRectangle2D.Float playGame, quitGame;
    public boolean playGameHighlighted, quitGameHighlighted;

    int xSquares = 20, ySquares = 10;

    User user;

    Image heartsIcon, moneyIcon;

    public double towerWidth = 1, towerHeight = 1;

    public void loadGame() {
        user = new User(this);

        try {
            heartsIcon = ImageIO.read(new File("res/Hearts.png"));
            moneyIcon = ImageIO.read(new File("res/Money.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void startGame(User user) {
        user.createPlayer();

        this.scene = Scene.GAME;
    }

    @Override
    public void run() {
        loadGame();
    }

    public Screen(TowerDefense tD) {
        thread.start();

        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                playGameHighlighted = playGame.contains(e.getPoint());
                quitGameHighlighted = quitGame.contains(e.getPoint());

                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (playGameHighlighted) {
                    startGame(user);

                    repaint();
                }

                if (quitGameHighlighted) {
                    System.exit(0);
                }
            }
        };

        addMouseMotionListener(ma);
        addMouseListener(ma);
        addMouseWheelListener(ma);

        this.tD = tD;
        scene = Scene.MENU;

        setBackground(new Color(217, 217, 217));
    }

    int frames, oldFrames;
    long millis, oldMillis;
    
    @Override
    public void paintComponent(Graphics g2) {
        super.paintComponent(g2);
        
        millis = System.currentTimeMillis();
        
        playGame = new RoundRectangle2D.Float((getWidth() / 2) - 200, (getHeight() / 2) - 100, 400, 100, 10, 10);
        quitGame = new RoundRectangle2D.Float((getWidth() / 2) - 200, (getHeight() / 2) + 20, 400, 100, 10, 10);

        Graphics2D g = (Graphics2D) g2.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(new Color(217, 217, 217));

        towerWidth = 49;
        towerHeight = 49;

        for (int i = 0; i < xSquares; i++) {
            for (int j = 0; j < ySquares; j++) {
                g.drawRect(i + (i * 50) + 45, j + (j * 50) + 50, 49, 49);
            }
        }

        g.setColor(new Color(155, 155, 155, 200));
        g.fillRect((50 * xSquares) + 75, 50, 240, (50 * ySquares) + 10);
        g.fillRect(45, (50 * ySquares) + 70, (50 * xSquares) + 270, 150);

        if (scene == Scene.MENU) {
            g.fillRect(getWidth() / 4, getHeight() / 8, getWidth() / 2, getHeight() / 3 * 2);

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
        } else if (scene == Scene.GAME) {
            Graphics2D gBuyPane = (Graphics2D) g.create((50 * xSquares) + 75, 50, 240, (50 * ySquares) + 10);

            gBuyPane.drawImage(heartsIcon, 5, 4, 32, 32, null);
            gBuyPane.drawImage(moneyIcon, 5, 34, 32, 32, null);

            gBuyPane.setColor(Color.BLACK);
            gBuyPane.drawLine(10, 75, 225, 75);

            int towerNumber = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 3; j++) {
                    if (Tower.towerList[towerNumber] != null) {
                        Tower currentTower = Tower.towerList[towerNumber];

                        gBuyPane.drawImage(currentTower.getTexture(), (83 * j) + 5, (85 * i) + 85, 64, 64, null);

                        Point middleOfImage = new Point((83 * j) + 37, (85 * i) + 117);

                        gBuyPane.setFont(currentTower.getFont());
                        gBuyPane.drawString(currentTower.getName(), middleOfImage.x - (g.getFontMetrics(currentTower.getFont()).stringWidth(currentTower.getName()) / 2), middleOfImage.y + 45);
                    }

                    towerNumber++;
                }
            }
        }
        
        g.drawString("FPS: " + calcFPS(frames, oldFrames, millis, oldMillis), 10, 10);
        
        frames++;
        
        if (millis - 1 == oldMillis) {
            oldMillis = millis;
            oldFrames = frames;

            frames = 0;
        }
    }
    
    public int calcFPS (int _frames, int _oldFrames, long _oldMillis, long _millis) {
        int fpsIncrease = (_frames - _oldFrames) / (int ) (_millis - _oldMillis);
        return _frames + (fpsIncrease * (1000 - (int) _millis));
    }
}