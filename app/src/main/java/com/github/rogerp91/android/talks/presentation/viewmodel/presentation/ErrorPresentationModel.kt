package com.github.rogerp91.android.talks.presentation.viewmodel.presentation

import com.github.rogerp91.android.talks.presentation.model.ErrorModel
import com.github.rogerp91.android.talks.presentation.model.error.ClientErrorModel
import com.github.rogerp91.android.talks.presentation.model.error.NetworkErrorModel
import com.github.rogerp91.android.talks.presentation.model.error.ServerErrorModel
import com.github.rogerp91.android.talks.presentation.model.error.UnauthorizedErrorModel
import com.github.rogerp91.android.talks.presentation.model.error.UnknownErrorModel
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * Created by rpatino on oct/2019
 */
class ErrorPresentationModel {

    fun transform(throwable: Throwable?): ErrorModel {
        return when (throwable) {
            is HttpException -> {
                if (throwable.code() == 401) {
                    UnauthorizedErrorModel("")
                } else {
                    if (throwable.code() in 400..499) {
                        ClientErrorModel("")
                    } else {
                        ServerErrorModel("")
                    }
                }
            }
            is SocketTimeoutException, is IOException -> {
                NetworkErrorModel("")
            }
            else -> UnknownErrorModel("")
        }
    }
}