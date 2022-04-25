package me.lukeoltmanns.calfmanager;

import java.io.Serializable;

public class MilkAmount implements Serializable {
    // Local Variables
    int levelOne;
    int levelTwo;
    int levelThree;
    int noMilk;

    // Constructor
    public MilkAmount() {
        this.levelOne = getLevelOne();
        this.levelTwo = getLevelTwo();
        this.levelThree = getLevelThree();
        this.noMilk = getNoMilk();
    }

    // Getters
    public int getLevelOne() {
        return levelOne;
    }

    public int getLevelTwo() {
        return levelTwo;
    }

    public int getLevelThree() {
        return levelThree;
    }

    public int getNoMilk() {
        return noMilk;
    }

    // Setters
    public void setLevelOne(int levelOne) {
        this.levelOne = levelOne;
    }

    public void setLevelTwo(int levelTwo) {
        this.levelTwo = levelTwo;
    }

    public void setLevelThree(int levelThree) {
        this.levelThree = levelThree;
    }

    public void setNoMilk(int noMilk) {
        this.noMilk = noMilk;
    }

    // toString
    @Override
    public String toString() {
        return "MilkAmount{" +
                "levelOne=" + levelOne +
                ", levelTwo=" + levelTwo +
                ", levelThree=" + levelThree +
                ", noMilk=" + noMilk +
                '}';
    }
}
