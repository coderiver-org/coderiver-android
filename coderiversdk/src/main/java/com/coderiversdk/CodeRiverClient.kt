package com.coderiversdk

import android.content.Context
import com.coderiversdk.exception.InitializeException
import com.jakewharton.rxrelay2.BehaviorRelay

/**
Created by yanzs on 2018/12/24
 */
class CodeRiverClient {

    private lateinit var context : Context
    var sdkInitRelay = BehaviorRelay.create<Int>()
    companion object {
        val instance: CodeRiverClient by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            CodeRiverClient()
        }
        var isInit = false

        fun init(context: Context) {
            if(isInit){
                throw InitializeException("Please do not repeat initialization")
            }
            instance.init(context)
            isInit = true
        }
    }
    private fun checkSdkInt(){
        if(!isInit){
          throw InitializeException("Please initialize sdk")
        }
    }
    fun init(context: Context) {
       this.context = context

    }



}