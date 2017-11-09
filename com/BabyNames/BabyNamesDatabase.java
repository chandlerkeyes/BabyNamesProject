package com.BabyNames;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BabyNamesDatabase {
    private ArrayList<BabyName> babyNames;

    public BabyNamesDatabase() {
        babyNames = new ArrayList<BabyName>();
    }

    //Mutator Methods
    public void readBabyNameData(String filename) {
        try {
            FileInputStream fileByteStream = new FileInputStream(filename);
            Scanner scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");

            while (scnr.hasNext()) {
                String name = scnr.next();
                String gender = scnr.next();
                int count = scnr.nextInt();
                int year = scnr.nextInt();
                boolean isFemale;

                if (gender.equalsIgnoreCase("F")) {
                    isFemale = true;
                } else {
                    isFemale = false;
                }

                BabyName entry = new BabyName(name, isFemale, count, year);
                babyNames.add(entry);
            }
            fileByteStream.close();
        } catch (IOException e) {
            System.out.println("Couldn't read file " + filename);
        }
    }

    //Accessor Methods
    public int countAllNames() {
        int count = babyNames.size();
        return count;
    }

    public int countAllGirls() {
        //for each loop
        int count = 0;
        for (BabyName x : babyNames) {
            if (x.isFemale()) {
                count++;
            }
        }
        return count;
    }

    public int countAllBoys() {
        //for each loop
        int count = 0;
        for (BabyName x : babyNames) {
            if (!x.isFemale()) {
                count++;
            }
        }
        return count;
    }

    public BabyName mostPopularBoy(int year) {
        BabyName boy = babyNames.get(0);
        for(BabyName x : babyNames) {
            if(!x.isFemale() && x.getNameCount() >boy.getNameCount()) {
                if(x.getBirthYear() == year) {
                    boy = x;
                }
            }
        }
        return boy;
    }
    public BabyName mostPopularGirl(int year) {
        BabyName girl = babyNames.get(0);
        for(BabyName x : babyNames) {
            if(x.isFemale() && x.getNameCount() >girl.getNameCount()) {
                if(x.getBirthYear() == year) {
                    girl = x;
                }
            }
        }
     return girl;
    }

    public ArrayList<BabyName> searchForName(String name) {
        ArrayList<BabyName> newList = new ArrayList<BabyName>();
        for (BabyName x : babyNames) {
            if(x.getName().equalsIgnoreCase(name)) {
                newList.add(x);
            }
        }
        Collections.sort(newList);
        return newList;
    }
    public ArrayList<BabyName> searchForYear(int year) {
        ArrayList<BabyName> newList = new ArrayList<BabyName>();
        for (BabyName x : babyNames) {
            if(x.getBirthYear() == year) {
                newList.add(x);
            }
        }
        Collections.sort(newList);
        return newList;
    }
    public ArrayList <BabyName> topTenNames(int year) {
        if(babyNames.isEmpty()){
            JOptionPane.showMessageDialog(null,"Must open a file");
            return null;
        }
        else {
            ArrayList<BabyName>namesInYear=new ArrayList<BabyName>();
            ArrayList<BabyName>topTenNames=new ArrayList<BabyName>();
            for (BabyName x: babyNames){
                if(x.getBirthYear() == year){
                    namesInYear.add(x);
                }
            }
            Collections.sort(namesInYear);
            for(int i = 0; i < 10; i++) {
                topTenNames.add(namesInYear.get(i));
            }
            return topTenNames;
        }
    }

}
