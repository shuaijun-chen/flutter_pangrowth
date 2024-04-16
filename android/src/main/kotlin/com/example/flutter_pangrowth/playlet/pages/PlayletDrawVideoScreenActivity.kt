package com.example.flutter_pangrowth.playlet.pages

import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bytedance.sdk.djx.DJXSdk
import com.bytedance.sdk.djx.IDJXWidget
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaHomeListener
import com.bytedance.sdk.djx.model.DJXDrama
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams
import com.bytedance.sdk.dp.DPSdk
import com.bytedance.sdk.dp.DPWidgetDrawParams
import com.bytedance.sdk.dp.DPWidgetUserProfileParam
import com.bytedance.sdk.dp.IDPAdListener
import com.bytedance.sdk.dp.IDPDrawListener
import com.bytedance.sdk.dp.IDPWidget
import com.example.flutter_pangrowth.R
import com.example.flutter_pangrowth.VideoHolder
import com.example.flutter_pangrowth.utils.DJXHolder
import com.example.flutter_pangrowth.utils.DefaultDramaUnlockListener
import com.example.flutter_pangrowth.video.pages.DrawVideoFullScreenActivity

/**
 * @author jack.chen
 */

class PlayletDrawVideoScreenActivity : AppCompatActivity() {

    private val tag = PlayletDrawVideoScreenActivity::class.java.simpleName

    private var mIDPWidget: IDPWidget? = null
    private var mIDJXWidget: IDJXWidget? = null
    private var dpWidget: IDPWidget? = null
    private var mDrawFragment: Fragment? = null

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val freeCount = intent.getIntExtra("freeCount", 5)
        val unlockCountUsingAD = intent.getIntExtra("unlockCountUsingAD", 2)
        val isShowTitle = intent.getBooleanExtra("isShowTitle", true)
        val isShowBackButton = intent.getBooleanExtra("isShowBackButton", true)
        val isVideoPlaylet = intent.getBooleanExtra("isVideoPlaylet", true)
        Log.d("PlayletDrawVideo", "$freeCount --> $unlockCountUsingAD -> $isShowTitle -> $isShowBackButton -> $isVideoPlaylet")

        setContentView(R.layout.activity_draw_video_full_screen)

        val detailConfig = DJXDramaDetailConfig
            .obtain(
                DJXDramaUnlockAdMode.MODE_COMMON,
                freeCount,// DJXHolder.FREE_SET
                DefaultDramaUnlockListener(
                    unlockCountUsingAD, // DJXHolder.LOCK_SET,
                    null
                )
            )
        detailConfig.hideTopInfo(false)
            .hideBottomInfo(false)
        //.adListener(dramaListener)// 短剧详情页激励视频回调
        //.listener(dramaListener) // 短剧详情页视频播放回调

        //创建短剧聚合页
        mIDJXWidget = DJXSdk.factory().createDramaHome(
            DJXWidgetDramaHomeParams.obtain(detailConfig)
                .showBackBtn(isShowBackButton)
                .showPageTitle(isShowTitle)
                .listener(object : IDJXDramaHomeListener() {
                    override fun onItemClick(drama: DJXDrama?, map: MutableMap<String, Any>?) {
                        super.onItemClick(drama, map)
                        drama ?: return
                        map ?: return
                        Log.d(tag, "onItemClick Drama = $drama, CommonParams = $map")
                    }
                })
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.draw_video_full_frame, mIDJXWidget!!.fragment)
            .commitAllowingStateLoss()
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

