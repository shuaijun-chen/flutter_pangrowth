package com.example.flutter_pangrowth.utils

import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.bytedance.sdk.djx.interfaces.listener.IDJXAdListener
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaCardListener
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaHomeListener
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaListener
import com.bytedance.sdk.djx.interfaces.listener.IDJXDramaUnlockListener
import com.bytedance.sdk.djx.interfaces.listener.IDJXDrawListener
import com.bytedance.sdk.djx.model.DJXDrama
import com.bytedance.sdk.djx.model.DJXDramaUnlockInfo
import com.bytedance.sdk.djx.model.DJXDramaUnlockMethod

class DefaultDramaListener(private val listener: IDJXDramaListener? = null) : IDJXDramaListener() {
    override fun onDJXSeekTo(position: Int, time: Long) {
        super.onDJXSeekTo(position, time)
        //Log.d("onDJXSeekTo: $position, $time")
        listener?.onDJXSeekTo(position, time)
    }

    override fun onDJXPageChange(position: Int, map: MutableMap<String, Any>?) {
        super.onDJXPageChange(position, map)
        //Log.d("onDJXPageChange: $position, $map")
        listener?.onDJXPageChange(position, map)
    }

    override fun onDJXVideoPlay(map: MutableMap<String, Any>?) {
        super.onDJXVideoPlay(map)
        //Log.d("onDJXVideoPlay: $map")
        listener?.onDJXVideoPlay(map)
    }

    override fun onDJXVideoPause(map: MutableMap<String, Any>?) {
        super.onDJXVideoPause(map)
        //Log.d("onDJXVideoPause: $map")
        listener?.onDJXVideoPause(map)
    }

    override fun onDJXVideoContinue(map: MutableMap<String, Any>?) {
        super.onDJXVideoContinue(map)
        //Log.d("onDJXVideoContinue: $map")
        listener?.onDJXVideoContinue(map)
    }

    override fun onDJXVideoCompletion(map: MutableMap<String, Any>?) {
        super.onDJXVideoCompletion(map)
        //Log.d("onDJXVideoCompletion: $map")
        listener?.onDJXVideoCompletion(map)
    }

    override fun onDJXVideoOver(map: MutableMap<String, Any>?) {
        super.onDJXVideoOver(map)
        //Log.d("onDJXVideoOver: $map")
        listener?.onDJXVideoOver(map)
    }

    override fun onDJXClose() {
        super.onDJXClose()
        //Log.d("onDJXClose: ")
        listener?.onDJXClose()
    }

    override fun onDJXRequestStart(map: MutableMap<String, Any>?) {
        super.onDJXRequestStart(map)
        //Log.d("onDJXRequestStart: $map")
        listener?.onDJXRequestStart(map)
    }

    override fun onDJXRequestFail(code: Int, msg: String?, map: MutableMap<String, Any>?) {
        super.onDJXRequestFail(code, msg, map)
        //Log.d("onDJXRequestFail: $code, $msg, $map")
        listener?.onDJXRequestFail(code, msg, map)
    }

    override fun onDJXRequestSuccess(list: MutableList<MutableMap<String, Any>>?) {
        super.onDJXRequestSuccess(list)
        //Log.d("onDJXRequestSuccess: $list")
        listener?.onDJXRequestSuccess(list)
    }

    override fun onDramaSwitch(map: MutableMap<String, Any>?) {
        super.onDramaSwitch(map)
        //Log.d("onDramaSwitch: $map")
        listener?.onDramaSwitch(map)
    }

    override fun onDramaGalleryShow(map: MutableMap<String, Any>?) {
        super.onDramaGalleryShow(map)
        //Log.d("onDramaGalleryShow: $map")
        listener?.onDramaGalleryShow(map)
    }

    override fun onDramaGalleryClick(map: MutableMap<String, Any>?) {
        super.onDramaGalleryClick(map)
        //Log.d("onDramaGalleryClick: $map")
        listener?.onDramaGalleryClick(map)
    }

    override fun onRewardDialogShow(map: MutableMap<String, Any>?) {
        super.onRewardDialogShow(map)
        //Log.d("onRewardDialogShow: $map")
        listener?.onRewardDialogShow(map)
    }

    override fun onUnlockDialogAction(action: String?, map: MutableMap<String, Any>?) {
        super.onUnlockDialogAction(action, map)
        //Log.d("onUnlockDialogAction: $action, $map")
        listener?.onUnlockDialogAction(action, map)
    }

    override fun onDurationChange(current: Long) {
        super.onDurationChange(current)
        //Log.d("onDurationChange: $current")
        listener?.onDurationChange(current)
    }

    override fun createCustomView(container: ViewGroup?, map: MutableMap<String, Any>?): View? {
        //Log.d("createCustomView: $map")
        return listener?.createCustomView(container, map) ?: super.createCustomView(container, map)
    }
}

