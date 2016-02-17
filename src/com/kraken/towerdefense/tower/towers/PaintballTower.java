package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class PaintballTower extends Tower {

    public PaintballTower(Towers id) {
        super(id);
        setTextureFile("PaintballTowerUpgrade1.png");
        setName("Paintball Tower");
        setFontSize(10);
    }

}
