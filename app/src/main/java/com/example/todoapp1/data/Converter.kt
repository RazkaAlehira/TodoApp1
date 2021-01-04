package com.example.todoapp1.data

import androidx.room.TypeConverter
import com.example.todoapp1.model.Priority

class Converter {


    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(priority: String): Priority {
        return Priority.valueOf(priority)
    }
}