class DefaultDrawListener(private val listener: IDJXDrawListener? = null) : IDJXDrawListener() {
    override fun onDJXRefreshFinish() {
        super.onDJXRefreshFinish()
        //Log.d("onDJXRefreshFinish: ")
        listener?.onDJXRefreshFinish()
    }

    override fun onDJXSeekTo(position: Int, time: Long) {
        super.onDJXSeekTo(position, time)
        //Log.d("onDJXSeekTo: $position, $time")
        listener?.onDJXSeekTo(position, time)
    }

    override fun onDJXPageChange(position: Int, map: MutableMap<String, Any>?) {
        super.onDJXPageChange(position, map)
        //Log.d("onDJXPageChange: $position, $map")
        listener?.onDJXPageChange(position, map)
    }

    override fun onDJXVideoPlay(map: MutableMap<String, Any>?) {
        super.onDJXVideoPlay(map)
        //Log.d("onDJXVideoPlay: $map")
        listener?.onDJXVideoPlay(map)
    }

    override fun onDJXVideoPause(map: MutableMap<String, Any>?) {
        super.onDJXVideoPause(map)
        //Log.d("onDJXVideoPause: $map")
        listener?.onDJXVideoPause(map)
    }

    override fun onDJXVideoContinue(map: MutableMap<String, Any>?) {
        super.onDJXVideoContinue(map)
        //Log.d("onDJXVideoContinue: $map")
        listener?.onDJXVideoContinue(map)
    }

    override fun onDJXVideoCompletion(map: MutableMap<String, Any>?) {
        super.onDJXVideoCompletion(map)
        //Log.d("onDJXVideoCompletion: $map")
        listener?.onDJXVideoCompletion(map)
    }

    override fun onDJXVideoOver(map: MutableMap<String, Any>?) {
        super.onDJXVideoOver(map)
        //Log.d("onDJXVideoOver: $map")
        listener?.onDJXVideoOver(map)
    }

    override fun onDJXClose() {
        super.onDJXClose()
        //Log.d("onDJXClose: ")
        listener?.onDJXClose()
    }

    override fun onDJXReportResult(isSucceed: Boolean, map: MutableMap<String, Any>?) {
        super.onDJXReportResult(isSucceed, map)
        //Log.d("onDJXReportResult: $isSucceed, $map")
        listener?.onDJXReportResult(isSucceed, map)
    }

    override fun onDJXRequestStart(map: MutableMap<String, Any>?) {
        super.onDJXRequestStart(map)
        //Log.d("onDJXRequestStart: $map")
        listener?.onDJXRequestStart(map)
    }

    override fun onDJXRequestFail(code: Int, msg: String?, map: MutableMap<String, Any>?) {
        super.onDJXRequestFail(code, msg, map)
        //Log.d("onDJXRequestFail: $code, $msg, $map")
        listener?.onDJXRequestFail(code, msg, map)
    }

    override fun onDJXRequestSuccess(list: MutableList<MutableMap<String, Any>>?) {
        super.onDJXRequestSuccess(list)
        //Log.d("onDJXRequestSuccess: $list")
        listener?.onDJXRequestSuccess(list)
    }

    override fun onChannelTabChange(channel: Int) {
        super.onChannelTabChange(channel)
        //Log.d("onChannelTabChange: $channel")
        listener?.onChannelTabChange(channel)
    }

    override fun onDurationChange(current: Long) {
        super.onDurationChange(current)
        //Log.d("onDurationChange: $current")
        listener?.onDurationChange(current)
    }

    override fun createCustomView(container: ViewGroup?, map: MutableMap<String, Any>?): View? {
        //Log.d("createCustomView: $map")
        return listener?.createCustomView(container, map) ?: super.createCustomView(container, map)
    }
}

class DefaultAdListener(private val listener: IDJXAdListener? = null) : IDJXAdListener() {
    override fun onDJXAdRequest(map: MutableMap<String, Any>?) {
        super.onDJXAdRequest(map)
        //Log.d("onDJXAdRequest: $map")
        listener?.onDJXAdRequest(map)
    }

    override fun onDJXAdRequestSuccess(map: MutableMap<String, Any>?) {
        super.onDJXAdRequestSuccess(map)
        //Log.d("onDJXAdRequestSuccess: $map")
        listener?.onDJXAdRequestSuccess(map)
    }

    override fun onDJXAdRequestFail(code: Int, msg: String?, map: MutableMap<String, Any>?) {
        super.onDJXAdRequestFail(code, msg, map)
        //Log.d("onDJXAdRequestFail: $code, $msg, $map")
        listener?.onDJXAdRequestFail(code, msg, map)
    }

    override fun onDJXAdFillFail(map: MutableMap<String, Any>?) {
        super.onDJXAdFillFail(map)
        //Log.d("onDJXAdFillFail: $map")
        listener?.onDJXAdFillFail(map)
    }

