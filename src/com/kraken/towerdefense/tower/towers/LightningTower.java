package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class LightningTower extends Tower {

    public LightningTower(Towers id) {
        super(id);
        setTextureFile("LightningTowerUpgrade1.png");
        setName("Lightning Tower");
        setFontSize(10);
    }

}
