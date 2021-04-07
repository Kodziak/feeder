package com.example.feeder.ui.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.feeder.R

class AddRSSFragment : Fragment() {

    private lateinit var addRSSViewModel: AddRSSViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addRSSViewModel =
                ViewModelProvider(this).get(AddRSSViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_rss, container, false)
        val textView: TextView = root.findViewById(R.id.text_add_rss)
        addRSSViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}