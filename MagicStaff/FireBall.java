package MagicStaff;

import Units.Unit;

/**
 * Created by Muslim on 25.11.2016.
 */
public class FireBall extends CorruptingSpell {

    double damageMultiplier = .75;
    int damageDealt;

    public FireBall(int damage)
    {
        super("Fire Ball",damage);
        setCorruption(getCorruption() + getSpellLevel()*10);
    }

    @Override
    public void getItsEffect(Unit badGuy,int playersCurrentDamage) {

        int reducedDamage =  (this.getCorruption() - badGuy.getBattleTimeArmor());
        damageDealt = (int)((damageMultiplier + getSpellLevel())*(reducedDamage + 0.75 * playersCurrentDamage));
            badGuy.setBattleTimeHealth(badGuy.getBattleTimeHealth() - damageDealt);
    }


    //Dont know how to upgrade a skill yet
    //It will definitely depend on a exp
    //Probably I will increase corruption and damage multiplier
    @Override
    public void upgrade()
    {
        setSpellLevel(getSpellLevel() + 1);
        setCorruption(getCorruption() + getSpellLevel()*10);
    }
}
