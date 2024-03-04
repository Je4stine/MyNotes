package com.msoftware.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var data: ArrayList<NotesDt>;
    private lateinit var notesAdapter: NotesAdapter;
    private lateinit var db:NotesHelper;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data = ArrayList()
        notesAdapter = NotesAdapter(data)
        db = NotesHelper(this)


        val recyclerView = findViewById<RecyclerView>(R.id.rcItems)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = notesAdapter



        val fabAdd : FloatingActionButton = findViewById(R.id.fabAdd)

        fabAdd.setOnClickListener {
//            Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainActivity, NoteDetails::class.java )
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        notesAdapter.refreshData(db.getAllNotes())
    }

}