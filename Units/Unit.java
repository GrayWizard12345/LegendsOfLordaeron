package Units;

import LocationStaff.Location;
import UnitsLook.Dress;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Muslim on 22.11.2016.
 */
public class Unit  implements Serializable{

    //Stats
    private int health;
    private int armor;
    private int damage;
    private double attackSpeed;

    //Stats During a Battle
    private int battleTimeHealth;   //
    private int battleTimeArmor;    //Calculated Before each battle
    private int battleTimeDamage;   //
    private double battleTimeAttackSpeed;

    private String unitName;

    private Location currentLocation;

    public Unit(int health, int armor, int damage, String unitName)
    {
        try{    // try catch due to illegal < 0, but for armor < 0 is ok
            setHealth(health);
            setArmor(armor);
            setDamage(damage);
            setUnitName(unitName);  // Like skeleton, hell worm, wolf, bear
            setBattleTimeArmor(armor);
            setBattleTimeDamage(damage);
            setBattleTimeHealth(health);
            //System.out.println(getBattleTimeDamage()+ " " +getBattleTimeArmor() +" "+ getBattleTimeHealth() );

            //setBattleTimeAttackSpeed();
        }
        catch (IllegalArgumentException err)
        {
            System.out.println(err.getMessage());
            err.printStackTrace();
        }
    }



    //Setters and Getters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getBattleTimeHealth() {
        return battleTimeHealth;
    }

    public void setBattleTimeHealth(int battleTimeHealth) {
        this.battleTimeHealth = battleTimeHealth;
    }

    public int getBattleTimeArmor() {
        return battleTimeArmor;
    }

    public void setBattleTimeArmor(int battleTimeArmor) {
        this.battleTimeArmor = battleTimeArmor;
    }

    public int getBattleTimeDamage() {
        return battleTimeDamage;
    }

    public void setBattleTimeDamage(int battleTimeDamage) {
        this.battleTimeDamage = battleTimeDamage;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setBattleTimeAttackSpeed(double battleTimeAttackSpeed) {
        this.battleTimeAttackSpeed = battleTimeAttackSpeed;
    }

    public double getBattleTimeAttackSpeed() {
        return battleTimeAttackSpeed;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    /*
    * Returns true if unit gets
    * killed in battle
    */
    public boolean isDead()
    {
        if(battleTimeHealth > 0)
            return false;
        setBattleTimeHealth(0);
        return true;
    }

}
