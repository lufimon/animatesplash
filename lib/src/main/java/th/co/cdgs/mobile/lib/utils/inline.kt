package th.co.cdgs.mobile.lib.utils

infix fun <T> Boolean.then(param: T): T? = if (this) param else null