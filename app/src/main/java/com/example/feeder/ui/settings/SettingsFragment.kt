package com.example.feeder.ui.settings

import android.content.Intent
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.feeder.LoginActivity
import com.example.feeder.R
import com.example.feeder.RegisterActivity

class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)


        val root = inflater.inflate(R.layout.fragment_settings, container, false)

        val languages = resources.getStringArray(R.array.languages);
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.list_item, languages)

        var el: AutoCompleteTextView = root.findViewById(R.id.autocompleteTextView);
        el.setAdapter(arrayAdapter)

        return root
    }

}