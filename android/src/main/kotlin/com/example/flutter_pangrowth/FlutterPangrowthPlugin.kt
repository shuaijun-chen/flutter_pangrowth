package com.example.flutter_pangrowth

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.NonNull
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result


/** FlutterPangrowthPlugin */
class FlutterPangrowthPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    private var applicationContext: Context? = null
    private var mActivity: Activity? = null
    private lateinit var channel: MethodChannel
    private var mFlutterPluginBinding: FlutterPlugin.FlutterPluginBinding? = null

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        mActivity = binding.activity
        Log.e("FlutterPangrowthPlugin","onAttachedToActivity")
        FlutterPangrowthViewPlugin.registerWith(mFlutterPluginBinding!!, mActivity!!)
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        mActivity = binding.activity
        Log.e("FlutterPangrowthPlugin","onReattachedToActivityForConfigChanges")
    }

    override fun onDetachedFromActivityForConfigChanges() {
        mActivity = null
        Log.e("FlutterPangrowthPlugin","onDetachedFromActivityForConfigChanges")
    }

    override fun onDetachedFromActivity() {
        mActivity = null
        Log.e("FlutterPangrowthPlugin","onDetachedFromActivity")
    }

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "flutter_pangrowth")
        channel.setMethodCallHandler(this)
        applicationContext = flutterPluginBinding.applicationContext
        mFlutterPluginBinding = flutterPluginBinding
    }

    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "registerVideo") { // 视频初始化初始化
            VideoPlugin.registerVideo(applicationContext as Application?, call, result)
            //打开沉浸式小视频 全屏样式
        } else if (call.method == "openDrawVideoFull") {
            VideoPlugin.openDrawVideoFull(mActivity, call)
            result.success(true)
            //打开宫格小视频 全屏样式
        } else if (call.method == "openGridVideo") {
            VideoPlugin.openGridVideo(mActivity, call)
            result.success(true)
            //打开新闻 多列表
        } else if (call.method == "openNewsTabs") {
            VideoPlugin.openNewsTabs(mActivity, call)
            result.success(true)
            //打开新闻 单列表
        } else if (call.method == "openNewsTabOne") {
            VideoPlugin.openNewsTabOne(mActivity, call)
            result.success(true)
            //打开个人主页
        } else if (call.method == "openUserCenter") {
            VideoPlugin.openUserCenter(mActivity, call)
            result.success(true)
        } else if (call.method == "registerPlayletVideo") {
            PlayletPlugin.registerPlayletVideo(applicationContext as Application?, call, result)
        } else if (call.method == "openPlayletDrawVideoPage") { // 打开短剧和短视频混排的页面
            PlayletPlugin.openPlayletDrawVideoPage(mActivity, call)
            result.success(true)
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }
}
