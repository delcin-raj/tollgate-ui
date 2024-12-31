# Tauri + Vanilla

This template should help get you started developing with Tauri in vanilla HTML, CSS and Javascript.

## Android env variables

My config, adjust according to your installation.

```bash
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools
export NDK_HOME=$ANDROID_HOME/ndk/28.0.12674087/
```

To avoid openssl error in ubuntu

```bash
sudo apt-get install pkg-config libssl-dev
sudo ln -s /usr/include/x86_64-linux-gnu/openssl/opensslconf.h /usr/include/openssl/opensslconf.h
sudo ln -s /usr/include/x86_64-linux-gnu/openssl/configuration.h /usr/include/openssl/configuration.h
```

It is also necessary to crate/configure `~/.local/share/applications/androidstudio.desktop` file.
Copy paste/edit the following into the above file.

```bash
[Desktop Entry]
Version=1.0
Type=Application
Name=Android Studio
Exec="/usr/local/android-studio/bin/studio.sh" %f
Icon=/usr/local/android-studio/bin/studio.png
Categories=Development;IDE;
Terminal=false
StartupNotify=true
StartupWMClass=android-studio
```

Using the above config only, tauri opens the android dev environment.

## Test and run the app

Execute `./run.sh`
