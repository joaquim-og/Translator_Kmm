package com.confradestech.translator_kmm.voice_to_text.domain

import com.confradestech.translator_kmm.core.domain.util.CommonStateFlow

interface VoiceToTextParser {
    val state: CommonStateFlow<VoiceToTextParserState>

    fun statListening(languageCode: String)
    fun stopListening()
    fun cancel()
    fun reset()

}