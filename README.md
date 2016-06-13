# LegoTbbTIot
Android App for Firebase + Lego Codelab

Based on Firebase + Android Codelab al @GDG Global Summit 2016, San Francisco. <br/>
LegoTbbTIot (Lego The Big Bang Theory + IOT) is a sample that shows basic usage of FirebaseArduino to push sensor data to Firebase, and trigger actuators from Firebase through Android App.

![Main](https://raw.githubusercontent.com/andres-vasquez/IoExtendedAndroidFirebase2016/master/screenshots/main.png "Main")
![Main scrolled](https://raw.githubusercontent.com/andres-vasquez/IoExtendedAndroidFirebase2016/master/screenshots/main_1.png "Main Scrolled")

# Initial Setup
Please follow the CodeLab instructions: <br/>
Firebase-Arduino Integration Repo:
https://github.com/googlesamples/firebase-arduino/tree/master/examples/FirebaseRoom_ESP8266

# Android Setup
Edit gradle.properties file with your Firebase url, if you want you use my url: https://iotpanda.firebaseio.com/, Secret: JbYGhXEpIZkh61vYjpFO94YSKravwoShitvM7UDB <br/>
Use this info carefully, please.
 ```java
    UniqueFirebaseRootUrl="https://iotpanda.firebaseio.com/"
```

Play to launch the App.

# Functions
This version include the following functionality:
  1. Vibrator ON/OFF Switch.
  2. Minifan ON/OFF Switch.
  3. Red Light ON/OFF Switch.
  4. Push Button ON/OFF ToggleButton.
  5. Light Sensor Progress Bar

# Note
I want to improve this app including other sensors and functionalities.
<br/>
##### Please feel free to contribute in this project.
<br/>
###### We can show this App and the Codelab in our GDGs events!!!

Regards<br/>
Andrés Vasquez
GDG La Paz, Bolivia
andres.vasquez.agramont@gmail.com