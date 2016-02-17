package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class DisruptionTower extends Tower {

    public DisruptionTower(Towers id) {
        super(id);
        setTextureFile("DisruptionTowerUpgrade1.png");
        setName("Disruption Tower");
        setFontSize(9);
    }

}
