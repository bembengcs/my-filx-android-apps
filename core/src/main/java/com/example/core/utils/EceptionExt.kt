package com.example.core.utils

import android.content.Context
import com.example.styling.R as styleR
import com.example.core.exception.ApiErrorException
import com.example.core.exception.NoInternetConnectionException

fun Context.getErrorMessage(exception : Exception): String {
    return when (exception) {
        is NoInternetConnectionException -> getString(styleR.string.message_error_no_internet)
        is ApiErrorException -> exception.message.orEmpty()
        else -> getString(styleR.string.message_error_unknown)
    }
}