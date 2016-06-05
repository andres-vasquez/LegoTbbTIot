package com.gdglapaz.io.legotbbtiot.model;

/**
 * Created by andresvasquez on 4/6/16.
 */
public class Sensors {

    /* Base Class in Firebase Project Structure */

    public int brrr;
    public int cooldown;
    public int pushbutton;
    public int redlight;
    public int sunlight;

    public int getBrrr() {
        return brrr;
    }

    public void setBrrr(int brrr) {
        this.brrr = brrr;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getPushbutton() {
        return pushbutton;
    }

    public void setPushbutton(int pushbutton) {
        this.pushbutton = pushbutton;
    }

    public int getRedlight() {
        return redlight;
    }

    public void setRedlight(int redlight) {
        this.redlight = redlight;
    }

    public int getSunlight() {
        return sunlight;
    }

    public void setSunlight(int sunlight) {
        this.sunlight = sunlight;
    }
}
