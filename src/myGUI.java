import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static javax.swing.BorderFactory.createRaisedBevelBorder;

public class myGUI extends JFrame implements ActionListener {
    DecimalFormat df = new DecimalFormat("0.000");
    Calculations calculations = new Calculations();
    Character character = new Character();
    Database database = new Database();
    Item leftItemObject = new Item();
    Item rightItemObject = new Item();
    public boolean xpCounterIsActive = false;
    Instant startOfHuntTime; ///          GÖR DESSA TILL TIME CLASS SEN
    Instant endOfHuntTime;

    public boolean hasPromotion;


    JFrame frame = new JFrame("Tibia info/calculator");
    JPanel groundPanel = new JPanel();
    JPanel topVocPanel = new JPanel();
    JPanel topTextPanel = new JPanel();
    JPanel characterDataPanel = new JPanel();
    JPanel vocationRESULTPanel = new JPanel();
    JPanel comparisonPanel = new JPanel();

    JPanel ABOVEexpCalculatorPanel = new JPanel();
    JPanel expCalculatorPanel = new JPanel();
    JPanel UNDERCalculatorPanel = new JPanel();



    ArrayList<JButton> listOfCharacterButtons = new ArrayList<>();

    JButton knightButton = new JButton();
    JButton paladinButton = new JButton();
    JButton druidButton = new JButton();
    JButton sorcererButton = new JButton();
    JButton submitInfoButton = new JButton("Submit");
    JButton exitButton = new JButton("Exit");
    JButton startStopXpCounterButton = new JButton("Start/Stop xp counter");

    JCheckBox promotedCheckBox = new JCheckBox("Has promo", false);

    JTextArea testTextArea = new JTextArea(10,10);

    JTextField startingXpField = new JTextField("Start XP here", 10);
    JTextField endingXpField = new JTextField("Ending XP here",10);

    JLabel vocationLabel = new JLabel("...", SwingConstants.CENTER); // NICE
    JLabel hpPerSecLabel = new JLabel("hp/s here"); // NICE
    JLabel hpPerMINLabel = new JLabel("hp/min here"); // NICE
    JLabel manaPerSecLabel = new JLabel("mana/sec here"); // NICE
    JLabel manaPerMINLabel = new JLabel("mana/min here"); // NICE



    JLabel leftItemManaToMake = new JLabel("Left manaToMake here");
    JLabel rightItemManaToMake = new JLabel("Right manaToMake here");
    JLabel leftItemValue = new JLabel("Left itemValue here");
    JLabel rightItemValue = new JLabel("Right itemValue here");
    JLabel timeToMakeLeftItem = new JLabel("Left itemTimeToMake here");
    JLabel timeToMakeRightItem = new JLabel("Right itemTimeToMake here");
    JLabel leftBPtimeToMake = new JLabel("Left BP time to make here");
    JLabel rightBPtimeToMake = new JLabel("Right BP time to make here");

    JLabel topXpGainedText = new JLabel("Xp gained per hour calculator");
    JLabel xpGainedPerHourLabel = new JLabel("XP gain / hour calculated");






    String[] s1 = database.getItemListNamesAsARRAY(); // Lägger till alla items namn i listan istället för objekt
                                                        // behövdes för annars blev de helt cp
    JComboBox LeftDropDownList = new JComboBox(s1);
    JComboBox RightDropDownList = new JComboBox(s1);


    JLabel topText = new JLabel("Enter information below ");
    JLabel emptyLabel = new JLabel("");

    myGUI() throws IOException {



        frame.setLocation(5,10);
        frame.setPreferredSize(new Dimension(420,800));
        frame.setResizable(false);
        frame.add(groundPanel);
        groundPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); // sätter border på main frame
        groundPanel.setBackground(Color.decode("#051122")); // dark blue border
        groundPanel.setLayout(new BoxLayout(groundPanel, BoxLayout.Y_AXIS));

        addAllTopStuff(); // Lägger till hela TOP delen av appen
        groundPanel.add(vocationRESULTPanel);
        vocationRESULTPanel.setBackground(Color.WHITE);
        vocationRESULTPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#5a2800")));
        groundPanel.add(characterDataPanel);

