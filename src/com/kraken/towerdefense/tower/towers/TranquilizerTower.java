package com.kraken.towerdefense.tower.towers;

import com.kraken.towerdefense.tower.Tower;
import com.kraken.towerdefense.tower.Towers;

public class TranquilizerTower extends Tower {

    public TranquilizerTower(Towers id) {
        super(id);
        setTextureFile("IceTower.png");
        setName("Tranquilizer Tower");
        setFontSize(9);
    }

}
