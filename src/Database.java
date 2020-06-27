import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class Database {
    public ArrayList<Item> conjureableItemsArrayList = new ArrayList<Item>();
    public ArrayList<Item> sellableItemsArrayList = new ArrayList<Item>();
    public ArrayList<MonsterXML> monstersArrayList = new ArrayList<>();


    public Database() throws IOException, ParserConfigurationException, SAXException {
        AddConjureableItemsToDatabase();
        AddHELMETSAndSoldLocations();
        AddARMORSAndSoldLocations();
        AddLEGSAndSoldLocations();
        AddSHIELDSAndSoldLocations();
        AddWEAPONSAndSoldLocations();

        ReadMonsterXMLfiles();
        ReadItemXMLfile();


        Collections.sort(conjureableItemsArrayList, Comparator.comparing(Item::getName));
        Collections.sort(sellableItemsArrayList, Comparator.comparing(Item::getName));


        /// TEST PRINTING OUT ALL LOOT AFTER EVERYTHING IS ADDED INTO LISTS ETC
        /*
        for(MonsterXML monster : monstersArrayList){
            System.out.println("name: "+monster.getName()+" Loot below...");
            for(MonsterLootXML loot : monster.getLootableItems()){
                System.out.println("Lootname: "+loot.getName()+" Dropchance: "+loot.getLootChance());
            }
        }

         */
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
        Item burstArrow = new Item("Burst Arrow", Item.ITEMTYPE.DISTANCEAMMO, 120, 5);

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
        conjureableItemsArrayList.add(burstArrow);
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

    public void ReadMonsterXMLfiles(){
        try{
            File dir = new File("src\\MonstersXML");
            if (dir.exists() && dir.isDirectory()) {
                File [] files = dir.listFiles((d, name) -> name.endsWith(".xml"));
                if (files != null) {
                    for (File file: files) {

                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        factory.setNamespaceAware(true); // never forget this!
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document doc = builder.parse(file.getPath());

                        XPathFactory xpathfactory = XPathFactory.newInstance();
                        XPath xpath = xpathfactory.newXPath();

                        XPathExpression expr = xpath.compile("/monster/@name |  /monster/@experience |  /monster/@manacost | /monster/health/@now");
                        Object result = expr.evaluate(doc, XPathConstants.NODESET);
                        NodeList nodes = (NodeList) result;

                        MonsterXML monsterXML = new MonsterXML();

                        monsterXML.setName(nodes.item(2).getTextContent());
                        monsterXML.setHealth(nodes.item(3).getTextContent());
                        monsterXML.setExperience(nodes.item(0).getTextContent());
                        monsterXML.setManaToSummon(nodes.item(1).getTextContent());
                        monsterXML.setName(monsterXML.getName().substring(0, 1).toUpperCase() + monsterXML.getName().substring(1));

                        // MONSTER LOOT (ID) AND MONSTER LOOT (DROPCHANCE%)
                        expr = xpath.compile("/monster/loot//item"); // LOOT ID NUMBER
                        result = expr.evaluate(doc, XPathConstants.NODESET);
                        nodes = (NodeList) result;
                        MonsterLootXML monsterLootXML = null;
                        for (int i = 0; i < nodes.getLength(); i++) {
                            Node testNode = nodes.item(i);
                            if(testNode.getNodeType() == Node.ELEMENT_NODE){
                                Element element = (Element) testNode;
                                monsterLootXML = new MonsterLootXML();              // NEW loot object for every iteration
                                monsterLootXML.setId(element.getAttribute("id"));
                                monsterLootXML.setLootChance(element.getAttribute("chance"));
                                monsterLootXML.setLootChance(Calculations.correctDropChanceNumber(monsterLootXML.getLootChance()));

                                if(element.hasAttribute("countmax")){
                                    monsterLootXML.setAmount(element.getAttribute("countmax"));
                                }
                                else{
                                    monsterLootXML.setAmount("1");
                                }
                                monsterXML.addLootableItems(monsterLootXML);
                            }
                        }
                        monstersArrayList.add(monsterXML);
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ReadItemXMLfile(){
        try{
            String fileName = "src\\ItemsXML\\items.xml";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // never forget this!
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);

            XPathFactory xpathfactory = XPathFactory.newInstance();
            XPath xpath = xpathfactory.newXPath();

            XPathExpression expr = xpath.compile("/items/item"); // LOOT ID NUMBER
            Object result = expr.evaluate(doc, XPathConstants.NODESET);
            NodeList nodes = (NodeList) result;

            for (int i = 0; i < nodes.getLength(); i++) { // LENGTH ÄR BARA 1 HÄR wtf??
                Node testNode = nodes.item(i);
                if(testNode.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) testNode;
                    String idFromItemXml = "";
                    String itemNameFromItemXml = "";
                    idFromItemXml = element.getAttribute("id");
                    itemNameFromItemXml = element.getAttribute("name");
                    for(MonsterXML monster : monstersArrayList){
                        for(MonsterLootXML loot : monster.getLootableItems()){
                            if(loot.getId().equals(idFromItemXml)){
                                loot.setName(itemNameFromItemXml.substring(0, 1).toUpperCase() + itemNameFromItemXml.substring(1));
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (XPathExpressionException xPathExpressionException) {
            xPathExpressionException.printStackTrace();
        } catch (SAXException saxException) {
            saxException.printStackTrace();
        }
        /// TEST PRINTING OUT ALLL LOOOT ///
        /*
        for(MonsterXML monster : monstersArrayList){
            System.out.println("Monster name: "+monster.getName());
            System.out.println("Health: "+monster.getHealth());
            System.out.println("Experience: "+monster.getExperience());
            System.out.println("Summon cost: "+monster.getManaToSummon());
            for(MonsterLootXML loot : monster.getLootableItems()){
                System.out.println("Loot id: "+loot.getId()+", Loot name: "+loot.getName()+", Amount dropped: "+loot.getAmount()+", Drop chance in %: "+loot.getLootChance());
            }
            System.out.println("---------------------------------");
        }

         */
    }


    public String[] getItemListNamesAsARRAY(String conjureableORsellableORmonster){
        String[] array = new String [200];
        int x = 0;
        if(conjureableORsellableORmonster.equalsIgnoreCase("conjureable")){
            for(Item item : conjureableItemsArrayList){
                array[x] = item.getName();
                x++;
            }
        }
        else if(conjureableORsellableORmonster.equalsIgnoreCase("sellable")){
            for(Item item : sellableItemsArrayList){
                array[x] = item.getName();
                x++;
            }
        }
        else if(conjureableORsellableORmonster.equalsIgnoreCase("monster")){
            for(MonsterXML monster : monstersArrayList){
                array[x] = monster.getName();
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
    public MonsterXML returnMonsterXML(String monsterName) {
        for (MonsterXML monster : monstersArrayList) {
            if (monsterName.equalsIgnoreCase(monster.getName())) {
                return monster;
            }
        }
        return null;
    }
}
