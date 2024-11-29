package com.example.NoteTaker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentgg1.R

class Page3Fragment : Fragment() {
    private lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.run {
            ViewModelProvider(this)[MyViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        val view = inflater.inflate(R.layout.page3_fragment, container, false)

        val notesContainer = view.findViewById<LinearLayout>(R.id.notesContainer)

        // Observe notes changes
        viewModel.notes.observe(viewLifecycleOwner) { notes ->
            notesContainer.removeAllViews()
            notes.forEach { (date, note) ->
                val noteView = layoutInflater.inflate(R.layout.note_item, notesContainer, false)
                noteView.findViewById<TextView>(R.id.dateText).text = date
                noteView.findViewById<TextView>(R.id.noteText).text = note
                notesContainer.addView(noteView)
            }
        }

        return view
    }
}