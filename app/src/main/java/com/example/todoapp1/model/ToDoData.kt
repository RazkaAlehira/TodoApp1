package com.example.todoapp1.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todoapp1.model.Priority
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "todo_table")
data class ToDoData (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Priority,
    var description: String
) : Parcelable