package th.co.cdgs.mobile.lib.models

import com.daimajia.androidanimations.library.Techniques
import th.co.cdgs.mobile.lib.R
import th.co.cdgs.mobile.lib.utils.Defaults
import th.co.cdgs.mobile.lib.utils.Flags
import java.io.Serializable

class ConfigSplash : Serializable {
    //Circular Reveal
    var animCircularRevealDuration = 0
    var revealFlagX = 0
    var revealFlagY = 0
    var backgroundColor = 0
    //Img Logo
    var logoSplash = 0
    var animLogoSplashTechnique: Techniques? = null
    var animLogoSplashDuration = 0
    //Path Logo
    var pathSplash: String? = null
    var pathSplashStrokeSize = 0
    var pathSplashStrokeColor = 0
    //Getters and Setters
    var pathSplashFillColor = 0
    var originalHeight = 0
    var originalWidth = 0
    var animPathStrokeDrawingDuration = 0
    var animPathFillingDuration = 0
    //Text
    var titleSplash: String? = null
    var titleFont: String? = null
    var animTitleDuration = 0
    var animTitleTechnique: Techniques? = null
    var titleTextSize = 0f
    var titleTextColor = 0

    //Spin
    var animSpinDuration = 0
    var animSpinTechnique: Techniques? = null

    //TextVersion
    var versionSplash: String? = null
    var versionFont: String? = null
    var animVersionDuration = 0
    var animVersionTechnique: Techniques? = null
    var versionTextSize = 0f
    var versionTextColor = 0

    init {
        animCircularRevealDuration = Defaults.ANIM_REVEAL
        revealFlagX = Flags.CENTER_HORIZOTAL
        revealFlagY = Flags.CENTER_VERTICAL
        backgroundColor = R.color.bckg
        //Img Logo
        logoSplash = R.drawable.logocdgs
        animLogoSplashTechnique = Techniques.FadeInDown
        animLogoSplashDuration = Defaults.ANIM_LOGO
        //Path Logo
        pathSplash = Defaults.EMPTY
        pathSplashStrokeSize = Defaults.STROKE_WIDTH
        pathSplashStrokeColor = R.color.white
        pathSplashFillColor = R.color.filn
        originalHeight = Defaults.ORIGINAL_HEIGHT
        originalWidth = Defaults.ORIGINAL_WIDTH
        animPathStrokeDrawingDuration = Defaults.ANIM_DRAWING
        animPathFillingDuration = Defaults.ANIM_FILLING
        //Text
        titleSplash = Defaults.APP_TITLE
        animTitleDuration = Defaults.ANIM_TEXT
        animTitleTechnique = Techniques.FadeInDown
        titleTextSize = Defaults.TEXT_SIZE
        titleTextColor = R.color.white
        titleFont = Defaults.EMPTY
        //Spin
        animSpinDuration = Defaults.ANIM_SPIN
        animSpinTechnique = Techniques.FadeInDown
        //TextVersion
        versionSplash = Defaults.VERSION_TITLE
        animVersionDuration = Defaults.ANIM_TEXT
        animVersionTechnique = Techniques.FadeInDown
        versionTextSize = Defaults.VERSION_SIZE
        versionTextColor = R.color.white
        versionFont = Defaults.EMPTY
    }
}