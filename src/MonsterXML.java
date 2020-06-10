import java.util.ArrayList;

public class MonsterXML {

        private String name;
        private String health;
        private String experience;
        private String isSummonable;
        private ArrayList<MonsterLootXML> lootableItems = new ArrayList<>();
        private String manaToSummon;

        MonsterXML(){

        }

    public ArrayList<MonsterLootXML> getLootableItems() {
        return lootableItems;
    }

    public String getExperience() {
        return experience;
    }

    public String getHealth() {
        return health;
    }

    public String getManaToSummon() {
        return manaToSummon;
    }

    public String getName() {
        return name;
    }

    public String isSummonable() {
        return isSummonable;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public void addLootableItems(MonsterLootXML monsterLootToAdd) {
        this.lootableItems.add(monsterLootToAdd);
    }

    public void setManaToSummon(String manaToSummon) {
        this.manaToSummon = manaToSummon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummonable(String summonable) {
        isSummonable = summonable;
    }
}
