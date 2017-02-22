package Units;

import MagicStaff.Spell;

/**
 * Created by Muslim on 24.11.2016.
 */
public interface NotControllableUnit {

    // Must return damage dealt
    //Possibly a Unit object will be passed
    //to the method (enemy unit?)
    int attack(Unit goodGuy);


    //Some non-controllable units has passive skills
    //Mostly these skills can reduce stats for some
    // amount. This amount is a return value
    int passiveSkillEffect(Unit goodGuy, Spell spell);

}
