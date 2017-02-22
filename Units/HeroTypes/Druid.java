package Units.HeroTypes;

import LocationStaff.Location;
import LocationStaff.TranquilLocation;
import Units.Hero;

/**
 * Created by Muslim on 02.12.2016.
 */


/*
* First level Driud has:
* health = 65
* armor = 4
* damage = 30
* attackspeed 2.8
*
 */
public class Druid extends Hero {

    public Druid(int health, int armor, int damage, String gender, String nickName, Location location) {
        super(health, armor, damage, "Druid", gender, nickName, location);
        setAttackSpeed(2.8);//Druids are the fastest
        setBattleTimeAttackSpeed(2.8);
    }

    //Level up can be performed only out of battle
    @Override
    public void levelUp() {
        if(getCurrentLocation() instanceof TranquilLocation)
            if (getExp() >= getExpThreshold())
            {
                //Level up staff
            }
    }
}
