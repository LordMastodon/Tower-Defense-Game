package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class NukeTower extends Tower {

    public NukeTower(Towers id) {
        super(id);
        setTextureFile("NukeTowerUpgrade1.png");
        setName("Nuke Tower");
    }

}
