package com.BabyNames;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

/*************************************************************
 * GUI for a Baby Name Database
 *
 * @author Scott Grissom
 * @version October 7, 2017
 ************************************************************/
public class BabyNameGUI extends JFrame implements ActionListener{

    BabyNamesDatabase db;

    //JButtons
    JButton byYear;
    JButton mostPopular;
    JButton topTen;
    JButton byName;
    //JTextFields
    JTextField year;
    JTextField name;

    /** Results text area */
    JTextArea resultsArea;

    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem openItem;
    JMenuItem countItem;

    /*****************************************************************
     * Main Method
     ****************************************************************/
    public static void main(String args[]){
        BabyNameGUI gui = new BabyNameGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Baby Names");
        gui.pack();
        gui.setVisible(true);
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/
    public BabyNameGUI(){

        db = new BabyNamesDatabase();

        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area to span one column and 10 rows
        resultsArea = new JTextArea(20,20);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        loc.gridx = 0;
        loc.gridy = 1;
        loc.gridheight = 10;
        loc.insets.left = 20;
        loc.insets.right = 20;
        loc.insets.bottom = 20;
        add(scrollPane, loc);

        // create Results label
        loc = new GridBagConstraints();
        loc.gridx = 0;
        loc.gridy = 0;
        loc.insets.bottom = 20;
        loc.insets.top = 20;
        add(new JLabel("Results"), loc);

        // create Searches label
        loc = new GridBagConstraints();
        loc.gridx = 1;
        loc.gridy = 0;
        loc.gridwidth = 2;
        add(new JLabel("Searches"), loc);

        loc = new GridBagConstraints();
        loc.gridx = 1;
        loc.gridy = 1;
        add(new JLabel("Year"), loc);

        loc = new GridBagConstraints();
        loc.gridx = 1;
        loc.gridheight = 9;
        add(new JLabel("Name"), loc);

        year = new JTextField(4);
        name = new JTextField(20);

        loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridy = 1;
        add(year, loc);

        //BUTTON
        byYear = new JButton("By Year");
        loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridy = 2;
        add(byYear, loc);

        mostPopular = new JButton("Most Popular");
        loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridy = 3;
        add(mostPopular, loc);

        topTen = new JButton("Top Ten");
        loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridy = 4;
        add(topTen, loc);

        //Test Field
        loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridheight = 15;
        add(name, loc);
        //last button
        byName = new JButton("By Name");
        loc = new GridBagConstraints();
        loc.gridx = 2;
        loc.gridy = 20;
        add(byName, loc);



        //listeners for the buttons
        byYear.addActionListener(this);
        mostPopular.addActionListener(this);
        topTen.addActionListener(this);
        byName.addActionListener(this);

        // hide details of creating menus
        setupMenus();
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     *
     * @param e the event that was fired
     ****************************************************************/
    public void actionPerformed(ActionEvent e){

        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();

        // Allow user to load baby names from a file
        if (buttonPressed == openItem){
            openFile();
        }
        else if(buttonPressed == quitItem) {
            System.exit(1);
        }
        else if(buttonPressed == topTen) {
            displayTopTen();
        }
        else if(buttonPressed == byName) {
            displayByName();
        }
        else if(buttonPressed == mostPopular) {
            displayMostPopular();
        }
        else if(buttonPressed == byYear){
            displayByYear();
        }
        else if(buttonPressed == countItem) {
            displayCounts();
        }

    }

    /*****************************************************************
     * open a data file with the name selected by the user
     ****************************************************************/
    private void openFile(){

        // create File Chooser so that it starts at the current directory
        String userDir = System.getProperty("user.dir");
        JFileChooser fc = new JFileChooser(userDir);

        // show File Chooser and wait for user selection
        int returnVal = fc.showOpenDialog(this);

        // did the user select a file?
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();

            db.readBabyNameData(filename);
        }
    }

    /*******************************************************
     Creates the menu items
     *******************************************************/
    private void setupMenus(){
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        countItem = new JMenuItem("Counts");
        openItem = new JMenuItem("Open...");
        fileMenu.add(countItem);
        fileMenu.add(openItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // register the menu items with the action listener
        fileMenu.addActionListener(this);
        quitItem.addActionListener(this);
        countItem.addActionListener(this);
        openItem.addActionListener(this);
    }
    private void displayNames(ArrayList<BabyName> list) {
        resultsArea.setText("");
        for(BabyName b : list){
            resultsArea.append("\n" + b.toString());
        }
    }
    private void displayMostPopular() {
        resultsArea.setText("");
        if (year.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Provide a year");
        } else {
            int yr = Integer.parseInt(year.getText());
            BabyName popularBoy = db.mostPopularGirl(yr);
            BabyName popularGirl = db.mostPopularGirl(yr);
            resultsArea.append("\n" + popularBoy.toString() + " " + popularGirl.toString());
        }
    }
    private void displayByYear() {
        resultsArea.setText("");
        if (year.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Provide a year");
        } else {
            int yr = Integer.parseInt(year.getText());
            ArrayList<BabyName> result = db.searchForYear(yr);
            for (BabyName x : result) {
                resultsArea.append("\n" + x.toString());
            }
        }
    }
    private void displayTopTen(){
        resultsArea.setText("");
        if (year.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Provide a year");
        }
        else {
            int yr = Integer.parseInt(year.getText());
            ArrayList<BabyName> result = db.topTenNames(yr);
            for (BabyName x : result) {
                resultsArea.append("\n" + x.toString());
            }
        }
    }
    private void displayByName() {
        String n = name.getText();
        if(name.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a name");
        }
        else {
            resultsArea.setText("");
            ArrayList<BabyName> result = db.searchForName(n);
            for (BabyName x : result) {
                resultsArea.append("\n" + x.toString());
            }
        }
    }
    private void displayCounts() {
        resultsArea.setText("");
        resultsArea.append("\n" + "Boys: " + db.countAllBoys() + " Girls: "
        + db.countAllGirls() + " Total: " + db.countAllNames());
    }
}
