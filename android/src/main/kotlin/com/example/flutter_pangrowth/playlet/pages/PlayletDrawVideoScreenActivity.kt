package com.example.flutter_pangrowth.playlet.pages

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bytedance.sdk.djx.DJXRewardAdResult
import com.bytedance.sdk.djx.DJXSdk
import com.bytedance.sdk.djx.IDJXWidget
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaHomeListener
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener
import com.bytedance.sdk.djx.model.DJXDrama
import com.bytedance.sdk.djx.model.DJXDramaDetailConfig
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode
import com.bytedance.sdk.djx.model.DJXDramaUnlockInfo
import com.bytedance.sdk.djx.model.DJXDramaUnlockMethod
import com.bytedance.sdk.djx.params.DJXWidgetDramaHomeParams
import com.example.flutter_pangrowth.PlayletHolder
import com.example.flutter_pangrowth.R
import com.example.flutter_pangrowth.utils.DJXHolder
import com.example.flutter_pangrowth.utils.DefaultDramaUnlockListener

/**
 * @author jack.chen
 */

class PlayletDrawVideoScreenActivity : AppCompatActivity() {

    private val TAG = PlayletDrawVideoScreenActivity::class.java.simpleName

    private var mIDJXWidget: IDJXWidget? = null
    private var mDrawFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_playlet_draw_video_screen)
        if (DJXSdk.isStartSuccess()) {
            initDrawWidget()
            mDrawFragment = mIDJXWidget!!.fragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.playlet_draw_video_frame, mDrawFragment!!)
                .commitAllowingStateLoss()
        }
    }

    private fun initDrawWidget() {
        //短剧详情页配置及监听
        val detailConfig = DJXDramaDetailConfig.obtain(DJXDramaUnlockAdMode.MODE_COMMON, DJXHolder.FREE_SET, DefaultDramaUnlockListener(DJXHolder.LOCK_SET, null))
        mIDJXWidget = DJXSdk.factory().createDramaHome(DJXWidgetDramaHomeParams.obtain(detailConfig)
            .listener(object : IDJXDramaHomeListener() {
                override fun onItemClick(drama: DJXDrama?, map: MutableMap<String, Any>?) {
                    super.onItemClick(drama, map)
                    drama ?: return
                    map ?: return
                    Log.d(TAG, "onItemClick Drama = $drama, CommonParams = $map")
                }
            }))
    }
}

