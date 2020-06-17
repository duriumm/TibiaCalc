public class MonsterLootXML {
    private String name;
    private String lootChance;
    private String id;
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getLootChance() {
        return lootChance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLootChance(String lootChance) {
        this.lootChance = lootChance;
    }
}
