package com.gdglapaz.io.legotbbtiot.controller;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.gdglapaz.io.legotbbtiot.model.Sensors;
import com.gdglapaz.io.legotbbtiot.utils.Constants;

/**
 * Created by andresvasquez on 4/6/16.
 */
public class FirebaseController {

    private DataChanges response;
    public FirebaseController(DataChanges response) {
        this.response = response;
    }

    public static void sendData(Sensors objSensor){
        Firebase ref=new Firebase(Constants.FIREBASE_URL);
        ref.setValue(objSensor);
    }

    public void getData(){
        Firebase ref=new Firebase(Constants.FIREBASE_URL);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                    Sensors objSensor= dataSnapshot.getValue(Sensors.class);
                    response.onDataChanged(objSensor);
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    public interface DataChanges{
        public void onDataChanged(Sensors objSensor);
    }
}
