import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Database {
    Item item = new Item();
    public ArrayList<Item> itemArrayList = new ArrayList<Item>();


    public Database(){
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
        itemArrayList.add(hmm);
        itemArrayList.add(gfb);
        itemArrayList.add(lmm);
        itemArrayList.add(ih);
        itemArrayList.add(fb);
        itemArrayList.add(ef);
        itemArrayList.add(df);
        itemArrayList.add(fbomb);
        itemArrayList.add(uh);
        itemArrayList.add(mw);
        itemArrayList.add(sd);
        Item arrow = new Item("Arrow", Item.ITEMTYPE.DISTANCEAMMO, 40, 15, 25);
        Item bolt = new Item("Bolt", Item.ITEMTYPE.DISTANCEAMMO, 70, 10, 30);
        Item explosiveArrow = new Item("Explosive Arrow", Item.ITEMTYPE.DISTANCEAMMO, 120, 5);

        itemArrayList.add(arrow);
        itemArrayList.add(bolt);
        itemArrayList.add(explosiveArrow);


        Collections.sort(itemArrayList, Comparator.comparing(Item::getName));
    }


    public  ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    public String[] getItemListNamesAsARRAY(){
        String[] array = new String [100];
        int x = 0;
        for(Item item : itemArrayList){
            array[x] = item.getName();
            x++;
        }
        return array;
    }

    public Item returnItem(String itemName){
        for(Item item : itemArrayList){
            if(itemName.equalsIgnoreCase(item.name)){
                return item;
            }
        }
        return null;
    }
}
