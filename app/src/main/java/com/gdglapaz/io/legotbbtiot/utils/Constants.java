package com.gdglapaz.io.legotbbtiot.utils;

import com.gdglapaz.io.legotbbtiot.BuildConfig;

/**
 * Created by andresvasquez on 4/6/16.
 */
public class Constants
{
    //Change with your credentials
    public static final String FIREBASE_URL= BuildConfig.UNIQUE_FIREBASE_ROOT_URL;

    //STATES
    public static final int STATE_ACTIVE=1;
    public static final int STATE_INACTIVE=0;

    //Seekbar
    public static final int SUN_LIGHT_MAX=1000;

    //About Dialog
    public static final String ABOUT_TAG="AboutDialogFragment";
}
