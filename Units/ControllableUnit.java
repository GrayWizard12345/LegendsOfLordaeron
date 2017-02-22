package Units;

import MagicStaff.Potions;
import MagicStaff.Spell;

/**
 * Created by Muslim on 22.11.2016.
 */
public interface ControllableUnit {

    // Must return damage dealt
    //Possibly a Unit object will be passed
    //to the method (enemy unit?)
    int attack(Unit badGuy);


    //The function must return the damage dealt
    //or the health points restored
    int castAspell(Spell spell);


    //Returns amount of data changed (power enhanced or armor strengthened)
    int drinkPotion(Potions potion);


    void calculateStats();
}
