package com.coderiversdk.auth

import com.coderiversdk.BaseManager
import com.jakewharton.rxrelay2.PublishRelay

/**
Created by yanzs on 2019/1/13
 */
class AuthManager : BaseManager() {
    companion object {
        val INS: AuthManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            AuthManager()
        }
    }
    var loginCount = 0
    var authStatusRelay = PublishRelay.create<ELoginStatus>()

    override fun onSdkInit() {
      //进行离线登录


    }
}

/**
 * 首次录登录
 * UNLogin -> LOGINING -> LOGINED
 * 非首次登录
 * UNLogin -> OFFLINELOGIN -> LOGINED
 */
enum class ELoginStatus {
    UNLogin,
    /**
     * 当用户上一次登录，并且没有手动退出过登录，就认为用户当前是登录状态
     * 执行离线登录，即无需联网登录。
     *
     * */
    LOGINING,
    LOGINFAID,
    OFFLINELOGIN,
    LOGINED,
    LOGOUT
}