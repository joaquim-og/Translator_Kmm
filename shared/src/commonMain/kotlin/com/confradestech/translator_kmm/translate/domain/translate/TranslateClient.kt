package com.confradestech.translator_kmm.translate.domain.translate

import com.confradestech.translator_kmm.core.domain.language.Language

interface TranslateClient {

    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String

}