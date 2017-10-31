package com.BabyNames;

import java.util.ArrayList;
import java.util.Collections;

public class BabyNamesDatabase {
    private ArrayList<BabyName> babyNames;

    public BabyNamesDatabase() {
        babyNames = new ArrayList<BabyName>();
    }
    //Mutator Methods
    public void readBabyNameData(String filename) {

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
    public BabyName mostPopularGirl(int year) {
        for(BabyName x : babyNames) {

        }
    }
    public BabyName mostPopularBoy(int year) {
        for(BabyName x : babyNames) {

        }
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
        Collections.sort(babyNames);
        for (int i = 0; i < babyNames.size(); i++) {
            if () {

            }
        }
    }

}
