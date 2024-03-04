package com.msoftware.notes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NotesHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private val DATABASE_NAME = "notes_db"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "notes"
        private val COLUMN_ID = "id"
        private val COLUMN_HEADING = "heading"
        private val COLUMN_BODY = "body"
        private val COLUMN_DATE = "date"
    }

    override fun onCreate(db: SQLiteDatabase?) {
       val creatTable = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_HEADING TEXT, $COLUMN_BODY TEXT, $COLUMN_DATE TEXT)"
        db?.execSQL(creatTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTable = "DROP TABLE IF EXISTS $TABLE_NAME"
        p0?.execSQL(dropTable)
        onCreate(p0)
    }

    fun insertNote (note: NotesDt)
    {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_HEADING, note.heading)
            put(COLUMN_BODY, note.body)
            put(COLUMN_DATE, note.date)
        }
        db.insert(TABLE_NAME,null, values)
        db.close()
    }

    fun getAllNotes(): List<NotesDt>
    {
        val notes = mutableListOf<NotesDt>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        while ( cursor.moveToNext())
        {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val heading = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_HEADING))
            val body = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_BODY))
            val date = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DATE))

            val thenote = NotesDt(id, heading, body, date )
            notes.add(thenote)

        }

        cursor.close()
        db.close()

        return notes


    }


}