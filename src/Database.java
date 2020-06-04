import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
    public ArrayList<Item> conjureableItemsArrayList = new ArrayList<Item>();
    public ArrayList<Item> sellableItemsArrayList = new ArrayList<Item>();


    public Database(){
        AddConjureableItemsToDatabase();
        AddHELMETSAndSoldLocations();
        AddARMORSAndSoldLocations();
        AddLEGSAndSoldLocations();
        AddSHIELDSAndSoldLocations();
        AddWEAPONSAndSoldLocations();

        Collections.sort(conjureableItemsArrayList, Comparator.comparing(Item::getName));
        Collections.sort(sellableItemsArrayList, Comparator.comparing(Item::getName));

        for(Item sellableItem : sellableItemsArrayList){
            System.out.println("Item name: "+sellableItem.getName()+", Item sell location/s: "+sellableItem.getListOfWhereItemIsSold());
        }
    }


    public  ArrayList<Item> getConjureableItemsArrayList() {
        return conjureableItemsArrayList;
    }

    public void AddConjureableItemsToDatabase(){
        Item hmm = new Item("Heavy Magic Missile Rune", Item.ITEMTYPE.RUNE, 70, 5);
        Item gfb = new Item("Great Fireball Rune", Item.ITEMTYPE.RUNE, 120, 2);
        Item lmm = new Item("Light Magic Missile Rune", Item.ITEMTYPE.RUNE, 40, 5);
        Item ih = new Item("Intense Healing Rune", Item.ITEMTYPE.RUNE, 60, 1);
        Item fb = new Item("Fireball Rune", Item.ITEMTYPE.RUNE, 60, 3);
        Item ef = new Item("Energy Field Rune", Item.ITEMTYPE.RUNE, 80, 3);
        Item df = new Item("Destroy Field Rune", Item.ITEMTYPE.RUNE, 60, 3);
        Item fbomb = new Item("Fire Bomb Rune", Item.ITEMTYPE.RUNE, 150, 2);
        Item uh = new Item("Ultimate Healing Rune", Item.ITEMTYPE.RUNE, 100, 1);
        Item mw = new Item("Magic Wall Rune", Item.ITEMTYPE.RUNE, 250, 4);
        Item sd = new Item("Sudden Death Rune", Item.ITEMTYPE.RUNE, 220, 1);

        Item arrow = new Item("Arrow", Item.ITEMTYPE.DISTANCEAMMO, 40, 15, 25);
        Item bolt = new Item("Bolt", Item.ITEMTYPE.DISTANCEAMMO, 70, 10, 30);
        Item explosiveArrow = new Item("Explosive Arrow", Item.ITEMTYPE.DISTANCEAMMO, 120, 5);

        conjureableItemsArrayList.add(hmm);
        conjureableItemsArrayList.add(gfb);
        conjureableItemsArrayList.add(lmm);
        conjureableItemsArrayList.add(ih);
        conjureableItemsArrayList.add(fb);
        conjureableItemsArrayList.add(ef);
        conjureableItemsArrayList.add(df);
        conjureableItemsArrayList.add(fbomb);
        conjureableItemsArrayList.add(uh);
        conjureableItemsArrayList.add(mw);
        conjureableItemsArrayList.add(sd);

        conjureableItemsArrayList.add(arrow);
        conjureableItemsArrayList.add(bolt);
        conjureableItemsArrayList.add(explosiveArrow);
    }

    public void AddHELMETSAndSoldLocations(){
        Item chainHelmet = new Item("Chain Helmet", 17, (short) 2);
        chainHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        chainHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        chainHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        chainHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(chainHelmet);

        Item brassHelmet = new Item("Brass Helmet", 30, (short) 3);
        brassHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        brassHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        brassHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        brassHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(brassHelmet);

        Item vikingHelmet = new Item("Viking Helmet", 66, (short) 4);
        vikingHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        vikingHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.FIBULA);
        vikingHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        vikingHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        vikingHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        vikingHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(vikingHelmet);

        Item ironHelmet = new Item("Iron Helmet", 190, (short) 5);
        ironHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        sellableItemsArrayList.add(ironHelmet);

        Item steelHelmet = new Item("Steel helmet", 293, (short) 6);
        steelHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        steelHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        steelHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        steelHelmet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(steelHelmet);
    }
    public void AddARMORSAndSoldLocations() {
        Item leatherArmor = new Item("Leather Armor", 12, (short) 4);
        leatherArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        leatherArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        leatherArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(leatherArmor);

        Item chainArmor = new Item("Chain Armor", 70, (short) 6);
        chainArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        chainArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        chainArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        chainArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(chainArmor);

        Item brassArmor = new Item("Brass Armor", 150, (short) 8);
        brassArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        brassArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        brassArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        brassArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(brassArmor);

        Item scaleArmor = new Item("Scale Armor", 75, (short) 9);
        scaleArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.OUTLAW_CAMP);
        sellableItemsArrayList.add(scaleArmor);

        Item plateArmor = new Item("Plate Armor", 400, (short) 10);
        plateArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        plateArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        plateArmor.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sellableItemsArrayList.add(plateArmor);
    }
    public void AddLEGSAndSoldLocations(){
        Item chainLegs = new Item("Chain Legs", 25, (short) 3);
        chainLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        chainLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        chainLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(chainLegs);

        Item brassLegs = new Item("Brass Legs", 49, (short) 5);
        brassLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        brassLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        brassLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        brassLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        sellableItemsArrayList.add(brassLegs);

        Item plateLegs = new Item("Plate Legs", 115, (short) 7);
        plateLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        plateLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        plateLegs.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        sellableItemsArrayList.add(plateLegs);
    }
    public void AddSHIELDSAndSoldLocations(){
        Item brassShield = new Item("Brass Shield", 16, 16);
        brassShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        brassShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        brassShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        brassShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(brassShield);

        Item plateShield = new Item("Plate Shield", 45, 17);
        plateShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        plateShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        plateShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(plateShield);

        Item steelShield = new Item("Steel Shield", 80, 21);
        steelShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        steelShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        steelShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sellableItemsArrayList.add(steelShield);

        Item battleShield = new Item("Battle Shield", 95, 23);
        battleShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        battleShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        battleShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        battleShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        battleShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(battleShield);

        Item dwarvenShield = new Item("Dwarven Shield", 100, 26);
        dwarvenShield.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        sellableItemsArrayList.add(dwarvenShield);
    }
    public void AddWEAPONSAndSoldLocations(){
        // CLUBS
        Item mace = new Item("Mace", 30, 16, 11);
        mace.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        mace.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.FIBULA);
        mace.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        mace.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(mace);

        Item battleHammer = new Item("Battle Hammer", 120, 24, 14);
        battleHammer.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        battleHammer.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        battleHammer.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(battleHammer);

        Item morningStar = new Item("Morning Star", 100, 25, 11);
        morningStar.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        morningStar.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        morningStar.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(morningStar);

        Item clericalMace = new Item("Clerical Mace", 170, 28, 15);
        clericalMace.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sellableItemsArrayList.add(clericalMace);

        // SWORDS
        Item sabre = new Item("Sabre", 12, 12, 10);
        sabre.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        sabre.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        sabre.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sabre.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(sabre);

        Item sword = new Item("Sword", 25, 14, 12);
        sword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        sword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        sword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(sword);

        Item longSword = new Item("Longsword", 51, 17, 14);
        longSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.HARDEK_SW_THAIS);
        longSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        longSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        sellableItemsArrayList.add(longSword);

        Item carlinSword = new Item("Carlin Sword", 118, 15, 13);
        carlinSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        carlinSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.KAZORDOON);
        carlinSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(carlinSword);

        Item spikeSword = new Item("Spikesword", 240, 24, 21);
        spikeSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sellableItemsArrayList.add(spikeSword);

        Item twoHandedSword = new Item("Two Handed Sword", 450, 30, 25);
        twoHandedSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        twoHandedSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.AB_DENDRIEL);
        twoHandedSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        twoHandedSword.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(twoHandedSword);

        // AXES
        Item hatchet = new Item("Hatchet", 25, 15, 8);
        hatchet.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.FIBULA);
        sellableItemsArrayList.add(hatchet);

        Item barbarianAxe = new Item("Barbarian Axe", 185, 28, 18);
        barbarianAxe.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        sellableItemsArrayList.add(barbarianAxe);

        Item battleAxe = new Item("Battle Axe", 80, 25, 10);
        battleAxe.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        battleAxe.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        battleAxe.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(battleAxe);

        Item halberd = new Item("Halberd", 400, 35, 14);
        halberd.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.THAIS);
        halberd.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.EDRON);
        halberd.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.VENORE);
        sellableItemsArrayList.add(halberd);

        Item doubleAxe = new Item("Double Axe", 260, 35, 12);
        doubleAxe.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.CARLIN);
        doubleAxe.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.DARASHIA);
        sellableItemsArrayList.add(doubleAxe);

        // BOW & CROSSBOW
        Item bow = new Item("Bow", 130, 0, 0);
        bow.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.FIBULA);
        sellableItemsArrayList.add(bow);

        Item crossbow = new Item("Crossbow", 160, 0, 0);
        crossbow.addToListOfWhereItemIsSold(Item.LOCATION_WHERE_SOLD.FIBULA);
        sellableItemsArrayList.add(crossbow);
    }


    public String[] getItemListNamesAsARRAY(String conjureableORsellable){
        String[] array = new String [100];
        int x = 0;
        if(conjureableORsellable.equalsIgnoreCase("conjureable")){
            for(Item item : conjureableItemsArrayList){
                array[x] = item.getName();
                x++;
            }
        }
        else if(conjureableORsellable.equalsIgnoreCase("sellable")){
            for(Item item : sellableItemsArrayList){
                array[x] = item.getName();
                x++;
            }
        }
        return array;
    }

    public Item returnItem(String itemName, String conjureableORsellable){
        if(conjureableORsellable.equals("conjureable")){
            for(Item item : conjureableItemsArrayList){
                if(itemName.equalsIgnoreCase(item.getName())){
                    return item;
                }
            }
        }
        else if(conjureableORsellable.equals("sellable")){
            for(Item item : sellableItemsArrayList){
                if(itemName.equalsIgnoreCase(item.getName())){
                    return item;
                }
            }
        }
        return null;
    }
}
