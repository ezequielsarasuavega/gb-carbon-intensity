package com.example.gbcarbonintensity.data

/**
 * A generic class that holds a value
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T? = null) : Result<T?>()

    data class Error(val errorMessage: String? = null) : Result<Nothing>()

}