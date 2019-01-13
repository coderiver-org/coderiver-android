package com.tools

import android.text.TextUtils
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

/**
Created by yanzs on 2019/1/13
 */
class RxBus{
    companion object {
        private val DEFAULT_TAG = "__DEFAULT_TAG"

        private val bus = PublishRelay.create<Event>()

        fun post(evt: Any) {
            post(DEFAULT_TAG, evt)
        }

        fun post(tag: String, evt: Any) {
            try {
                bus.accept(Event(tag, evt))
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun <T> toObservable(eventType: Class<T>): Flowable<T> {
            return toObservable(DEFAULT_TAG, eventType)
        }

        fun <T> toObservable(tag: String, eventType: Class<T>): Flowable<T> {
            return bus.toFlowable(BackpressureStrategy.BUFFER)
                    .filter {
                        TextUtils.equals(tag,it.tag)
                    }.map {
                        it.obj
                    }.flatMap {
                         Flowable.just<Any>(it).ofType(eventType)
                    }

        }

        private class Event internal constructor(internal var tag: String, internal var obj: Any)

    }
}