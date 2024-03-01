package com.msoftware.notes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Notes (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val heading: String,
    val body: String,
    val date: String
)
