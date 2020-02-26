package th.co.cdgs.mobile.lib.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.daimajia.androidanimations.library.YoYo
import com.nineoldandroids.animation.Animator
import io.codetail.animation.SupportAnimator
import io.codetail.animation.ViewAnimationUtils
import kotlinx.android.synthetic.main.activity_main_lib.*
import th.co.cdgs.mobile.lib.R
import th.co.cdgs.mobile.lib.models.ConfigSplash
import th.co.cdgs.mobile.lib.utils.UIUtils
import th.co.cdgs.mobile.lib.utils.then

abstract class AwesomeSplash : AppCompatActivity() {
    private var mConfigSplash: ConfigSplash? = null
    private var hasAnimationStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mConfigSplash = ConfigSplash()
        initSplash(mConfigSplash)
        initUI()
    }

    private fun initUI() {
        setContentView(R.layout.activity_main_lib)
        imgLogo!!.setImageResource(mConfigSplash?.logoSplash!!)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus && !hasAnimationStarted) {
            startCircularReveal()
        }
    }

    private fun startCircularReveal() { // get the final radius for the clipping circle
        val finalRadius = rlColor!!.width.coerceAtLeast(rlColor!!.height) + rlColor!!.height / 2
        //bottom or top
        val y: Int = UIUtils.getRevealDirection(rlColor, mConfigSplash?.revealFlagY ?: 0)
        //left or right
        val x: Int = UIUtils.getRevealDirection(rlColor, mConfigSplash?.revealFlagX ?: 0)
        rlColor!!.setBackgroundColor(resources.getColor(mConfigSplash?.backgroundColor ?: 0, theme))
        val animator =
            ViewAnimationUtils.createCircularReveal(
                rlColor,
                x,
                y,
                0f,
                finalRadius.toFloat()
            )
        animator.setInterpolator(AccelerateDecelerateInterpolator())
        animator.setDuration(mConfigSplash?.animCircularRevealDuration ?: 0)
        animator.addListener(object : SupportAnimator.AnimatorListener {
            override fun onAnimationStart() {}
            override fun onAnimationCancel() {}
            override fun onAnimationRepeat() {}
            override fun onAnimationEnd() {
                startLogoAnimation()
            }
        })
        animator.start()
        hasAnimationStarted = true
    }

    fun startLogoAnimation() {
        imgLogo!!.visibility = View.VISIBLE
        imgLogo!!.setImageResource(mConfigSplash?.logoSplash!!)
        YoYo.with(mConfigSplash?.animLogoSplashTechnique)
            .withListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    startTextAnimation()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            }).duration(mConfigSplash?.animLogoSplashDuration?.toLong() ?: 0).playOn(imgLogo)
    }

    fun startTextAnimation() {
        txtTitle.visibility = View.VISIBLE
        txtTitle.text = mConfigSplash?.titleSplash
        YoYo.with(mConfigSplash?.animTitleTechnique)
            .withListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {}
                override fun onAnimationEnd(animation: Animator?) {
                    startSpinAnimation()
                }

                override fun onAnimationCancel(animation: Animator?) {}
                override fun onAnimationStart(animation: Animator?) {}
            }).duration(mConfigSplash?.animTitleDuration?.toLong() ?: 0).playOn(txtTitle)
    }

    fun startSpinAnimation() {
        spinWait.visibility = View.VISIBLE
        YoYo.with(mConfigSplash?.animSpinTechnique)
            .withListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {}
                override fun onAnimationEnd(animation: Animator?) {
                    animationsFinished()
                }

                override fun onAnimationCancel(animation: Animator?) {}
                override fun onAnimationStart(animation: Animator?) {}
            }).duration(mConfigSplash?.animSpinDuration?.toLong() ?: 0).playOn(spinWait)
    }

    open fun setSpinVisible(isVisible: Boolean){
        spinWait.visibility = isVisible then View.VISIBLE ?: View.GONE
    }

    open fun setTitle(title: String?) {
        title?.let {
            txtTitle.text = it
        }
    }

    open fun setProgressVisible(isVisible: Boolean) {
        progressbar.visibility = isVisible then View.VISIBLE ?: View.GONE
        progressbar.progressColor = getColor(R.color.progress_color)
        progressbar.textProgressColor = getColor(R.color.bckg)
    }

    open fun setProgressMax(max: Float) {
        progressbar.max = max
    }

    open fun setProgress(progress: Float, txt: String?) {
        progressbar.progress = progress
        progressbar.progressText = txt
    }

    abstract fun initSplash(configSplash: ConfigSplash?)
    abstract fun animationsFinished()
}