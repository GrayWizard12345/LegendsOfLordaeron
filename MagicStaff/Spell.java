package MagicStaff;

import Units.Unit;

import java.io.Serializable;

/**
 * Created by Muslim on 24.11.2016.
 */
public abstract class Spell implements Serializable{

    private String spellName;
    private int spellLevel;

    //HighestParentConstructor
    public Spell(String spellName)
    {
        setSpellName(spellName);
        setSpellLevel(1);
    }

    //Each spell has different effects
    public abstract void getItsEffect(Unit someGuy, int baseStatOfACaster) throws ClassNotFoundException;

    //Upgrade a spell, enhance its effect(damage, heal ...)
    public  void upgrade()
    {
        setSpellLevel(getSpellLevel() + 1);
    }


    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellLevel(int spellLevel) {
        this.spellLevel = spellLevel;
    }

    public int getSpellLevel() {
        return spellLevel;
    }
}
