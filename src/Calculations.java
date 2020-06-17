import java.text.DecimalFormat;

public class Calculations {

    double HpGainedPerSecond;
    double HpGainedPerMINUTE;
    double ManaGainedPerSecond;
    double ManaGainedPerMINUTE;


    Calculations(){

    }

    public String xpPerHourCalculation(int startingOfHuntXp, int endOfHuntXp){
        int totalXpGainedFromHunt = endOfHuntXp - startingOfHuntXp;
        return "";
    }

    public static String correctDropChanceNumber(String dropChanceNumberToInput){
        String returnString = "";
        if(dropChanceNumberToInput.length() == 6){
            returnString = "100";
        }
        else if(dropChanceNumberToInput.length() == 5){
            returnString = dropChanceNumberToInput.charAt(0) + "0";
        }
        else if(dropChanceNumberToInput.length() == 4){
            returnString = String.valueOf(dropChanceNumberToInput.charAt(0));
        }
        else if(dropChanceNumberToInput.length() == 3){
            returnString = "0." + dropChanceNumberToInput.charAt(0);
        }
        else if(dropChanceNumberToInput.length() == 2){
            returnString = "VAFAN EREHÄR";
        }
        return returnString;
    }
    public void calculateRegeneration(Character characterInput){
        if(characterInput.getPromotionStatus() == true){
            if(characterInput.getVocationName().equalsIgnoreCase("Elite knight")){
                setHpPerSecMin_SetManaPerSecMin(characterInput, 0.250, 0.083);
            }
            else if(characterInput.getVocationName().equalsIgnoreCase("Royal paladin")){
                setHpPerSecMin_SetManaPerSecMin(characterInput, 0.167, 0.167);
            }
            else if(characterInput.getVocationName().equalsIgnoreCase("Elder druid") ||
                    characterInput.getVocationName().equalsIgnoreCase("Master sorcerer")){

                setHpPerSecMin_SetManaPerSecMin(characterInput, 0.083, 0.250);
            }
        }
        else if(characterInput.getPromotionStatus() == false){
            if(characterInput.getVocationName().equalsIgnoreCase("Knight")){
                setHpPerSecMin_SetManaPerSecMin(characterInput, 0.167, 0.083);
            }
            else if(characterInput.getVocationName().equalsIgnoreCase("Paladin")){
                setHpPerSecMin_SetManaPerSecMin(characterInput, 0.125, 0.125);
            }
            else if(characterInput.getVocationName().equalsIgnoreCase("Druid") ||
                characterInput.getVocationName().equalsIgnoreCase("Sorcerer")){

                setHpPerSecMin_SetManaPerSecMin(characterInput, 0.083, 0.167);
            }
        }
    }
    public int distanceAmmoBpCalc(Item itemInput){
        System.out.println("Mana to make one arrow take FROM ITEM INPUT: "+itemInput.getManaToMake());
        System.out.println("Amount opf charges on arrow make spell: "+itemInput.getAmountOrCharges());
        double manaToMakeOne = (double)itemInput.getManaToMake() / itemInput.getAmountOrCharges();
        System.out.println("Mana to make one arrow: "+manaToMakeOne);
        double manaToMakeBp =  manaToMakeOne * 2000;
        System.out.println("Mana to make BP ARROWS: "+manaToMakeBp);
        return (int) manaToMakeBp;
    }

    public String timeToMakeCalculation(Character characterInput, Item itemInput, boolean isWholeBp){
        int itemManaToMake = itemInput.getManaToMake();
        double charManaPerSec = characterInput.getManaGainedPerSecond();
        double secondsToMake = itemManaToMake / charManaPerSec;
        int totalSecondsAsInt = (int) secondsToMake;

        String returnString = "";
        int hours;
        int minutes;
        int seconds;

        System.out.println("Current itemtype: "+itemInput.getItemtype());
        if(isWholeBp == true){
            if(itemInput.getItemtype() == Item.ITEMTYPE.RUNE){
                totalSecondsAsInt = totalSecondsAsInt * 20;
                hours = (totalSecondsAsInt / 3600);
                minutes = ((totalSecondsAsInt / 60)) % 60;
                seconds = totalSecondsAsInt % 60;

                returnString = "Full BP: "+hours+" hrs "+minutes+" min & "+seconds+ " sec";
            }
            else if(itemInput.getItemtype() == Item.ITEMTYPE.DISTANCEAMMO){
                System.out.println("Total seconds to make 15 arrows as integer = "+totalSecondsAsInt);
                int secondsToMakeOneSingleArrowOrBolt = (totalSecondsAsInt / itemInput.getAmountOrCharges());
                totalSecondsAsInt = secondsToMakeOneSingleArrowOrBolt * 2000;
                hours = (totalSecondsAsInt / 3600);
                minutes = ((totalSecondsAsInt / 60)) % 60;
                seconds = totalSecondsAsInt % 60;

                returnString = "Full BP: "+hours+" hrs "+minutes+" min & "+seconds+ " sec";
            }
        }
        else if(isWholeBp == false){
            if(itemInput.getItemtype() == Item.ITEMTYPE.RUNE || itemInput.getItemtype() == Item.ITEMTYPE.DISTANCEAMMO) {
                //hours = (int) (secondsToMake / 3600);
                minutes = ((int) (secondsToMake / 60)) % 60;
                seconds = (int) secondsToMake % 60;

                returnString = "Time to make : " + minutes + " min & " + seconds + " sec";
            }
        }
        return returnString;
    }

    public double getHpGainedPerSecond() { return HpGainedPerSecond; }
    public double getHpGainedPerMINUTE() { return HpGainedPerMINUTE; }
    public double getManaGainedPerSecond() { return ManaGainedPerSecond; }
    public double getManaGainedPerMINUTE() { return ManaGainedPerMINUTE; }


    public void setHpGainedPerSecond(double HpGainedPerSecond) { this.HpGainedPerSecond = HpGainedPerSecond; }
    public void setHpGainedPerMINUTE(double HpGainedPerMINUTE) {
        this.HpGainedPerMINUTE = HpGainedPerMINUTE;
    }
    public void setManaGainedPerSecond(double ManaGainedPerSecond) { this.ManaGainedPerSecond = ManaGainedPerSecond; }
    public void setManaGainedPerMINUTE(double ManaGainedPerMINUTE) {
        this.ManaGainedPerMINUTE = ManaGainedPerMINUTE;
    }

    public void setHpPerSecMin_SetManaPerSecMin(Character characterInput, double hpPerSecondInput, double manaPerSecondInput){
        characterInput.setHpGainedPerSecond(hpPerSecondInput);
        characterInput.setHpGainedPerMINUTE(hpPerSecondInput * 60);
        characterInput.setManaGainedPerSecond(manaPerSecondInput);
        characterInput.setManaGainedPerMINUTE(manaPerSecondInput * 60);
    }
}
