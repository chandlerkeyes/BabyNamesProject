package com.BabyNames;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        BabyNamesDatabase db = new BabyNamesDatabase();
        db.readBabyNameData("BabyNames.csv");

        //System.out.println("TEST: " + db.topTenNames(1999).toString());
        System.out.println(db.mostPopularBoy(1999));
    }
}
