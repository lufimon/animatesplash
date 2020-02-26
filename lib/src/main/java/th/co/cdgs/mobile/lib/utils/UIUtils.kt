package th.co.cdgs.mobile.lib.utils

import android.app.Activity
import android.graphics.Typeface
import android.widget.RelativeLayout
import android.widget.TextView

object UIUtils {

    fun getRevealDirection(rl: RelativeLayout, flag: Int): Int {
        var result = 0
        when (flag) {
            Flags.REVEAL_BOTTOM -> result = rl.bottom
            Flags.REVEAL_TOP -> result = rl.top
            Flags.REVEAL_LEFT -> result = rl.left
            Flags.REVEAL_RIGHT -> result = rl.right
            Flags.CENTER_HORIZOTAL -> result = rl.width / 2
            Flags.CENTER_VERTICAL -> result = rl.height / 2
        }
        return result
    }

    fun setFont(a: Activity, txtView: TextView, font: String?) {
        val type = Typeface.createFromAsset(a.assets, font)
        txtView.typeface = type
    }
}