package com.opensource.coderiver

import android.app.Application
import com.coderiver.CodeRiverInitHelper

/**
Created by yanzs on 2018/12/26
 */
class CodeRiverApp : Application() {
    override fun onCreate() {
        super.onCreate()
        CodeRiverInitHelper.initWithUI(this)
    }
}