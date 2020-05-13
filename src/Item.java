import java.util.ArrayList;

public class Item {

    enum ITEMTYPE{
        DISTANCEAMMO,
        RUNE,
        WEAPON,
        SHIELD,
        ARMOR,
    }
    String name;
    int sellValue;
    ITEMTYPE itemtype;
    int manaToMake;
    int manaToMakeFullBP;
    int amountOrCharges;
    double timeToMake;
    int damage;
    int defense;
    short arm;

    // CONJURABLE THINGS SUCH AS RUNES
    Item(String conjurableItemName, ITEMTYPE itemtype, int manaToMake, int amountOrCharges){
        this.name = conjurableItemName;
        this.itemtype = itemtype;
        this.manaToMake = manaToMake;
        this.amountOrCharges = amountOrCharges;
    }
    // WEAPONS CONSTRUCTOR!!!
    Item(String weaponName, int sellValue, int damage, int defense){
        this.name = weaponName;
        this.itemtype = ITEMTYPE.WEAPON;
        this.sellValue = sellValue;
        this.damage = damage;
        this.defense = defense;
    }
    // SHIELDS CONSTRUCTOR
    Item(String shieldName, int sellValue, int defense){
        this.name = shieldName;
        this.itemtype = ITEMTYPE.SHIELD;
        this.sellValue = sellValue;
        this.defense = defense;
    }
    // ARMORS CONSTRUCTOR
    Item(String armorName, int sellValue, short arm){
        this.name = armorName;
        this.itemtype = ITEMTYPE.ARMOR;
        this.sellValue = sellValue;
        this.arm = arm;
    }
    // ARROWS/BOLTS CONSTRUCTOR!!!!
    Item(String distanceAmmoName, ITEMTYPE itemtype, int manaToMake, int amountOrCharges, int damage){
        this.name = distanceAmmoName;
        this.itemtype = itemtype;
        this.manaToMake = manaToMake;
        this.amountOrCharges = amountOrCharges;
        this.damage = damage;
    }
    Item(){

    }

    public int getArm() {
        return arm;
    }

    public void setArm(short arm) {
        this.arm = arm;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAmountOrCharges() {
        return amountOrCharges;
    }


    public int getSellValue() {
        return sellValue;
    }

    public void setSellValue(int sellValue) {
        this.sellValue = sellValue;
    }

    public double getTimeToMake() { return timeToMake; }

    public void setAmountOrCharges(int amountOrCharges) { this.amountOrCharges = amountOrCharges; }

    public String getName() { return name; }
    //public int getValue() { return value; }
    public ITEMTYPE getItemtype() { return itemtype; }
    public int getManaToMake() { return manaToMake; }

    public int getManaToMakeFullBP() {
        return manaToMakeFullBP;
    }

    public void setName(String name) { this.name = name; }
    public void setItemtype(ITEMTYPE itemtype) { this.itemtype = itemtype; }
    //public void setValue(int value) { this.value = value; }
    public void setManaToMake(int manaToMake) { this.manaToMake = manaToMake; }

    public void setManaToMakeFullBP(int manaToMakeFullBP) {
        this.manaToMakeFullBP = manaToMakeFullBP;
    }


}