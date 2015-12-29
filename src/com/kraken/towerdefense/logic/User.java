package com.kraken.towerdefense.logic;

import com.kraken.towerdefense.graphics.Screen;
import com.kraken.towerdefense.scene.Scene;

public class User {

    private Screen screen;

    Player player;

    int startingMoney = 30;
    int startingHealth = 10;

    public User(Screen screen) {
        this.screen = screen;

        this.screen.scene = Scene.MENU;
    }

    public void createPlayer() {
        player = new Player(this);
    }

}
