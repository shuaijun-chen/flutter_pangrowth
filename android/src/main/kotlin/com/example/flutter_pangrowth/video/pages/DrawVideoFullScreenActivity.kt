package com.example.flutter_pangrowth.video.pages

import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bytedance.sdk.dp.DPWidgetDrawParams
import com.bytedance.sdk.dp.IDPAdListener
import com.bytedance.sdk.dp.IDPDrawListener
import com.bytedance.sdk.dp.IDPWidget
import com.example.flutter_pangrowth.R
import com.example.flutter_pangrowth.VideoHolder

/**
 * @Author: gstory
 * @CreateDate: 2021/12/13 4:13 下午
 * @Description: 沉浸式小视频场景展示：全屏样式
 */

class DrawVideoFullScreenActivity : AppCompatActivity() {

    private val tag = DrawVideoFullScreenActivity::class.java.simpleName

    private var mIDPWidget: IDPWidget? = null
    private var mDrawFragment: Fragment? = null

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_draw_video_full_screen)
        initDrawWidget()
        mDrawFragment = mIDPWidget!!.fragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.draw_video_full_frame, mDrawFragment!!)
                .commitAllowingStateLoss()
    }

    private fun initDrawWidget() {
        mIDPWidget = VideoHolder.INSTANCE.buildDrawWidget(DPWidgetDrawParams.obtain()
//                .liveAdCodeId("946413486").liveNativeAdCodeId("946413492")
                .adOffset(0) //单位 dp，为 0 时可以不设置
                .hideClose(false, null)
                .listener(object : IDPDrawListener() {
                    override fun onDPRefreshFinish() {
                        Log.d(tag,"onDPRefreshFinish")
                    }

                    override fun onDPPageChange(position: Int) {
                        Log.d(tag,"onDPPageChange: $position")
                    }

                    override fun onDPPageChange(position: Int, map: Map<String, Any>) {
                        if (map == null) {
                            return
                        }
                        Log.d(tag,"onDPPageChange: $position, map = $map")
                    }

                    override fun onDPVideoPlay(map: Map<String, Any>) {
                        Log.d(tag,"onDPVideoPlay map = $map")
                    }

                    override fun onDPVideoOver(map: Map<String, Any>) {
                        Log.d(tag,"onDPVideoOver map = $map")
                    }

                    override fun onDPVideoCompletion(map: Map<String, Any>) {
                        Log.d(tag,"onDPVideoCompletion map = $map")
                    }

                    override fun onDPClose() {
                        Log.d(tag,"onDPClose")
                    }

                    override fun onDPReportResult(isSucceed: Boolean) {
                        Log.d(tag,"onDPReportResult isSucceed = $isSucceed")
                    }

                    override fun onDPReportResult(isSucceed: Boolean, map: Map<String, Any>) {
                        Log.d(tag,"onDPReportResult isSucceed = $isSucceed, map = $map")
                    }

                    override fun onDPRequestStart(@Nullable map: Map<String, Any>?) {
                        Log.d(tag,"onDPRequestStart")
                    }

                    override fun onDPRequestSuccess(list: List<Map<String, Any>>) {
                        if (list == null) {
                            return
                        }
                        for (i in list.indices) {
                            Log.d(tag,"onDPRequestSuccess i = " + i + ", map = " + list[i].toString())
                        }
                    }

                    override fun onDPRequestFail(code: Int, msg: String, @Nullable map: Map<String, Any>?) {
                        if (map == null) {
                            Log.d(tag,"onDPRequestFail code = $code, msg = $msg")
                            return
                        }
                        Log.d(tag,"onDPRequestFail  code = $code, msg = $msg, map = $map")
                    }

                    override fun onDPClickAuthorName(map: Map<String, Any>) {
                        Log.d(tag,"onDPClickAuthorName map = $map")
                    }

                    override fun onDPClickAvatar(map: Map<String, Any>) {
                        Log.d(tag,"onDPClickAvatar map = $map")
                    }

                    override fun onDPClickComment(map: Map<String, Any>) {
                        Log.d(tag,"onDPClickComment map = $map")
                    }

                    override fun onDPClickLike(isLike: Boolean, map: Map<String, Any>) {
                        Log.d(tag,"onDPClickLike isLike = $isLike, map = $map")
                    }

                    override fun onDPVideoPause(map: Map<String, Any>) {
                        Log.d(tag,"onDPVideoPause map = $map")
                    }

                    override fun onDPVideoContinue(map: Map<String, Any>) {
                        Log.d(tag,"onDPVideoContinue map = $map")
                    }
                }).adListener(object : IDPAdListener() {
                    override fun onDPAdRequest(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdRequest map =  $map")
                    }

                    override fun onDPAdRequestSuccess(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdRequestSuccess map = $map")
                    }

                    override fun onDPAdRequestFail(code: Int, msg: String, map: Map<String, Any>) {
                        Log.d(tag,"onDPAdRequestFail map = $map")
                    }

                    override fun onDPAdFillFail(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdFillFail map = $map")
                    }

                    override fun onDPAdShow(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdShow map = $map")
                    }

                    override fun onDPAdPlayStart(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdPlayStart map = $map")
                    }

                    override fun onDPAdPlayPause(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdPlayPause map = $map")
                    }

                    override fun onDPAdPlayContinue(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdPlayContinue map = $map")
                    }

                    override fun onDPAdPlayComplete(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdPlayComplete map = $map")
                    }

                    override fun onDPAdClicked(map: Map<String, Any>) {
                        Log.d(tag,"onDPAdClicked map = $map")
                    }
                }))
    }

    override fun onResume() {
        super.onResume()
        mIDPWidget?.fragment?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mIDPWidget?.fragment?.onPause()
    }


    override fun onDestroy() {
        super.onDestroy()
        mIDPWidget?.destroy()
    }
}