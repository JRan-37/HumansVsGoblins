package Entities;

import Utils.Colors;

public class Goblin extends Character{



    public Goblin(int health, int strength, int defense, int accuracy) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return Colors.ANSI_RED + "G " + Colors.ANSI_RESET;
    }
}
