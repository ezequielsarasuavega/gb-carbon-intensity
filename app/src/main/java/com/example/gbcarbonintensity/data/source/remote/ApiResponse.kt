package com.example.gbcarbonintensity.data.source.remote

import com.example.gbcarbonintensity.data.Result
import retrofit2.Response

/**
 * Common class used by API responses
 * @param <T> the type of the response object
 */
@Suppress("unused") // T is used in extending classes
sealed class ApiResponse<T> {

    companion object {

        fun <T> toResult(response: Response<T?>): Result<T?> {

            return if (response.isSuccessful) {

                response.body()?.let {
                    Result.Success(it)
                } ?: Result.Success()

            } else {

                Result.Error(response.errorBody()?.string())

            }

        }

    }

}
