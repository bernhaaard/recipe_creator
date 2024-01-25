package com.example.recipecreator.data.local

import androidx.room.TypeConverter
import com.example.recipecreator.model.Ingredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromIngredientsList(ingredients: List<Ingredient>): String {
        val gson = Gson()
        return gson.toJson(ingredients)
    }

    @TypeConverter
    fun toIngredientsList(ingredients: String): List<Ingredient> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(ingredients, type)
    }
}
