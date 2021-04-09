package com.example.feeder.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feeder.R
import com.google.android.material.appbar.MaterialToolbar

class EventDetailsFragment(val eventModel: SampleContent.EventModel) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details_item, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.eventToolbar)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }


}