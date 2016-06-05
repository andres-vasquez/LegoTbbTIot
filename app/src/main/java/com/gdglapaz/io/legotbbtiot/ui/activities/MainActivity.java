package com.gdglapaz.io.legotbbtiot.ui.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.firebase.client.Firebase;
import com.gdglapaz.io.legotbbtiot.R;
import com.gdglapaz.io.legotbbtiot.controller.FirebaseController;
import com.gdglapaz.io.legotbbtiot.model.Sensors;
import com.gdglapaz.io.legotbbtiot.ui.dialog.AboutDialog;
import com.gdglapaz.io.legotbbtiot.utils.Constants;

public class MainActivity extends AppCompatActivity implements OnCheckedChangeListener{

    public static final String LOG_TAG=MainActivity.class.getSimpleName();

    private Context context;
    private RelativeLayout rlyVibrator;
    private RelativeLayout rlyMiniFan;
    private RelativeLayout rlyLight;
    private RelativeLayout rlyButton;
    private RelativeLayout rlyLightSensor;

    private SwitchCompat switchVibrator;
    private SwitchCompat switchMiniFan;
    private SwitchCompat switchLight;

    private ToggleButton btnPushButton;

    private SeekBar seekBarLightSensor;
    private TextView txtLightSensor;
    private TextView txtFirebaseUrl;

    private Sensors objSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        /* Using FIREBASE URL */
        txtFirebaseUrl.setText(Constants.FIREBASE_URL);
        Firebase.setAndroidContext(context);

        /* Add events to UI components */
        switchVibrator.setOnCheckedChangeListener(this);
        switchLight.setOnCheckedChangeListener(this);
        switchMiniFan.setOnCheckedChangeListener(this);

        /* Listener for Firebase Data Changes */
        new FirebaseController(new FirebaseController.DataChanges() {
            @Override
            public void onDataChanged(Sensors objSensor){

                /* Update UI components from Firebase Data */
                updateSwitch(switchVibrator,objSensor.getBrrr());
                updateSwitch(switchMiniFan,objSensor.getCooldown());
                updateSwitch(switchLight,objSensor.getRedlight());

                if(objSensor.getPushbutton()==Constants.STATE_ACTIVE){
                    btnPushButton.setChecked(true);
                }
                else{
                    btnPushButton.setChecked(false);
                }

                /* Light Sensor UI components */
                txtLightSensor.setText(String.valueOf(objSensor.getSunlight()));
                seekBarLightSensor.setProgress(objSensor.getSunlight());
            }
        }).getData();
    }

    private void init(){
        context=this;
        objSensor=new Sensors();

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rlyVibrator=(RelativeLayout)findViewById(R.id.rlyVibrator);
        rlyMiniFan=(RelativeLayout)findViewById(R.id.rlyMiniFan);
        rlyLight=(RelativeLayout)findViewById(R.id.rlyLight);
        rlyButton=(RelativeLayout)findViewById(R.id.rlyButton);
        rlyLightSensor=(RelativeLayout)findViewById(R.id.rlyLightSensor);

        switchVibrator=(SwitchCompat)findViewById(R.id.switchVibrator);
        switchMiniFan=(SwitchCompat)findViewById(R.id.switchMiniFan);
        switchLight=(SwitchCompat)findViewById(R.id.switchLight);

        btnPushButton=(ToggleButton)findViewById(R.id.btnPushButton);

        seekBarLightSensor=(SeekBar)findViewById(R.id.seekBarLightSensor);
        seekBarLightSensor.setMax(Constants.SUN_LIGHT_MAX);

        txtLightSensor=(TextView)findViewById(R.id.txtLightSensor);
        txtFirebaseUrl=(TextView)findViewById(R.id.txtFirebaseUrl);

        /* Hide title of App over Image */
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout) findViewById(R.id.collapser);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isPressed) {

        int state;
        if(isPressed){
            state=Constants.STATE_ACTIVE;
        }
        else{
            state= Constants.STATE_INACTIVE;
        }

        switch (compoundButton.getId()){
            case R.id.switchVibrator:
                objSensor.setBrrr(state);
                break;
            case R.id.switchMiniFan:
                objSensor.setCooldown(state);
                break;
            case R.id.switchLight:
                objSensor.setRedlight(state);
                break;
            default:
                Log.e(LOG_TAG,"Different Switch checked");
                break;
        }
        FirebaseController.sendData(objSensor);
    }

    /***
     * Update Switch state
     * @param switchCompat UI Component SwitchCompat
     * @param state State to update
     */
    private void updateSwitch(SwitchCompat switchCompat, int state){
        if(state==Constants.STATE_ACTIVE) {
            switchCompat.setChecked(true);
        }
        else{
            switchCompat.setChecked(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if(item.getItemId()==R.id.about){
            /* Show About Dialog */
            DialogFragment dialog = AboutDialog.newInstance();
            dialog.show(MainActivity.this.getFragmentManager(), Constants.ABOUT_TAG);
        }
        return super.onOptionsItemSelected(item);
    }
}
