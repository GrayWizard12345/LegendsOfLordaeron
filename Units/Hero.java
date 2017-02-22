package Units;

import LocationStaff.Kolimdor;
import LocationStaff.Location;
import MagicStaff.Potions;
import MagicStaff.Spell;
import QuestStuff.EmptyQuest;
import QuestStuff.Quest;
import UnitsLook.Dress;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Muslim on 24.11.2016.
 */
public abstract class Hero extends Unit  implements ControllableUnit{

    public Hero(int health, int armor, int damage, String name, String gender, String nickName, Location location)
    {
        super(health,armor,damage,name);
        setExp(0);
        setGold(0);
        setGender(gender);
        setUserNickName(nickName);
        inventory = new ArrayList<Dress>();

        setCurrentLocation(location);
        setHeroId();

        currentQuest = new EmptyQuest(1,location);
        setUnitName("Hero");

    }
    public final static transient int MAX_NUM_OF_SPELLS = 4;
    public final static transient int MAX_NUM_OF_CLOTHES = 8;
    private int gold;
    private Dress[] dresses; //clothes which are currently on the Hero
    private double exp;     //Must increase every time unit is killed by a hero + quests + items maybe
    private double expThreshold;
    private int level;

    private String userNickName;
    private String gender;

    private ArrayList<Dress> inventory;
    public ArrayList<Dress> getInventory() {
        return inventory;
    }

    private long heroId;
    private Quest currentQuest;

    //Probably we are not gonna use it . . .
    public void setInventory(ArrayList<Dress> inventory) {
        this.inventory = inventory;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getExp() {
        return exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void addGold(int gold)
    {
        this.gold = this.gold + gold;
    }

    public Dress[] getDresses() {
        return dresses;
    }

    public void setDress(Dress[] dress) {
        dresses = dress;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void gainExp(double exp)
    {
        this.exp += exp;
    }

    public void setExpThreshold(double expThreshold) {
        this.expThreshold = expThreshold;
    }

    public double getExpThreshold() {
        return expThreshold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentQuest(Quest currentQuest) {
        this.currentQuest = currentQuest;
    }

    public Quest getCurrentQuest() {
        return currentQuest;
    }

    /* *
             * Hero Id is generated when new hero
             * is created, <code>setHeroId</code> is invoked only once
             * in hero creation process.
             *
             * Uses current time and date to generate unique
             * hero id. The generated id is bigger than int or long, therefore,
             * BigInteger is used to store it, and then this number
             * is hashed to primitive integer dataType.
             * In the online version of the game procedure of Id generation
             * must be changed, due to possible hash collisions. (May be store Id in byte array?)
             * In the database, hero id is a primary key!
             * */
    public void setHeroId() {

        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime = ft.format(dNow);
        BigInteger bigNum = new BigInteger(datetime);
        int hashedID =  bigNum.hashCode();

        this.heroId = hashedID;
    }

    public long getHeroId() {
        return heroId;
    }

    @Override
    public int attack(Unit badGuy) {


        double damageMultiplier;
        int damageDealt = 0;

        damageMultiplier = 1 - 0.01 * badGuy.getBattleTimeArmor() / (1 + (0.01 * Math.abs(badGuy.getBattleTimeArmor())));
        damageDealt = (int)(getBattleTimeDamage()*damageMultiplier);
        badGuy.setBattleTimeHealth(badGuy.getBattleTimeHealth() - damageDealt );


            if(badGuy.isDead())
            {
                badGuy.setBattleTimeHealth(0);
                setExp(getExp() + badGuy.getHealth()/10);
            }


        return damageDealt;
    }

    @Override
    public int castAspell(Spell spell) {
        return 0;
    }

    @Override
    public int drinkPotion(Potions potion) {

        switch (potion.getPotionAim())
        {
            case 0:
                setBattleTimeHealth(potion.getPotionEffect() + getBattleTimeHealth());
                break;
            case 1:
                setBattleTimeArmor(potion.getPotionEffect() + getBattleTimeArmor());
                break;
            case 2:
                setBattleTimeDamage(potion.getPotionEffect() + getBattleTimeDamage());
                break;
            case 3:
                setBattleTimeAttackSpeed(potion.getPotionEffect() + getBattleTimeAttackSpeed());
                break;
                default:
                    //Threw an exception maybe, but not necessarily
                    break;
        }

        return 0;
    }

    @Override
    public void calculateStats() {

    }

    //LevelUp is based on hero's experience.
    //LevelUp provides stats increase
    //LevelUp some levels are available for heroes of certain level
    //Abstract, cause every hero type enhances its stats differently
    abstract public void levelUp();
}
