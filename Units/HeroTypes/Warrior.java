package Units.HeroTypes;

import LocationStaff.Location;
import Units.Hero;

/**
 * Created by Muslim on 02.12.2016.
 */


/*
* First level warrior will have:
* health = 75
* armor = 20
* damage = 24
* attackSpeed = 4.2
*
*
 */
public class Warrior  extends Hero{

    public Warrior(int health, int armor, int damage, String gender, String nickName, Location location) {
        super(health, armor, damage, "Warrior", gender, nickName, location);
        setAttackSpeed(4.2);//Warrior is slowest due to heavy armor
        setBattleTimeAttackSpeed(4.2);
    }

    @Override
    public void levelUp() {

    }
}
