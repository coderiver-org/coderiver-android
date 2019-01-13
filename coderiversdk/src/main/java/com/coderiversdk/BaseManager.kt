package com.coderiversdk

/**
Created by yanzs on 2019/1/13
 */
interface IManageLifeCycle {

    fun onSdkInit()
    /**
     *
     */
    fun onOfflineLogin()
    fun onLogin(isfirst: Boolean)
    fun onLoginOut()
}
abstract class BaseManager : IManageLifeCycle{
    override fun onSdkInit() {
    }

    override fun onOfflineLogin() {
    }

    override fun onLogin(isfirst: Boolean) {
    }

    override fun onLoginOut() {
    }

}