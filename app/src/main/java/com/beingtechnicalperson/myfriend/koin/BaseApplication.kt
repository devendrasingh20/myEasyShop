package com.beingtechnicalperson.myfriend.koin

import android.app.Application
import com.beingtechnicalperson.myfriend.koin.apiRepository
import com.beingtechnicalperson.myfriend.koin.fragmentModule
import com.beingtechnicalperson.myfriend.koin.userVMModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BaseApplication)
            modules(listOf(userVMModule, fragmentModule, apiRepository))
        }
    }
}