package com.example.letssopt.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import retrofit2.HttpException

@Serializable
data class BaseResponse<T>(
    @SerialName("success")
    val success: Boolean,
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: String,
    @SerialName("data")
    val data: T? = null,
)


@Serializable
data class ErrorResponse(
    @SerialName("success")
    val success: Boolean,
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: String,
    @SerialName("meta")
    val meta: MetaResponse,

    )

@Serializable
data class MetaResponse(
    @SerialName("path")
    val path: String,
    @SerialName("timestamp")
    val timestamp: String,
)


fun Throwable.toErrorResponse(): Int {
    val json = Json { ignoreUnknownKeys = true }
    val httpException = this as? HttpException ?: throw this
    val errorBody = httpException.response()?.errorBody()?.string() ?: throw this
    val errorStatus = json.decodeFromString<ErrorResponse>(errorBody)
    return errorStatus.status
}
