package com.BabyNames;

import java.util.ArrayList;

public class BabyNamesDatabase {
    private ArrayList<BabyName> babyNames;

    public BabyNamesDatabase() {
        babyNames = new ArrayList<BabyName>();
    }
    //Mutator Methods
    public void readBabyNameData() {

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
        for (BabyName x : babyNames) {
            if(x.getName().equalsIgnoreCase(name)) {
                // print list of names
            }
        }
    }
    public ArrayList<BabyName> searchForYear(int year) {
        for (BabyName x : babyNames) {
            if(x.getBirthYear() == year) {
                // print list of names in that year
            }
        }
    }
}
