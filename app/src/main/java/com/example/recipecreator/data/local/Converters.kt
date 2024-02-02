package com.example.recipecreator.data.local

import androidx.room.TypeConverter
import com.example.recipecreator.model.Ingredient
import com.example.recipecreator.model.Instruction
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromIngredientsList(ingredients: List<Ingredient>): String {
        val gson = Gson()
        return gson.toJson(ingredients)
    }

    @TypeConverter
    fun toIngredientsList(ingredients: String?): List<Ingredient>? {
        if (ingredients.isNullOrEmpty()) return emptyList()
        val gson = Gson()
        val type = object : TypeToken<List<Ingredient>>() {}.type
        return gson.fromJson(ingredients, type)
    }

    @TypeConverter
    fun fromInstructionsList(instructions: List<Instruction>): String {
        val gson = Gson()
        return gson.toJson(instructions)
    }

    @TypeConverter
    fun toInstructionList(instructions: String?): List<Instruction>? {
        if (instructions.isNullOrEmpty()) return emptyList()
        val gson = Gson()
        val type = object : TypeToken<List<Instruction>>() {}.type
        return gson.fromJson(instructions, type)
    }
}