        characterDataPanel.setLayout(new GridLayout(2,4));

        vocationRESULTPanel.add(vocationLabel);
        characterDataPanel.setBackground(Color.decode("#fff2db"));
        characterDataPanel.add(hpPerSecLabel);
        characterDataPanel.add(hpPerMINLabel);
        characterDataPanel.add(manaPerSecLabel);
        characterDataPanel.add(manaPerMINLabel);
        characterDataPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#5a2800")));


        groundPanel.add(comparisonPanel);
        comparisonPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#5a2800")));
        comparisonPanel.setLayout(new GridLayout(5,2));
        comparisonPanel.add(LeftDropDownList);
        LeftDropDownList.addActionListener(this);
        comparisonPanel.add(RightDropDownList);
        RightDropDownList.addActionListener(this);


        comparisonPanel.add(leftItemManaToMake);
        comparisonPanel.add(rightItemManaToMake);
        comparisonPanel.add(leftItemValue);
        comparisonPanel.add(rightItemValue);
        comparisonPanel.add(timeToMakeLeftItem);
        comparisonPanel.add(timeToMakeRightItem);
        comparisonPanel.add(leftBPtimeToMake);
        comparisonPanel.add(rightBPtimeToMake);

        groundPanel.add(ABOVEexpCalculatorPanel);
        ABOVEexpCalculatorPanel.setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.decode("#5a2800")));
        ABOVEexpCalculatorPanel.setBackground(Color.WHITE);
        ABOVEexpCalculatorPanel.add(topXpGainedText);

        groundPanel.add(expCalculatorPanel);
        expCalculatorPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.decode("#5a2800")));
        expCalculatorPanel.setBackground(Color.decode("#fff2db"));
        expCalculatorPanel.add(startingXpField);
        //startingXpField.addActionListener(this);              // behövs nog ingen listener för dessa fält, endast knappen
        expCalculatorPanel.add(endingXpField);
        //startingXpField.addActionListener(this);
        expCalculatorPanel.add(startStopXpCounterButton);
        startStopXpCounterButton.addActionListener(this);

        groundPanel.add(UNDERCalculatorPanel);
        UNDERCalculatorPanel.add(xpGainedPerHourLabel);
        UNDERCalculatorPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.decode("#5a2800")));
        UNDERCalculatorPanel.setBackground(Color.decode("#fff2db"));





        groundPanel.add(testTextArea);
        testTextArea.setBorder(BorderFactory.createMatteBorder(0, 2, 3, 2, Color.decode("#5a2800")));

        groundPanel.add(exitButton);
        exitButton.setPreferredSize(new Dimension(60,25));
        exitButton.addActionListener(this);

        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() instanceof JButton){
            if(e.getSource() == exitButton){
                System.exit(0);
            }
            else if(e.getSource() == submitInfoButton){
                System.out.println("submittat!!! promotionStatus: "+hasPromotion);
                vocationLabel.setText(character.getVocationName());
                formatAndCalculateHpMana();
            }
            else if(e.getSource() == knightButton){
                if(character.getPromotionStatus() == true){
                    character.setCharacterData("Elite Knight", true);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(knightButton);
                }
                else{
                    character.setCharacterData("Knight", false);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(knightButton);

                }
                System.out.println("Character: "+character.getVocationName()+"\nPromotion status: "+character.getPromotionStatus());
            }
            else if(e.getSource() == paladinButton) {
                if(character.getPromotionStatus() == true){
                    character.setCharacterData("Royal Paladin", true);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(paladinButton);
                }
                else{
                    character.setCharacterData("Paladin", false);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(paladinButton);
                }
                System.out.println("Character: "+character.getVocationName()+"\nPromotion status: "+character.getPromotionStatus());
            }
            else if(e.getSource() == druidButton) {
                if(character.getPromotionStatus() == true){
                    character.setCharacterData("Elder Druid", true);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(druidButton);
                }
                else{
                    character.setCharacterData("Druid", false);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(druidButton);
                }
                System.out.println("Character: "+character.getVocationName()+"\nPromotion status: "+character.getPromotionStatus());
            }
            else if(e.getSource() == sorcererButton) {
                if(character.getPromotionStatus() == true){
                    character.setCharacterData("Master Sorcerer", true);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(sorcererButton);

                }
                else{
                    character.setCharacterData("Sorcerer", false);
                    //characterCharacterLabel.setText(character.getVocationName());
                    changeButtonBorderOnPress(sorcererButton);

                }
                System.out.println("Character: "+character.getVocationName()+"\nPromotion status: "+character.getPromotionStatus());
            }
            else if(e.getSource() == startStopXpCounterButton && startingXpField.getText() != null){

                if(xpCounterIsActive == false){
                    ///////// THIS IS WHERE WE ARE IN THE CODE
                    //////// ENTER CP CALCULATOR INTO APP

                    xpGainedPerHourLabel.setText("Xp clock is counting...");
                    startOfHuntTime = Instant.now();
                    System.out.println("Showing Starting time as instant: "+startOfHuntTime);
                    xpCounterIsActive = true;
                }
                else{

                    endOfHuntTime = Instant.now();
                    System.out.println("showing ENDING time as instant: "+endOfHuntTime);
                    long timeElapsed = Duration.between(startOfHuntTime, endOfHuntTime).toMillis();
                    System.out.println("Testprint of instant elapsed time as millis: "+timeElapsed);
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(timeElapsed);
                    System.out.println("Test with SECONDS timeunit thingy: "+seconds);
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(timeElapsed);
                    System.out.println("Test with MINUTES timeunit thingy: "+minutes);
                    long hours = TimeUnit.MILLISECONDS.toHours(timeElapsed);
                    System.out.println("Test with HOURS timeunit thingy: "+hours);

                    // HITTILSS ÄR ALLT BRA OCH JAG HAR SEKUNDERNA SAMT MINUTERNA SOM LONG


                    int xpAfterHunt = Integer.parseInt(endingXpField.getText());
                    int xpBeforeHunt = Integer.parseInt(startingXpField.getText());
                    int xpGainedOnHunt = xpAfterHunt - xpBeforeHunt;
                    System.out.println("Total xp gained on hunt: "+xpGainedOnHunt);

                    //minutes = 1;
                    float hoursAsDouble = (float) minutes / 60;
                    System.out.println("Test with HOURS double: "+hoursAsDouble);

                    float xpGainedPerHour = xpGainedOnHunt / hoursAsDouble ;

                    System.out.println("Testing how much xp i got per hour: "+xpGainedPerHour);
                    xpGainedPerHourLabel.setText("Xp/hour: "+xpGainedPerHour);

                    xpCounterIsActive = false;
                }


            }
        }
        else if(e.getSource() instanceof JCheckBox){
            if(e.getSource() == promotedCheckBox){
                if(character.getVocationName().equalsIgnoreCase("Knight") || character.getVocationName().equalsIgnoreCase("Elite knight")){
                    if(promotedCheckBox.isSelected()){
                        hasPromotion = true;
                        character.setPromoted(true);
                        character.setVocationName("Elite Knight");
                        System.out.println("Person HAS promotion!!");
                    }
                    else{
                        hasPromotion = false;
                        character.setPromoted(false);
                        character.setVocationName("Knight");
                        System.out.println("Person does NOT have promotion...");
                    }
                }
                if(character.getVocationName().equalsIgnoreCase("Paladin") || character.getVocationName().equalsIgnoreCase("Royal paladin")){
                    if(promotedCheckBox.isSelected()){
                        hasPromotion = true;
                        character.setPromoted(true);
                        character.setVocationName("Royal paladin");
                        System.out.println("Person HAS promotion!!");
                    }
                    else{
                        hasPromotion = false;
                        character.setPromoted(false);
                        character.setVocationName("Paladin");
                        System.out.println("Person does NOT have promotion...");
                    }
                }
                if(character.getVocationName().equalsIgnoreCase("Druid") || character.getVocationName().equalsIgnoreCase("Elder druid")){
                    if(promotedCheckBox.isSelected()){
                        hasPromotion = true;
                        character.setPromoted(true);
                        character.setVocationName("Elder druid");
                        System.out.println("Person HAS promotion!!");
                    }
                    else{
                        hasPromotion = false;
                        character.setPromoted(false);
                        character.setVocationName("Druid");
                        System.out.println("Person does NOT have promotion...");
                    }
                }
                if(character.getVocationName().equalsIgnoreCase("Sorcerer") || character.getVocationName().equalsIgnoreCase("Master sorcerer")){
                    if(promotedCheckBox.isSelected()){
                        hasPromotion = true;
                        character.setPromoted(true);
                        character.setVocationName("Master sorcerer");
                        System.out.println("Person HAS promotion!!");
                    }
                    else{
                        hasPromotion = false;
                        character.setPromoted(false);
                        character.setVocationName("Sorcerer");
                        System.out.println("Person does NOT have promotion...");
                    }
                }
            }
        }
        else if(e.getSource() instanceof JComboBox && e.getSource() == LeftDropDownList && character.getVocationName() != null){
            //// LEFT OBJECT RESULT HERE //////// LEFT OBJECT RESULT HERE //////// LEFT OBJECT RESULT HERE ////
            String itemNameFromDropList = LeftDropDownList.getSelectedItem().toString();

            leftItemObject = database.returnItem(itemNameFromDropList);

            //leftItemName.setText(leftItemObject.getName());

            if(leftItemObject.getItemtype() == Item.ITEMTYPE.RUNE){

                leftItemManaToMake.setText("Mana cost: "+leftItemObject.getManaToMake()+" // Full Bp: "+(leftItemObject.getManaToMake() * 20));
                leftItemValue.setText("Charges per rune: x"+(leftItemObject.getAmountOrCharges()));
                timeToMakeLeftItem.setText(calculations.timeToMakeCalculation(character, leftItemObject, false));
                leftBPtimeToMake.setText(calculations.timeToMakeCalculation(character, leftItemObject, true));
            }
            else if(leftItemObject.getItemtype() == Item.ITEMTYPE.DISTANCEAMMO){

                leftItemManaToMake.setText("Mana cost: "+leftItemObject.getManaToMake()+" // Full Bp: "+calculations.distanceAmmoBpCalc(leftItemObject));
                leftItemValue.setText("Amount made: x"+(leftItemObject.getAmountOrCharges()));
                timeToMakeLeftItem.setText(calculations.timeToMakeCalculation(character, leftItemObject, false));
                leftBPtimeToMake.setText(calculations.timeToMakeCalculation(character, leftItemObject, true));
            }



        }
        else if(e.getSource() instanceof JComboBox && e.getSource() == RightDropDownList && character.getVocationName() != null){
            //// RIGHT OBJECT RESULT HERE //////// RIGHT OBJECT RESULT HERE //////// RIGHT OBJECT RESULT HERE ////
            String itemNameFromDropList = RightDropDownList.getSelectedItem().toString();

            rightItemObject = database.returnItem(itemNameFromDropList);


            if(rightItemObject.getItemtype() == Item.ITEMTYPE.RUNE){

                rightItemManaToMake.setText("Mana cost: "+rightItemObject.getManaToMake()+" // Full Bp: "+(rightItemObject.getManaToMake() * 20));
                rightItemValue.setText("Charges per rune: x"+(rightItemObject.getAmountOrCharges()));
                timeToMakeRightItem.setText(calculations.timeToMakeCalculation(character, rightItemObject, false));
                rightBPtimeToMake.setText(calculations.timeToMakeCalculation(character, rightItemObject, true));

            }
            else if(rightItemObject.getItemtype() == Item.ITEMTYPE.DISTANCEAMMO){
                rightItemManaToMake.setText("Mana cost: "+rightItemObject.getManaToMake()+" // Full Bp: "+calculations.distanceAmmoBpCalc(rightItemObject));
                rightItemValue.setText("Amount made: x"+(rightItemObject.getAmountOrCharges()));
                timeToMakeRightItem.setText(calculations.timeToMakeCalculation(character, rightItemObject, false));
                rightBPtimeToMake.setText(calculations.timeToMakeCalculation(character, rightItemObject, true));
            }
        }

    }
    public void changeButtonBorderOnPress(JButton buttonToChange){
        //buttonToChange.setBorder(BorderFactory.createLineBorder(Color.decode("#5a2800"), 4, true));
        buttonToChange.setBorder(BorderFactory.createBevelBorder(1));
        //buttonToChange.setBackground(Color.decode("#5a2800"));
        Border emptyBorder = BorderFactory.createEmptyBorder();
        for(JButton button : listOfCharacterButtons){
            if(button != buttonToChange){
                button.setBorder(createRaisedBevelBorder());
            }
        }
    }

    public void addAllTopStuff(){
        listOfCharacterButtons.add(knightButton);
        listOfCharacterButtons.add(paladinButton);
        listOfCharacterButtons.add(druidButton);
        listOfCharacterButtons.add(sorcererButton);
        knightButton.setIcon(new ImageIcon("src/Pictures/carlin_sword.gif"));

        paladinButton.setIcon(new ImageIcon("src/Pictures/Crossbow.gif"));
        druidButton.setIcon(new ImageIcon("src/Pictures/Ultimate_Healing_Rune.gif"));
        sorcererButton.setIcon(new ImageIcon("src/Pictures/Sudden_Death.gif"));
        //Lägger till alla vocation buttons samt actionListeners
        groundPanel.add(topTextPanel);
        topTextPanel.setBackground(Color.decode("#fff2db"));
        topTextPanel.setBorder(BorderFactory.createMatteBorder(3, 2, 0, 2, Color.decode("#5a2800")));
        topTextPanel.add(topText);
        groundPanel.add(topVocPanel);
        //topVocPanel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));


        // nedan är test med DUBBEL border för framtiden
        //topVocPanel.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.decode("#fff2db"),5),
        //        new LineBorder(Color.decode("#5a2800"),5)));
        //test med mörkbrun border på panelerna
        topVocPanel.setBorder(BorderFactory.createMatteBorder(0, 2, 3, 2, Color.decode("#5a2800")));
        topVocPanel.setBackground(Color.decode("#fff2db")); // Ljusbrun bakgrund
        topVocPanel.setLayout(new GridLayout(2,4));
        for(var vocButton : listOfCharacterButtons){
            vocButton.setBorder(createRaisedBevelBorder());
            vocButton.setContentAreaFilled(false);
            vocButton.setFocusPainted(false);
            topVocPanel.add(vocButton);
            vocButton.addActionListener(this);
        }
        topVocPanel.add(emptyLabel);
        topVocPanel.add(promotedCheckBox);
        promotedCheckBox.setFocusPainted(false);
        promotedCheckBox.addActionListener(this);
        topVocPanel.add(submitInfoButton);
        submitInfoButton.setFocusPainted(false);
        submitInfoButton.addActionListener(this);

        promotedCheckBox.setBackground(Color.decode("#fff2db"));
    }
    public void formatAndCalculateHpMana(){
        calculations.calculateRegeneration(character);

        double getCalculation = character.getHpGainedPerSecond();
        String formatted = df.format(getCalculation);
        hpPerSecLabel.setText("Hp gain/sec: "+formatted);
        getCalculation = character.getHpGainedPerMINUTE();
        formatted = df.format(getCalculation);
        hpPerMINLabel.setText("Hp gain/min: "+formatted);

        getCalculation = character.getManaGainedPerSecond();
        formatted = df.format(getCalculation);
        manaPerSecLabel.setText("Mana gain/sec: "+formatted);
        getCalculation = character.getManaGainedPerMINUTE();
        formatted = df.format(getCalculation);
        manaPerMINLabel.setText("Mana gain/min: "+formatted);
    }
}
