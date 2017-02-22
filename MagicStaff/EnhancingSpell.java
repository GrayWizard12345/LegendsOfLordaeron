package MagicStaff;

/**
 * Created by Muslim on 25.11.2016.
 */
public abstract class EnhancingSpell extends Spell{

    public EnhancingSpell(String spellName, int enhance)
    {
        super(spellName);
        setEnhance(enhance);
    }

    private int enhance;

    public void setEnhance(int enhance) {
        this.enhance = enhance;
    }

    public int getEnhance() {
        return enhance;
    }
}
