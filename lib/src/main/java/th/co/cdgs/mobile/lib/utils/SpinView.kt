package th.co.cdgs.mobile.lib.utils

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView
import th.co.cdgs.mobile.lib.R

class SpinView : ImageView, Indeterminate {

    private var mRotateDegrees = 0f
    private var mFrameTime = 0
    private var mNeedToUpdateView = false
    private var mUpdateViewRunnable: Runnable? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        setImageResource(R.drawable.kprogresshud_spinner)
        mFrameTime = 1000 / 12
        mUpdateViewRunnable = Runnable {
            mRotateDegrees += 30
            mRotateDegrees = (mRotateDegrees < 360) then mRotateDegrees ?: mRotateDegrees - 360
            invalidate()
            if (mNeedToUpdateView) {
                postDelayed(mUpdateViewRunnable, mFrameTime.toLong())
            }
        }
    }

    override fun setAnimationSpeed(scale: Float) {
        mFrameTime = (1000 / 12 / scale).toInt()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.rotate(mRotateDegrees, (width / 2).toFloat(), (height / 2).toFloat())
        super.onDraw(canvas)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mNeedToUpdateView = true
        post(mUpdateViewRunnable)
    }

    override fun onDetachedFromWindow() {
        mNeedToUpdateView = false
        super.onDetachedFromWindow()
    }
}