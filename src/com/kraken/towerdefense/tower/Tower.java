package com.kraken.towerdefense.tower;

import com.kraken.towerdefense.tower.towers.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Tower {

    private String textureFile = "";
    private String name = "";
    private int fontSize = 12;

    public static final Tower[] towerList = new Tower[15];

    public static final Tower iceTower = new IceTower(Towers.ICETOWER), flameTower = new FlameTower(Towers.FLAMETOWER), mageTower = new MageTower(Towers.MAGETOWER);
    public static final Tower lightningTower = new LightningTower(Towers.LIGHTNINGTOWER), cannonTower = new CannonTower(Towers.CANNONTOWER), laserTower = new LaserTower(Towers.LASERTOWER);
    public static final Tower paintballTower = new PaintballTower(Towers.PAINTBALLTOWER), disruptionTower = new DisruptionTower(Towers.DISRUPTIONTOWER), nukeTower = new NukeTower(Towers.NUKETOWER);
    public static final Tower pantsTower = new PantsTower(Towers.PANTSTOWER), sniperTower = new SniperTower(Towers.SNIPERTOWER), windTower = new WindTower(Towers.WINDTOWER);
    public static final Tower tranquilizerTower = new TranquilizerTower(Towers.TRANQUILIZERTOWER), oilTower = new OilTower(Towers.OILTOWER), missileTower = new MissileTower(Towers.MISSILETOWER);

    public Towers id;

    public Tower(Towers id) {
        if (towerList[id.ordinal()] == null) {
            towerList[id.ordinal()] = this;

            this.id = id;
        }
    }

    public void setTextureFile(String str) {
        textureFile = str;
    }

    public Image getTexture() {
        Image texture = null;

        try {
            texture = ImageIO.read(new File("res/" + textureFile));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return texture;
    }

    public void setName(String str) {
        name = str;
    }

    public String getName() {
        return name;
    }

    public void setFontSize(int i) {
        fontSize = i;
    }

    public Font getFont() {
        return new Font("Gisha", Font.PLAIN, fontSize);
    }

}
