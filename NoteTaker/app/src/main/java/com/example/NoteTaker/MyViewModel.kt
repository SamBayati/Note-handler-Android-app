package com.example.NoteTaker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    // Original value for text exchange
    private val _value = MutableLiveData<String>()
    val value: MutableLiveData<String> get() = _value

    // New values for note-taking
    private val _selectedDate = MutableLiveData<String>()
    val selectedDate: MutableLiveData<String> get() = _selectedDate

    private val _notes = MutableLiveData<List<Pair<String, String>>>()
    val notes: MutableLiveData<List<Pair<String, String>>> get() = _notes

    init {
        _value.value = "default"
        _selectedDate.value = ""
        _notes.value = emptyList()
    }

    fun addNote(date: String, noteText: String) {
        val currentNotes = _notes.value ?: emptyList()
        _notes.value = currentNotes + Pair(date, noteText)
    }


    private val _currentTab = MutableLiveData<Int>()
    val currentTab: LiveData<Int> = _currentTab

    fun setCurrentTab(position: Int) {
        _currentTab.value = position
    }
}


