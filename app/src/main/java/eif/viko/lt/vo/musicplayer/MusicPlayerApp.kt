package eif.viko.lt.vo.musicplayer

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import dagger.hilt.android.HiltAndroidApp
import java.util.*

//cd C:\Users\val\AppData\Local\Android\Sdk\platform-tools .\adb connect 192.168.1.102:XXXXX

@HiltAndroidApp
class MusicPlayerApp : Application() {
    /*private val localizationDelegate = LocalizationApplicationDelegate()

    override fun attachBaseContext(base: Context) {
        localizationDelegate.setDefaultLanguage(base, Locale.ENGLISH)
        super.attachBaseContext(localizationDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localizationDelegate.onConfigurationChanged(this)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(baseContext, super.getResources())
    }*/
}