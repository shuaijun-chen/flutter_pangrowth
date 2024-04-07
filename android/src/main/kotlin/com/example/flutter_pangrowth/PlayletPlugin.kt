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
    fun registerDrawVideo(context: Application?, call: MethodCall, result: MethodChannel.Result) {
        PlayletHolder.INSTANCE.initSDK(context!!, call, result)
    }

    /**
     * 短剧和短视频混合的页面3
     */
    fun openPlayletDrawVideoPage(activity: Activity?, call: MethodCall) {
        activity?.startActivity(Intent(activity, PlayletDrawVideoScreenActivity::class.java))
    }
}