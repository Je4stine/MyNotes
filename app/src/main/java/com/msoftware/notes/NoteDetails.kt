package com.msoftware.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class NoteDetails : AppCompatActivity() {
    private lateinit var db: NotesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        db = NotesHelper(this)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val etHeading = findViewById<EditText>(R.id.etHeading)?.text.toString()
            val body = findViewById<EditText>(R.id.etNotes)?.text.toString()
            val date = findViewById<EditText>(R.id.tvDate)?.text.toString()



            if (etHeading.isEmpty() || body.isEmpty()) {
                Toast.makeText(this, "Please enter a heading and note content", Toast.LENGTH_LONG).show();
            } else
            {
                val note = NotesDt(0,etHeading, body, date)


                db.insertNote(note)
                finish()
                Toast.makeText(this, "Note Added!!", Toast.LENGTH_LONG).show()
            }
            

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when( item.itemId)
        {
            android.R.id.home ->
            {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)


    }
}