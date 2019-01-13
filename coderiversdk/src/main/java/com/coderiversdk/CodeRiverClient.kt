package com.coderiversdk

import android.annotation.SuppressLint
import android.app.Application
import com.coderiversdk.auth.AuthManager
import com.coderiversdk.auth.ELoginStatus
import com.coderiversdk.exception.InitializeException
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.disposables.CompositeDisposable

/**
Created by yanzs on 2018/12/24
 */
class CodeRiverClient {

    companion object {
        var sdkInitRelay = BehaviorRelay.create<ESdkStatus>()
        internal var mDisposable = CompositeDisposable()
        private var managers = ArrayList<BaseManager>()
        lateinit var application: Application

        @Synchronized
        fun init(app: Application) {

            this.application = app
            sdkInitRelay.value?.let {
                //防止sdk重复被初始化
                if (it != ESdkStatus.UNINITIALIZED) {
                    throw InitializeException("Please do not repeat initialization")
                }
            }
            //标识sdk正在初始化
            sdkInitRelay.accept(ESdkStatus.INITIALIZING)
            initManager()
            registerEvent()
            sdkInitRelay.accept(ESdkStatus.INITIALIZE)
        }

        @SuppressLint("CheckResult")
        private fun registerEvent(){
            //manager的生命周期事件在这里发送
            mDisposable.add(sdkInitRelay.subscribe {
               when(it){
                   ESdkStatus.INITIALIZE -> managers.forEach { it.onSdkInit() }
               }
            })
            mDisposable.add(AuthManager.INS.authStatusRelay.subscribe({ it ->
                when(it){
                    ELoginStatus.OFFLINELOGIN -> managers.forEach { it.onOfflineLogin() }
                    ELoginStatus.LOGINED -> managers.forEach { it.onLogin(AuthManager.INS.loginCount == 1) }
                    ELoginStatus.LOGOUT -> managers.forEach { it.onLoginOut() }
                }
            },{
                it.printStackTrace()
            }))

        }
        private fun initManager(){
            managers.add(AuthManager.INS)
        }

    }


}
enum class ESdkStatus {
    //未初始化
    UNINITIALIZED,
    //初始化中
    INITIALIZING,
    INITIALIZE
}