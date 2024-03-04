package com.msoftware.notes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter ( private var data : List<NotesDt>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.note_items, parent, false
        )

        return ViewHolder(viewLayout);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = data[position]
        holder.heading.text = currentItem.heading
        holder.body.text = currentItem.body
        holder.date.text = currentItem.date

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, Update::class.java).apply {
                putExtra("heading", currentItem.heading)
                putExtra("body", currentItem.body)
                putExtra("date", currentItem.date)

            }

            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heading: TextView = itemView.findViewById(R.id.tvHeading);
        val body: TextView = itemView.findViewById(R.id.tvContent);
        val date: TextView = itemView.findViewById(R.id.tvDate);

    }

    fun refreshData (newNotesDt: List<NotesDt>)
    {
        data = newNotesDt
        notifyDataSetChanged()
    }
}

