package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class CannonTower extends Tower {

    public CannonTower(Towers id) {
        super(id);
        setTextureFile("CannonTowerUpgrade1.png");
        setName("Cannon Tower");
        setFontSize(10);
    }

}
