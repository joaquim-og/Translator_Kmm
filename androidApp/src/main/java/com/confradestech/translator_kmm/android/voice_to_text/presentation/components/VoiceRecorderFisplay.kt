package com.confradestech.translator_kmm.android.voice_to_text.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes

@Composable
fun VoiceRecorderDisplay() {

}


@Preview
@PreviewFontScale
@PreviewScreenSizes
@PreviewLightDark
@Composable
fun VoiceRecorderPreview() {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        VoiceRecorderDisplay()
    }
}