package Entities;

import Utils.Colors;

public class Goblin extends Character{



    public Goblin(int health, int strength) {
        this.health = health;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return Colors.ANSI_RED + "G " + Colors.ANSI_RESET;
    }
}
