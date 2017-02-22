package MagicStaff;

import Units.HeroTypes.Druid;
import Units.HeroTypes.Magus;
import Units.HeroTypes.Warrior;
import Units.Unit;
import sun.nio.cs.ext.MacGreek;

/**
 * Created by Muslim on 19.12.2016.
 */
public class StreamOfPower extends EnhancingSpell {

    public StreamOfPower(String spellName, int enhance) {
        super(spellName, enhance);
    }

    @Override
    public void getItsEffect(Unit someGuy, int baseStatOfACaster) throws ClassNotFoundException {
        someGuy.setBattleTimeHealth((int)(someGuy.getBattleTimeHealth() * getSpellLevel() * 0.05) + someGuy.getBattleTimeHealth());
        if (someGuy instanceof Magus)
        {
            someGuy.setBattleTimeDamage(someGuy.getBattleTimeDamage() + (int)(someGuy.getBattleTimeDamage() * getSpellLevel() * 0.5));
        }else if (someGuy instanceof Druid)
        {
            someGuy.setAttackSpeed( someGuy.getAttackSpeed() / (getSpellLevel() + 0.5) + 0.2);
        }else if (someGuy instanceof Warrior)
        {
            someGuy.setBattleTimeArmor(someGuy.getBattleTimeArmor() + (int)(someGuy.getBattleTimeArmor() * getSpellLevel() * 0.6));
        }else
            throw new ClassNotFoundException("Not a hero is passed to a spell");
    }

    @Override
    public void upgrade() {

    }
}
