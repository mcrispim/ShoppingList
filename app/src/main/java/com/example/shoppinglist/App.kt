package com.example.shoppinglist

import android.app.Application
import android.content.Context

class App: Application() {
    init { app = this }
    companion object {
        private lateinit var app: App
        fun getAppContext(): Context = app.applicationContext
    }

}