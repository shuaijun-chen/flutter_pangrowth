package com.example.flutter_pangrowth

import android.app.Activity
import android.app.Application
import android.content.Intent
import com.example.flutter_pangrowth.playlet.pages.PlayletDrawVideoScreenActivity
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/**
 * 短剧使用的插件
 * @author jack.chen
 * @since 2024年4月3日
 */
object PlayletPlugin {
    /**
     * 短视频注册
     */
    fun registerPlayletVideo(context: Application?, call: MethodCall, result: MethodChannel.Result) {
        PlayletHolder.INSTANCE.initSDK(context!!, call, result)
    }

    /**
     * 短剧和短视频混合的页面3
     */
    fun openPlayletDrawVideoPage(activity: Activity?, call: MethodCall) {
        val intent = Intent(activity, PlayletDrawVideoScreenActivity::class.java)
        intent.putExtra("freeCount", (call.argument<Int>("freeCount")))
        intent.putExtra("unlockCountUsingAD", (call.argument<Int>("unlockCountUsingAD")))
        intent.putExtra("isShowTitle", (call.argument<Boolean>("isShowTitle")))
        intent.putExtra("isShowBackButton", (call.argument<Boolean>("isShowBackButton")))
        intent.putExtra("isVideoPlaylet", (call.argument<Boolean>("isVideoPlaylet")))
        intent.putExtra("playletFreeCount", (call.argument<Int>("playletFreeCount")))
        intent.putExtra("topSkitId", (call.argument<Int>("topSkitId")))
        activity?.startActivity(intent)
    }
}