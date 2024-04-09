package com.confradestech.translator_kmm.translate.domain.translate

import com.confradestech.translator_kmm.core.domain.language.Language
import com.confradestech.translator_kmm.core.domain.util.Resource
import com.confradestech.translator_kmm.translate.domain.history.HistoryDataSource
import com.confradestech.translator_kmm.translate.domain.history.HistoryItem

class TranslateUseCase(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {

    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language,
    ): Resource<String> {
        return try {
            val translatedText = client.translate(
                fromLanguage = fromLanguage,
                fromText = fromText,
                toLanguage = toLanguage
            )

            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )

            Resource.Success(translatedText)
        } catch (error: TranslateException) {
            error.printStackTrace()
            Resource.Error(error)
        }
    }
}