    override fun onDJXAdShow(map: MutableMap<String, Any>?) {
        super.onDJXAdShow(map)
        //Log.d("onDJXAdShow: $map")
        listener?.onDJXAdShow(map)
    }

    override fun onDJXAdPlayStart(map: MutableMap<String, Any>?) {
        super.onDJXAdPlayStart(map)
        //Log.d("onDJXAdPlayStart: $map")
        listener?.onDJXAdPlayStart(map)
    }

    override fun onDJXAdPlayPause(map: MutableMap<String, Any>?) {
        super.onDJXAdPlayPause(map)
        //Log.d("onDJXAdPlayPause: $map")
        listener?.onDJXAdPlayPause(map)
    }

    override fun onDJXAdPlayContinue(map: MutableMap<String, Any>?) {
        super.onDJXAdPlayContinue(map)
        //Log.d("onDJXAdPlayContinue: $map")
        listener?.onDJXAdPlayContinue(map)
    }

    override fun onDJXAdPlayComplete(map: MutableMap<String, Any>?) {
        super.onDJXAdPlayComplete(map)
        //Log.d("onDJXAdPlayComplete: $map")
        listener?.onDJXAdPlayComplete(map)
    }

    override fun onDJXAdClicked(map: MutableMap<String, Any>?) {
        super.onDJXAdClicked(map)
        //Log.d("onDJXAdClicked: $map")
        listener?.onDJXAdClicked(map)
    }

    override fun onRewardVerify(map: MutableMap<String, Any>?) {
        super.onRewardVerify(map)
        //Log.d("onRewardVerify: $map")
        listener?.onRewardVerify(map)
    }

    override fun onSkippedVideo(map: MutableMap<String, Any>?) {
        super.onSkippedVideo(map)
        //Log.d("onSkippedVideo: $map")
        listener?.onSkippedVideo(map)
    }
}

class DefaultDramaHomeListener(private val listener: IDJXDramaHomeListener? = null) : IDJXDramaHomeListener() {
    override fun onItemClick(drama: DJXDrama?, map: MutableMap<String, Any>?) {
        super.onItemClick(drama, map)
        //Log.d("onItemClick: $drama, $map")
        listener?.onItemClick(drama, map)
    }
}

class DefaultDramaCardListener(private val listener: IDJXDramaCardListener? = null) : IDJXDramaCardListener() {
    override fun onDJXVideoPlay(map: MutableMap<String, Any>?) {
        super.onDJXVideoPlay(map)
        //Log.d("onDJXVideoPlay:" + map?.toString())
        listener?.onDJXVideoPlay(map)
    }

    override fun onDJXVideoPause(map: MutableMap<String, Any>?) {
        super.onDJXVideoPause(map)
        //Log.d("onDJXVideoPause:" + map?.toString())
    }

    override fun onDJXVideoContinue(map: MutableMap<String, Any>?) {
        super.onDJXVideoContinue(map)
        //Log.d("onDJXVideoContinue:" + map?.toString())
    }

    override fun onDJXVideoCompletion(map: MutableMap<String, Any>?) {
        super.onDJXVideoCompletion(map)
        //Log.d("onDJXVideoCompletion:" + map?.toString())
    }

    override fun onDJXVideoOver(map: MutableMap<String, Any>?) {
        super.onDJXVideoOver(map)
        //Log.d("onDJXVideoOver:" + map?.toString())
    }

    override fun onDJXRequestFail(code: Int, msg: String?, map: MutableMap<String, Any>?) {
        super.onDJXRequestFail(code, msg, map)
        //Log.d("onDJXRequestFail:" + map?.toString())
    }

    override fun onDJXRequestSuccess(list: MutableList<MutableMap<String, Any>>?) {
        super.onDJXRequestSuccess(list)
        list?.forEach {
            //Log.d("onDJXRequestSuccess: $it")
        }
    }
}

class DefaultDramaUnlockListener(private val lockSet: Int, private val listener: IDJXDramaUnlockListener? = null) : IDJXDramaUnlockListener {
    override fun unlockFlowStart(drama: DJXDrama, callback: IDJXDramaUnlockListener.UnlockCallback, map: Map<String, Any>?) {
        val unlockInfo = DJXDramaUnlockInfo(drama.id, lockSet, DJXDramaUnlockMethod.METHOD_AD, false)
        callback.onConfirm(unlockInfo)
        //Log.d("unlockFlowStart: $drama")
        listener?.unlockFlowStart(drama, callback, map)
    }

    override fun unlockFlowEnd(drama: DJXDrama, errCode: IDJXDramaUnlockListener.UnlockErrorStatus?, map: Map<String, Any>?) {
        //Log.d("unlockFlowEnd: $drama")
        listener?.unlockFlowEnd(drama, errCode, map)
    }
}