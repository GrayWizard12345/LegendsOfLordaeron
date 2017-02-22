package MagicStaff;

/**
 * Created by Muslim on 25.11.2016.
 */
public abstract class CorruptingSpell  extends Spell{

    //Corruption can be a damage dealt by a spell
    //or amount of stats decreased (temporarily) during a battle
    private int corruption;

    public CorruptingSpell(String spellName, int corruption)
    {
        super(spellName);
        setCorruption(corruption);
    }

    public void setCorruption(int corruption) {
        this.corruption = corruption;
    }

    public int getCorruption() {
        return corruption;
    }
}
