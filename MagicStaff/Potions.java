package MagicStaff;

import java.io.Serializable;

/**
 * Created by Muslim on 24.11.2016.
 */
public class Potions implements Serializable{

    public static  int AFFECT_HEALTH = 0;
    public static  int AFFECT_ARMOR = 1;
    public static  int AFFECT_DAMAGE = 2;
    public static  int AFFECT_ATTACK_SPEED = 3;

    private String potionName;

    private int potionEffect;

    private int potionAim;

    public void setPotionEffect(int potionEffect) {
        this.potionEffect = potionEffect;
    }

    public int getPotionEffect() {
        return potionEffect;
    }

    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }

    public String getPotionName() {
        return potionName;
    }

    public void setPotionAim(int potionAim) {
        this.potionAim = potionAim;
    }

    public int getPotionAim() {
        return potionAim;
    }



    /*
    public Potions drinkPoition()
    {
        return this;
    }
    */
}
