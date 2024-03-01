package com.msoftware.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {
    abstract fun notesDao(): NotesDao

    companion object{

        private val INSTANCE: NotesDatabase? = null
    }

}