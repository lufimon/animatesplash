package th.co.cdgs.mobile.lib.utils

import th.co.cdgs.mobile.lib.models.ConfigSplash

object ValidationUtils {
    fun hasPath(cs: ConfigSplash?): Int? {
        return cs?.let {
            if (it.pathSplash?.isEmpty()!!) {
                Flags.WITH_LOGO
            } else {
                Flags.WITH_PATH
            }
        }
    }
}