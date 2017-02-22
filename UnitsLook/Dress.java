package UnitsLook;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by Muslim on 22.11.2016.
 */
public abstract class Dress implements Serializable{

    private int addedHealth;
    private int addedDamage;
    private int addedArmor;

    private String name;

    public String getImageIconSourcePath() {
        return imageIconSourcePath;
    }

    public void setImageIconSourcePath(String imageIconSourcePath) {
        this.imageIconSourcePath = imageIconSourcePath;
    }

    private String imageIconSourcePath;

    private int dressPackID;

    ImageIcon icon;

    public void setIcon() {
       this.icon = new ImageIcon(imageIconSourcePath);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    int calculateDressPackID()
    {

        return 0;
    }

    public void setAddedArmor(int addedArmor) {
        this.addedArmor = addedArmor;
    }

    public int getAddedArmor() {
        return addedArmor;
    }

    public void setAddedDamage(int addedDamage) {
        this.addedDamage = addedDamage;
    }

    public int getAddedDamage() {
        return addedDamage;
    }

    public void setAddedHealth(int addedHealth) {
        this.addedHealth = addedHealth;
    }

    public int getAddedHealth() {
        return addedHealth;
    }

    public void setDressPackID(int dressPackID) {
        this.dressPackID = dressPackID;
    }

    public int getDressPackID() {
        return dressPackID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //private double enhanceSpell; Not sure about that

}
