package com.example.NoteTaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentgg1.R

class Page2Fragment : Fragment() {
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.run {
            ViewModelProvider(this)[MyViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.page2_fragment, container, false)

        val selectedDateText = view.findViewById<TextView>(R.id.selectedDateText)
        val noteInput = view.findViewById<EditText>(R.id.editValue)
        val saveButton = view.findViewById<Button>(R.id.vButton)  // Using the existing button ID
        val clearButton = view.findViewById<Button>(R.id.clearButton)

        // Observe value changes (which stores our selected date)
        viewModel.value.observe(viewLifecycleOwner) { date ->
            selectedDateText.text = "Selected Date: $date"
        }

        // Set up save button
        saveButton.setOnClickListener {
            val noteText = noteInput.text.toString()
            if (noteText.isNotEmpty() && viewModel.value.value != null) {
                viewModel.addNote(viewModel.value.value!!, noteText)
                noteInput.text.clear()
            }
        }

        // Set up clear button
        clearButton.setOnClickListener {
            noteInput.text.clear()
        }

        return view
    }
}