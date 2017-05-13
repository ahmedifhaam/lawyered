package com.mit.lawyered.controller.firebase;

import com.google.firebase.database.DatabaseReference;

/**
 * Created by ASUS on 5/12/2017.
 */

public class OfflineController {

    public void keepSynced(DatabaseReference ref){
        ref.keepSynced(true);
    }
}
