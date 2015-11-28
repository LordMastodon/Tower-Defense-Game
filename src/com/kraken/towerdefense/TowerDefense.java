package com.kraken.towerdefense;

import com.kraken.towerdefense.graphics.Screen;

import javax.swing.*;

public class TowerDefense extends JFrame {

    public static void main(String[] args) {
        new TowerDefense();
    }

    public TowerDefense() {
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setTitle("Tower Defense");

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setResizable(false);

        Screen screen = new Screen(this);
        this.add(screen);

        setVisible(true);
    }

}