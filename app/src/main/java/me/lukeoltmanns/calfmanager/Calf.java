package me.lukeoltmanns.calfmanager;

import java.io.Serializable;

public class Calf implements Serializable {
    // Local Variables
    String id;
    String name;
    String birth;
    String mother;
    String breed;
    String weight;
    String milk;
    String health;

    // Constructor
    public Calf(){
        this.id = getId();
        this.name = getName();
        this.birth = getBirth();
        this.mother = getMother();
        this.breed = getBreed();
        this.weight = getWeight();
        this.milk = getMilk();
        this.health = getHealth();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getMother() {
        return mother;
    }

    public String getBreed() {
        return breed;
    }

    public String getWeight() {
        return weight;
    }

    public String getMilk() {
        return milk;
    }

    public String getHealth() {
        return health;
    }

    // Setters
    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    // toString
    @Override
    public String toString() {
        return getId() + " (" + getName() + ")\n" +
               getBirth() + " Dam:" + getMother() + "\n" +
               getBreed() + " " + getWeight() + "lbs\n" +
               getMilk() + "L " + getHealth();
    }
}
