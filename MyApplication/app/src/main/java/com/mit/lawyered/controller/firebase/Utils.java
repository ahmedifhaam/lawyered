package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ASUS on 5/13/2017.
 */

public class Utils {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

}
