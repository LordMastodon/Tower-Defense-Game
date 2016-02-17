package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class FlameTower extends Tower {

    public FlameTower(Towers id) {
        super(id);
        setTextureFile("FlameTowerUpgrade1.png");
        setName("Flame Tower");
    }

}
