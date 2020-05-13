public class Character {
    String vocationName;
    boolean isPromoted;
    double hpGainedPerSecond;
    double hpGainedPerMINUTE;
    double manaGainedPerSecond;
    double manaGainedPerMINUTE;

    public Character(String vocationName, boolean isPromoted, boolean isActive){
        this.vocationName = vocationName;
        this.isPromoted = isPromoted;
    }
    public Character(){

    }

    public String getVocationName() {
        return vocationName;
    }
    public boolean getPromotionStatus() {
        return isPromoted;
    }

    public double getHpGainedPerSecond() { return hpGainedPerSecond; }
    public double getHpGainedPerMINUTE() { return hpGainedPerMINUTE; }
    public double getManaGainedPerSecond() { return manaGainedPerSecond; }
    public double getManaGainedPerMINUTE() { return manaGainedPerMINUTE; }

    public void setHpGainedPerSecond(double hpGainedPerSecond) { this.hpGainedPerSecond = hpGainedPerSecond; }
    public void setHpGainedPerMINUTE(double hpGainedPerMINUTE) { this.hpGainedPerMINUTE = hpGainedPerMINUTE; }
    public void setManaGainedPerSecond(double manaGainedPerSecond) { this.manaGainedPerSecond = manaGainedPerSecond; }
    public void setManaGainedPerMINUTE(double manaGainedPerMINUTE) { this.manaGainedPerMINUTE = manaGainedPerMINUTE; }

    public void setVocationName(String vocationName) {
        this.vocationName = vocationName;
    }
    public void setPromoted(boolean insertPromotedStatus) {
        isPromoted = insertPromotedStatus;
    }

    public void setCharacterData(String vocationNameInput, boolean hasPromotion){
        this.vocationName = vocationNameInput;
        this.isPromoted = hasPromotion;
    }
}
