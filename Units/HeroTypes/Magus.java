package Units.HeroTypes;

import LocationStaff.Location;
import Units.Hero;

/**
 * Created by Muslim on 02.12.2016.
 */

/*
* First level magus will have:
* health = 65
* armor = 4
* damage = 40
* attackspeed 4.5
*
 */
public class Magus extends Hero {

    public Magus(int health, int armor, int damage, String gender, String nickName, Location location) {
        super(health, armor, damage, "Magus", gender, nickName, location);
        setAttackSpeed(3.5);//Magus has medium attack speed
        setBattleTimeAttackSpeed(3.5);
    }

    @Override
    public void levelUp() {

    }
}
