package com.confradestech.translator_kmm.android.tanslate.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

fun Modifier.gradientSurface(): Modifier {
    return composed {
        if (isSystemInDarkTheme()) {
            this.then(
                Modifier.background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF23262E),
                            Color(0xFF212329)
                        )
                    )
                )
            )
        } else {
            this.background(
                MaterialTheme.colorScheme.surface
            )
        }
    }
}