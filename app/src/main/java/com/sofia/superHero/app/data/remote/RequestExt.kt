package com.sofia.superHero.app.data.remote

import com.sofia.superHero.app.domain.Either
import com.sofia.superHero.app.domain.ErrorApp
import com.sofia.superHero.app.domain.left
import com.sofia.superHero.app.domain.right
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Either<ErrorApp, T> {
    val response: Response<T>
    try {
        response = call.invoke()
    } catch (exception: Throwable) {
        return when (exception) {
            is ConnectException -> ErrorApp.InternetError.left()
            is UnknownHostException -> ErrorApp.InternetError.left()
            is SocketTimeoutException -> ErrorApp.ServerError.left()
            else -> ErrorApp.UnknownError.left()
        }
    }
    if (!response.isSuccessful) {
        return ErrorApp.UnknownError.left()
    }
    return response.body()!!.right()
}