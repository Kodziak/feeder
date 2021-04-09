package com.example.feeder.ui.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.feeder.R

import com.example.feeder.ui.events.SampleContent.EventModel

import com.google.android.material.card.MaterialCardView

class EventRecyclerViewAdapter(
    private val values: List<EventModel>,
    private val activity: FragmentActivity?
) : RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>() {
    private var card: MaterialCardView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_event_item, parent, false)

        card = view.findViewById(R.id.eventContainer)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        card?.setOnClickListener { view ->
            val context =
                activity?.supportFragmentManager?.findFragmentById(R.id.nav_host_fragment)?.context

            if (context != null) {
                activity
                    ?.supportFragmentManager
                    ?.beginTransaction()
                    ?.replace(R.id.nav_host_fragment, EventDetailsFragment(item))
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }
        holder.id.text = item.id
        holder.description.text = item.description
        val image = holder.itemView.findViewById<ImageView>(R.id.eventImage)
        image.setImageResource(item.image)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id = view.findViewById<TextView>(R.id.eventItem)
        val description = view.findViewById<TextView>(R.id.eventDescription)
    }
}