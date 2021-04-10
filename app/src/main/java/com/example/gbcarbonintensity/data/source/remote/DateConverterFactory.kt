package com.example.gbcarbonintensity.data.source.remote

import com.example.gbcarbonintensity.utils.DateUtils
import retrofit2.Converter
import retrofit2.Retrofit

import java.lang.reflect.Type
import java.util.*

class DateConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {

        return when (type) {

            Date::class.java -> DateConverter()

            else -> null

        }

    }

    private class DateConverter : Converter<Date, String> {

        override fun convert(date: Date): String = DateUtils.formatServiceDate(date)

    }

}