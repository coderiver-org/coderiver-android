package com.coderiver

import android.content.Context
import com.coderiver.home.HomeActivity
import com.coderiversdk.CodeRiverClient

/**
Created by yanzs on 2018/12/24
 */

class CodeRiverInitHelper{
    companion object {
        /**
         * 与ui相关需要全局注册的事件
         */
       fun initWithUI(context: Context){
           CodeRiverClient.init(context)
       }
        fun goHome(context: Context){
           HomeActivity.launch(context)
        }
    }

}