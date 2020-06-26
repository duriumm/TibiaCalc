import javax.swing.*;
import java.util.ArrayList;

public class Item {

    enum ITEMTYPE{
        DISTANCEAMMO,
        RUNE,
        WEAPON,
        SHIELD,
        ARMOR,
    }
    enum LOCATION_WHERE_SOLD {
        VENORE,
        THAIS,
        HARDEK_SW_THAIS,
        KAZORDOON,
        AB_DENDRIEL,
        CARLIN,
        EDRON,
        DARASHIA,
        FIBULA,
        OUTLAW_CAMP,
    }
    private String name;
    private int sellValue;
    private ITEMTYPE itemtype;
    private int manaToMake;
    private int manaToMakeFullBP;
    private int amountOrCharges;
    private double timeToMake;
    private int damage;
    private int defense;
    private short arm;
    private ArrayList<Enum> listOfWhereItemIsSold = new ArrayList<>();

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

    public String getListOfWhereItemIsSold_AsString(Item itemInput) {
        String returnString = "";
        int counter = 0;
        for(Enum item : listOfWhereItemIsSold){
            if(item == LOCATION_WHERE_SOLD.THAIS && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Thais, ";
            }
            else if(item == LOCATION_WHERE_SOLD.THAIS && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Thais.";
            }

            if(item == LOCATION_WHERE_SOLD.HARDEK_SW_THAIS && counter != listOfWhereItemIsSold.size() - 1){
                if(itemInput.getName().equalsIgnoreCase("Viking helmet")){
                    returnString += "Hardek, ";
                }
                else{
                    returnString += "Hardek SW Thais, ";
                }

            }
            else if(item == LOCATION_WHERE_SOLD.HARDEK_SW_THAIS && counter == listOfWhereItemIsSold.size() - 1){
                if(itemInput.getName().equalsIgnoreCase("Viking helmet")){
                    returnString += "Hardek. ";
                }
                else{
                    returnString += "Hardek SW Thais. ";
                }
            }

            if(item == LOCATION_WHERE_SOLD.CARLIN && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Carlin, ";
            }
            else if(item == LOCATION_WHERE_SOLD.CARLIN && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Carlin.";
            }

            if(item == LOCATION_WHERE_SOLD.OUTLAW_CAMP && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Outlaw Camp, ";
            }
            else if(item == LOCATION_WHERE_SOLD.OUTLAW_CAMP && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Outlaw Camp.";
            }

            if(item == LOCATION_WHERE_SOLD.VENORE && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Venore, ";
            }
            else if(item == LOCATION_WHERE_SOLD.VENORE && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Venore.";
            }

            if(item == LOCATION_WHERE_SOLD.AB_DENDRIEL && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Ab'Dendriel, ";
            }
            else if(item == LOCATION_WHERE_SOLD.AB_DENDRIEL && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Ab'Dendriel.";
            }

            if(item == LOCATION_WHERE_SOLD.EDRON && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Edron, ";
            }
            else if(item == LOCATION_WHERE_SOLD.EDRON && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Edron.";
            }

            if(item == LOCATION_WHERE_SOLD.DARASHIA && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Darashia, ";
            }
            else if(item == LOCATION_WHERE_SOLD.DARASHIA && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Darashia.";
            }

            if(item == LOCATION_WHERE_SOLD.FIBULA && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Fibula, ";
            }
            else if(item == LOCATION_WHERE_SOLD.FIBULA  && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Fibula.";
            }

            if(item == LOCATION_WHERE_SOLD.KAZORDOON && counter != listOfWhereItemIsSold.size() - 1){
                returnString += "Kazordoon, ";
            }
            else if(item == LOCATION_WHERE_SOLD.KAZORDOON  && counter == listOfWhereItemIsSold.size() - 1){
                returnString += "Kazordoon.";
            }
            counter++;
        }
        return returnString;
    }




    public ArrayList<Enum> getListOfWhereItemIsSold() {
        return listOfWhereItemIsSold;
    }

    public void addToListOfWhereItemIsSold(Enum itemLocationToAdd) {
        this.listOfWhereItemIsSold.add(itemLocationToAdd);
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
