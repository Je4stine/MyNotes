package com.msoftware.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar

class Update : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val toolbar = findViewById<Toolbar>(R.id.barEdit)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = findViewById<EditText>(R.id.etdtHead)
        val body = findViewById<EditText>(R.id.etdtbody)

        title.setText(intent.getStringExtra("heading"))
        body.setText(intent.getStringExtra("body"))

        val edit = findViewById<Button>(R.id.btnEdit)
        edit.set


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