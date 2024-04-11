package com.confradestech.translator_kmm.android.tanslate.presentation.components

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberTextToSpeech(): TextToSpeech {
    val context = LocalContext.current
    val tts = remember {
        TextToSpeech(context, null)
    }
    DisposableEffect(key1 = tts) {
        onDispose {
            tts.apply {
                stop()
                shutdown()
            }
        }
    }
    return tts
}