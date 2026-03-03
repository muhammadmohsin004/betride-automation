# BeetRide Test Automation - Complete Setup Guide

> Step-by-step guide to set up this project on a new laptop with a new mobile phone.

---

## Table of Contents

- [Prerequisites](#prerequisites)
- [Step 1: Install Java JDK](#step-1-install-java-jdk)
- [Step 2: Install Apache Maven](#step-2-install-apache-maven)
- [Step 3: Install Android SDK](#step-3-install-android-sdk-via-android-studio)
- [Step 4: Install Node.js & Appium](#step-4-install-nodejs--appium)
- [Step 5: Install IDE](#step-5-install-ide)
- [Step 6: Clone & Build the Project](#step-6-clone--build-the-project)
- [Step 7: Set Up Your New Phone](#step-7-set-up-your-new-phone)
- [Step 8: Update Configuration](#step-8-update-configuration-for-your-new-phone)
- [Step 9: Place the APK](#step-9-place-the-apk)
- [Step 10: Start Appium Server](#step-10-start-appium-server)
- [Step 11: Run the Tests](#step-11-run-the-tests)
- [Step 12: View Test Reports](#step-12-view-test-reports)
- [Environment Variables Summary](#environment-variables-summary)
- [Troubleshooting](#troubleshooting)

---

## Prerequisites

| Tool             | Version     | Purpose                        |
| ---------------- | ----------- | ------------------------------ |
| Java JDK         | 8 or higher | Core language runtime          |
| Apache Maven     | 3.x         | Build & dependency management  |
| Android Studio   | Latest      | Android SDK & ADB              |
| Node.js          | LTS         | Required for Appium            |
| Appium           | 2.x         | Mobile automation server       |
| IntelliJ IDEA    | Community+  | IDE for running/editing tests  |

---

## Step 1: Install Java JDK

1. Download JDK 8+ from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK.
2. Install and note the installation path.
3. Set the `JAVA_HOME` environment variable:
   ```
   JAVA_HOME = C:\Program Files\Java\jdk1.8.0_xxx
   ```
4. Add `%JAVA_HOME%\bin` to your system `PATH`.
5. Verify installation:
   ```bash
   java -version
   ```

---

## Step 2: Install Apache Maven

1. Download from https://maven.apache.org/download.cgi
2. Extract to a folder, e.g., `C:\apache-maven-3.9.x`
3. Set the `MAVEN_HOME` environment variable:
   ```
   MAVEN_HOME = C:\apache-maven-3.9.x
   ```
4. Add `%MAVEN_HOME%\bin` to your system `PATH`.
5. Verify installation:
   ```bash
   mvn -version
   ```

---

## Step 3: Install Android SDK (via Android Studio)

1. Download Android Studio from https://developer.android.com/studio
2. Install and open it.
3. Go to **SDK Manager** and install:
   - Android SDK Platform (API 31 or 33)
   - Android SDK Build-Tools
   - Android SDK Platform-Tools (provides `adb`)
4. Set the `ANDROID_HOME` environment variable:
   ```
   ANDROID_HOME = C:\Users\<YourUser>\AppData\Local\Android\Sdk
   ```
5. Add these to your system `PATH`:
   ```
   %ANDROID_HOME%\platform-tools
   %ANDROID_HOME%\tools
   ```
6. Verify installation:
   ```bash
   adb version
   ```

---

## Step 4: Install Node.js & Appium

### Node.js
1. Download LTS version from https://nodejs.org
2. Install it.
3. Verify:
   ```bash
   node -v
   npm -v
   ```

### Appium
1. Install Appium globally:
   ```bash
   npm install -g appium
   ```
2. Install the UiAutomator2 driver:
   ```bash
   appium driver install uiautomator2
   ```
3. Verify:
   ```bash
   appium -v
   ```

---

## Step 5: Install IDE

1. Download [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/).
2. Install it.
3. Install the following plugins from **Settings > Plugins**:
   - **Maven** (usually bundled)
   - **Cucumber for Java**
   - **Gherkin**

---

## Step 6: Clone & Build the Project

### Clone the repository:
```bash
git clone <your-repo-url>
cd BeetRide
```
Or copy the entire project folder to your new laptop.

### Install all Maven dependencies:
```bash
mvn clean install -DskipTests
```
This downloads Cucumber, Appium Java Client, Allure, and all other dependencies.

---

## Step 7: Set Up Your New Phone

### A. Enable Developer Options
1. Go to **Settings > About Phone**.
2. Tap **Build Number** 7 times until you see *"You are now a developer"*.

### B. Enable USB Debugging
1. Go to **Settings > Developer Options**.
2. Turn **ON** the following:
   - USB Debugging
   - Install via USB *(if available)*
   - USB debugging (Security settings) *(Xiaomi/MIUI devices)*

### C. Connect Your Phone
1. Connect the phone to your laptop via USB cable.
2. A popup will appear on the phone: **"Allow USB debugging?"** — Tap **Allow**.

### D. Get Your Device UDID
Run this command in terminal:
```bash
adb devices
```
Output example:
```
List of devices attached
ABC123XYZ456    device
```
**Copy the device ID** (e.g., `ABC123XYZ456`) — this is your UDID.

### E. Get Your Android Version
Go to **Settings > About Phone > Android Version** on your phone and note it (e.g., `13`, `14`, `15`).

---

## Step 8: Update Configuration for Your New Phone

Open the file `src/test/java/config/androidconfig.properties` and update:

```properties
platformName=Android
platformVersion=<YOUR_ANDROID_VERSION>
automationName=UiAutomator2

deviceName=Physical Device
udid=<YOUR_NEW_UDID>

androidapk=app-release.apk
noReset=true
fullReset=false
appPackage=com.bettride.driver
appActivity=com.bettride.driver.MainActivity
```

**Replace:**
| Placeholder              | Where to find it                         |
| ------------------------ | ---------------------------------------- |
| `<YOUR_ANDROID_VERSION>` | Settings > About Phone > Android Version |
| `<YOUR_NEW_UDID>`        | Output of `adb devices`                  |

---

## Step 9: Place the APK

Make sure the BeetRide Driver APK exists at:
```
apk/app-release.apk
```
If the file is missing (large files may not be in Git), get the latest APK from your team and place it in the `apk/` folder.

---

## Step 10: Start Appium Server

Open a **separate terminal** and run:
```bash
appium --port 4723
```

Keep this terminal open and running. You should see:
```
[Appium] Welcome to Appium v2.x.x
[Appium] Appium REST http interface listener started on 0.0.0.0:4723
```

---

## Step 11: Run the Tests

Open **another terminal** in the project root directory and run:

```bash
mvn clean test -Dtest=MobileRunner
```

This will:
1. Install the APK on your phone (if not already installed)
2. Launch the BeetRide Driver app
3. Execute the test scenarios tagged in `MobileRunner.java`

### Run specific test tags:
To run a specific test case, update the `tags` in `src/test/java/runner/MobileRunner.java`:
```java
tags = "@TC-001"   // runs only TC-001
tags = "@TC-001 or @TC-002"   // runs TC-001 and TC-002
```
Then run:
```bash
mvn clean test -Dtest=MobileRunner
```

---

## Step 12: View Test Reports

### Cucumber HTML Report
Open this file in your browser after tests finish:
```
target/cucumber-reports.html
```

### Allure Report (Detailed)
1. Install Allure CLI:
   ```bash
   npm install -g allure-commandline
   ```
2. Generate and open the report:
   ```bash
   allure serve allure-results
   ```

---

## Environment Variables Summary

Make sure all of these are set on your new laptop:

| Variable       | Value                                              |
| -------------- | -------------------------------------------------- |
| `JAVA_HOME`    | `C:\Program Files\Java\jdk-<version>`              |
| `MAVEN_HOME`   | `C:\apache-maven-<version>`                        |
| `ANDROID_HOME` | `C:\Users\<User>\AppData\Local\Android\Sdk`        |
| `PATH`         | Append `%JAVA_HOME%\bin`                           |
| `PATH`         | Append `%MAVEN_HOME%\bin`                          |
| `PATH`         | Append `%ANDROID_HOME%\platform-tools`             |

### How to set environment variables on Windows:
1. Press `Win + R`, type `sysdm.cpl`, press Enter.
2. Go to **Advanced** tab > **Environment Variables**.
3. Under **System Variables**, click **New** to add each variable.
4. Find `Path` in the list, click **Edit**, and add the paths listed above.
5. Click **OK** on all dialogs.
6. **Restart your terminal** for changes to take effect.

---

## Troubleshooting

| Problem                              | Solution                                                                                  |
| ------------------------------------ | ----------------------------------------------------------------------------------------- |
| `adb devices` shows empty            | Re-enable USB debugging, try a different USB cable, install your phone's USB drivers       |
| `adb devices` shows "unauthorized"   | Tap "Allow" on the phone popup. Revoke & re-allow USB debugging in Developer Options       |
| Appium can't find device             | Make sure `adb devices` shows your phone first, then restart Appium                        |
| `JAVA_HOME` not found                | Verify the env variable points to JDK folder (not JRE)                                    |
| `mvn` command not found              | Verify Maven is installed and `%MAVEN_HOME%\bin` is in PATH                                |
| Maven build fails                    | Run `mvn clean install -DskipTests` and check Java version matches JDK 8+                 |
| App not installing on phone          | Enable "Install via USB" in Developer Options                                              |
| UiAutomator2 crashes                 | Run `adb uninstall io.appium.uiautomator2.server` and retry                               |
| Wrong platform version error         | Make sure `platformVersion` in config matches your actual Android version                  |
| Appium port already in use           | Kill existing Appium process or change port: `appium --port 4724`                          |
| Tests pass but app doesn't launch    | Check `appPackage` and `appActivity` values are correct in config                          |

---

## Quick Start Checklist

Use this checklist when setting up on a new machine:

- [ ] Java JDK installed → `java -version` works
- [ ] Maven installed → `mvn -version` works
- [ ] Android Studio + SDK installed → `adb version` works
- [ ] Node.js installed → `node -v` works
- [ ] Appium installed → `appium -v` works
- [ ] UiAutomator2 driver installed → `appium driver list` shows it
- [ ] Project cloned/copied
- [ ] `mvn clean install -DskipTests` completed successfully
- [ ] Phone connected → `adb devices` shows device as "device"
- [ ] `androidconfig.properties` updated with new UDID and Android version
- [ ] APK exists at `apk/app-release.apk`
- [ ] Appium server running on port 4723
- [ ] Tests run successfully → `mvn clean test -Dtest=MobileRunner`
