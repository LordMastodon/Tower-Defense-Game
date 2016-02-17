package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class LaserTower extends Tower {

    public LaserTower(Towers id) {
        super(id);
        setTextureFile("LaserTowerUpgrade1.png");
        setName("Laser Tower");
    }

}
