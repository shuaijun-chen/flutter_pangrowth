package com.example.flutter_pangrowth

import android.app.Application
import android.util.Log
import com.bytedance.sdk.djx.DJXSdk
import com.bytedance.sdk.djx.DJXSdkConfig
import com.bytedance.sdk.djx.IDJXWidget
import com.bytedance.sdk.djx.IDJXWidgetFactory
import com.bytedance.sdk.djx.IDJXPrivacyController
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams
import com.bytedance.sdk.dp.DPSdkConfig
import com.bytedance.sdk.dp.IDPPrivacyController
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import com.bytedance.sdk.djx.model.DJXError

/**
 * 短剧处理程序
 * @author jack.chen
 * @since 2024年4月2日
 */
class PlayletHolder private constructor() {
    companion object {
        val INSTANCE: PlayletHolder by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            PlayletHolder()
        }
    }

    fun initSDK(context: Application, call: MethodCall, result: MethodChannel.Result) {
        Log.d("flutter_pangrowth", call.arguments.toString())
        val debug = call.argument<Boolean>("debug") as Boolean
        val config = DJXSdkConfig.Builder()
            .debug(debug)
            // 配置青少年模式，可选
            .privacyController(object : IDJXPrivacyController() {
                override fun isTeenagerMode(): Boolean {
                    return false
                }
            })
            .build()
        //注入路由功能
        DJXSdk.init(context, "pangrowthconfig.json", config)
        Log.d("flutter_pangrowth", " --> DJXSdk.init(context, \"pangrowthconfig.json\", config) --> ok ")

        val listener = DJXSdk.StartListener() { isSuccess: Boolean, message: String, error: DJXError? ->
            Log.d("flutter_pangrowth-PlayletHolder", " --> playlet video 初始化 --> $message")
            // callback?.invoke(isSuccess)
            result.success(isSuccess)
            if (!isSuccess) {
                Log.d("flutter_pangrowth-PlayletHolder", " --> playlet video 初始化 --> ${error?.msg}")
            }
        }
        DJXSdk.start(listener)
    }

    private fun getFactory(): IDJXWidgetFactory {
        //一定要初始化后才能调用，否则会发生异常问题
        return DJXSdk.factory()
    }


    fun buildPlayletDrawWidget(params: DJXWidgetDramaHomeParams): IDJXWidget? {
        //创建draw视频流组件
        return getFactory().createDramaHome(params);
    }
}