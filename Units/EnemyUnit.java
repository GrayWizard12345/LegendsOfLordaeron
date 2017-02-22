package Units;

import MagicStaff.Spell;

/**
 * Created by Muslim on 24.11.2016.
 */
public class EnemyUnit extends Unit implements NotControllableUnit {




    public  EnemyUnit(int health, int armor, int damage, String name)
    {
        super(health,armor,damage,name);
        setAttackSpeed(4.5);                //This must be changed
        setBattleTimeAttackSpeed(4.5);      //This must be changed

    }

    //Non hero units make twice less damage!!! that is why multipliers are 0.025 and 0.0125
    @Override
    public int attack(Unit goodGuy)
    {
        double damageMultiplier;
        int damageDealt = 0;

            damageMultiplier = 1 - 0.01 * goodGuy.getBattleTimeArmor() / (1 + (0.01 * Math.abs(goodGuy.getBattleTimeArmor())));
            damageDealt = (int)(getBattleTimeDamage()*damageMultiplier);
            goodGuy.setBattleTimeHealth(goodGuy.getBattleTimeHealth() - damageDealt );


        if(goodGuy.getBattleTimeHealth() < 0)
            goodGuy.setBattleTimeHealth(0);

            return damageDealt;
    }

    @Override
    public int passiveSkillEffect(Unit goodGuy, Spell spell)
    {
        return 0;
    }


}
