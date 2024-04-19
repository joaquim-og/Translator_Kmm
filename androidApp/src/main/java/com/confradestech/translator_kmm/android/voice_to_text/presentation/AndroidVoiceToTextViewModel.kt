package com.confradestech.translator_kmm.android.voice_to_text.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.confradestech.translator_kmm.voice_to_text.domain.VoiceToTextParser
import com.confradestech.translator_kmm.voice_to_text.presentation.VoiceToTextEvent
import com.confradestech.translator_kmm.voice_to_text.presentation.VoiceToTextViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidVoiceToTextViewModel @Inject constructor(
    private val parser: VoiceToTextParser
): ViewModel() {

    private val viewModel by lazy {
        VoiceToTextViewModel(
            parser = parser,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun initSpeechCollector() {
        viewModel.initSpeechCollector()
    }

    fun onEvent(event: VoiceToTextEvent) {
        viewModel.onEvent(event)
    }
}