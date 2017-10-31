package com.BabyNames;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

public class BabyName implements Comparable{
    private String name;
    private boolean gender;
    private int nameCount;
    private int birthYear;

    public BabyName(String name, boolean gender, int nameCount, int birthYear) {
        this.name = name;
        this.gender = gender;
        this.nameCount = nameCount;
        this.birthYear = birthYear;
    }
    //if gender is true, then it's a female
    public boolean isFemale() {
        if (gender) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getNameCount() {
        return nameCount;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setNameCount(int nameCount) {
        this.nameCount = nameCount;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    //returns formatted string
    @Override
    public String toString() {
        return "BabyName{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", nameCount=" + nameCount +
                ", birthYear=" + birthYear +
                '}';
    }
    @Override
    public int compareTo(Object other) {
        BabyName b = (BabyName) other;
        return (b.nameCount - nameCount);
    }

    //for testing
    public static void main(String[] args) {

    }
}
