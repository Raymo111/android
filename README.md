# Raymocloud Android app :iphone:

[<img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" 
      alt="Download from Google Play" 
      height="80">](https://play.google.com/store/apps/details?id=li.raymond.raymocloud)

**The Android client for Raymocloud. Forked from [nextcloud/android](https://github.com/Raymo111/raymocloud-android).**

![App screenshots](/doc/Raymocloud_Android_Screenshots.png "App screenshots")

### Getting debug info via logcat :mag:
#### With a computer:
- connect the device via USB
- open command prompt/terminal
- enter `adb logcat | grep "$(adb shell ps | awk '/li.raymond.raymocloud/{print $2}')" > logcatOutput.txt` to save the output to this file

**Note:** You must have [adb](https://developer.android.com/studio/releases/platform-tools.html) installed first!

#### On a device (with root) :wrench:
- open terminal app *(can be enabled in developer options)*
- get root access via "su"
- enter `logcat -d -f /sdcard/logcatOutput.txt`
- you will have to filter the output manually, as above approach is not working on device

or 

- use [CatLog](https://play.google.com/store/apps/details?id=com.nolanlawson.logcat) or [aLogcat](https://play.google.com/store/apps/details?id=org.jtb.alogcat)

**Note:** Your device needs to be rooted for this approach!

## Remarks :scroll:
Yeet
