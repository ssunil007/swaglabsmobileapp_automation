Mobile Automation Framework
=======================

## Testing Mobile App using Open Source Tools

## Objective

Intent of this proect is to illustrate how wide range of **Open Source Tools** can be used to test mobile applications both **Android** or **iOS** and parallelise the test suite with multiple connected devices.

## Snapshot

This is a simple **Maven** project designed as a hybrid framwork with combination of Page Object Model and Data Driven Framework and is created using various **Open Source Tools** such as

* Appium - Open Source Tool for cross platform testing
* Selenium WebDriver - WebDriver API used to to perform mobile gestures
* Maven - Dependency Management
* TestNG - Test Annotation to organize test suite and parameterization

## Installations

1. Download and Install JDK8 from the below link

    [https://adoptopenjdk.net/]

2. Download and Install Android Studio from the below link
  [https://developer.android.com/studio?gclid=CjwKCAjww-CGBhALEiwAQzWxOhsAUZlMWuodNM3WgYZUY82q1QILJoGWT2AW5ESns35NwSgD60pYfxoCjkwQAvD_BwE&gclsrc=aw.ds]

3. Download and Install Appium Desktop from the below link 

    [https://github.com/appium/appium-desktop/releases/]

>Note: Appium version above  1.17.0 is preferrable

4. Setting Envirnoment variables JAVA_HOME & ANDRIOD_HOME

5. Enabling Touch / Face ID on Android emulators

>NOTE:
The implementation of Touch/FaceID in this application supports the user’s biometrics based on the insecure store of the device. It is not using the keystore which normally should be used when implementing Touch/FaceID and secure login. The reason for this is that Sauce Labs is not mocking the keystore on a real device for supporting Touch/FaceID due to security reasons.
Testing Touch/FaceID which is using the keystore on our real devices is therefore not supported.

To enable this on Android emulators you need to do the following (when you have an emulator that supports this):

* Open an emulator

* Activate Screenlock from Settings -> Security

* Go to Fingerprint to add new fingerprint

* When prompt to place your finger on the scanner, emulate the fingerprint using adb command.

```adb -e emu finger touch <finger_id>

#Example
adb -e emu finger touch 1234
```
* You should see fingerprint detected message. That’s it. Done.

>NOTE:
The automation script uses 1234 as the Fingerprint, so when you add the fingerprint through ADB, please use 1234

>NOTE:
Make sure you remember the fingerprint number you selected, that needs to be used to select a (non)matching finger print!

## Steps for Execution

1. Clone  the repository into any IDE ( Eclipse or IntelliJ )

2. Open **Android Studio**, configure an _emulator_ in AVD Manager and launch it

3. Launch the **Appium Deskop** and start the server

4. Build the Project using **Maven** to update the dependencies

5. Run the below command from project directory to start execution

``` mvn clean test -Drelease.arguments=testng_android1.xml  -Dplatform=Android -DdeviceName=Android -DplatformVersion=10.0 -DappPath=/src/test/resources/AppFile/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk -DlogFilePath=/src/test/resources/Screenshots/
```


