package com.example.recipecreator.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromIngredientsList(ingredients: List<String>): String {
        val gson = Gson()
        return gson.toJson(ingredients)
    }

    @TypeConverter
    fun toIngredientsList(ingredients: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(ingredients, type)
    }
}
