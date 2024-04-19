package com.confradestech.translator_kmm.voice_to_text.domain

data class VoiceToTextParserState(
    val result: String = "",
    val error: String? = null,
    val powerRatio: Float = 0F,
    val isSpeaking: Boolean = false
)
