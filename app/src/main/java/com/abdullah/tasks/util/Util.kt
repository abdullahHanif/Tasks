package com.abdullah.tasks.util

import java.text.SimpleDateFormat
import java.util.*


val DISPLAY_FORMATE = "MMM dd, yyyy"
//2019-11-15T13:37:10.521+0000
//2016-03-04T00:00:00.000Z
val SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"

val SUBSCRIPTION_SERVER_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
val DISPLAY_SUBSCRIPTION_FORMAT = "MM-dd-yyyy"



fun getFormattedDate(time: String): String? {
    val inputDateFormat = SimpleDateFormat(SERVER_FORMAT, Locale.GERMANY)
    val outputDateFormat = SimpleDateFormat(DISPLAY_FORMATE, Locale.GERMANY)

    return outputDateFormat.format(inputDateFormat.parse(time) ?:  "2019-11-15T13:37:10.521+0000")
}

fun fromatDateFromServer(time: String?): String {

    time?.let {
        val inputDateFormat = SimpleDateFormat(SUBSCRIPTION_SERVER_FORMAT)
        val outputDateFormat = SimpleDateFormat(DISPLAY_SUBSCRIPTION_FORMAT)

        return try {
            outputDateFormat.format(inputDateFormat.parse(time))
        } catch (e: Exception) {
            return time
        }
    } ?: return "-"
}