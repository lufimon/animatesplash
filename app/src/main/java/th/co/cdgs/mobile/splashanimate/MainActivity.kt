package th.co.cdgs.mobile.splashanimate

import th.co.cdgs.mobile.lib.activity.AwesomeSplash
import th.co.cdgs.mobile.lib.models.ConfigSplash

class MainActivity : AwesomeSplash() {

    override fun initSplash(configSplash: ConfigSplash?) {

    }

    override fun animationsFinished() {
        this.setSpinVisible(false)
        this.setProgressVisible(true)
        this.setProgressMax(100F)
        this.setTitle("กำลังดาวน์โหลดอัพเดตใหม่")
        for (i in 0..50) {
            this.setProgress(i.toFloat(),"${i}%")
        }
    }

}
