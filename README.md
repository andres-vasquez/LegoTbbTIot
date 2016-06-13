# LegoTbbTIot
Android App for Firebase + Lego Codelab

Based on Firebase + Android Codelab at **@GDG Global Summit 2016, San Francisco.** <br/><br/>
**LegoTbbTIot** (Lego The Big Bang Theory + IOT) is a sample that shows basic usage of FirebaseArduino to push sensor data to Firebase, and trigger actuators from Firebase through Android App.

![Main](https://raw.githubusercontent.com/andres-vasquez/LegoTbbTIot/master/screenshots/main.png =350x)
![Main scrolled](https://raw.githubusercontent.com/andres-vasquez/LegoTbbTIot/master/screenshots/main_1.png =350x)

# Initial Setup
Please follow the CodeLab instructions: <br/>
Firebase-Arduino Integration Repo:
https://github.com/googlesamples/firebase-arduino/tree/master/examples/FirebaseRoom_ESP8266

# Android Setup
Edit gradle.properties file with your Firebase url, if you want you can use my url: https://iotpanda.firebaseio.com/, Secret: JbYGhXEpIZkh61vYjpFO94YSKravwoShitvM7UDB <br/>
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
##### Please feel free to contribute and/or give me feedback about the project.
###### We can show this App and the Codelab in our GDGs events!!!
<br/>
Regards<br/>
Andrés Vasquez<br/>
GDG La Paz, Bolivia<br/>
andres.vasquez.agramont@gmail.com