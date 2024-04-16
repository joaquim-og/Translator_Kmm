package com.confradestech.translator_kmm.di

import com.confradestech.translator_kmm.database.TranslateDatabase
import com.confradestech.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import com.confradestech.translator_kmm.translate.data.local.DatabaseDriverFactory
import com.confradestech.translator_kmm.translate.data.remote.HttpClientFactory
import com.confradestech.translator_kmm.translate.data.translate.KtorTranslateClient
import com.confradestech.translator_kmm.translate.domain.history.HistoryDataSource
import com.confradestech.translator_kmm.translate.domain.translate.TranslateClient
import com.confradestech.translator_kmm.translate.domain.translate.TranslateUseCase

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

   private val translateClient: TranslateClient by lazy {
       KtorTranslateClient(
           HttpClientFactory().create()
       )
   }


    val translateUseCase: TranslateUseCase by lazy {
        TranslateUseCase(
            client = translateClient,
            historyDataSource = historyDataSource
        )
    }
}