package com.confradestech.translator_kmm.android.voice_to_text.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.confradestech.translator_kmm.android.core.theme.TranslatorTheme
import com.confradestech.translator_kmm.android.tanslate.presentation.components.gradientSurface
import kotlin.random.Random

@Composable
fun VoiceRecorderDisplay(
    powerRatios: List<Float>,
    modifier: Modifier = Modifier,
) {

    val primaryColor = MaterialTheme.colorScheme.primary

    Box(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .gradientSurface()
            .padding(
                horizontal = 32.dp,
                vertical = 8.dp
            )
            .drawBehind {
                val powerRatioWidth = 3.dp.toPx()
                val powerRatioCount = (size.width / (2 * powerRatioWidth)).toInt()

                clipRect(
                    left = 0F,
                    top = 0F,
                    right = size.width,
                    bottom = size.height
                ) {
                    powerRatios
                        .takeLast(powerRatioCount)
                        .reversed()
                        .forEachIndexed { index, ratio ->
                            val yTopStart = center.y - (size.height / 2F) * ratio
                            drawRoundRect(
                                color = primaryColor,
                                topLeft = Offset(
                                    x = size.width - index * 2 * powerRatioWidth,
                                    y = yTopStart
                                ),
                                size = Size(
                                    width = powerRatioWidth,
                                    height = (center.y - yTopStart) * 2F
                                ),
                                cornerRadius = CornerRadius(100F)
                            )
                        }
                }
            }
    )
}


@Preview
@PreviewFontScale
@PreviewScreenSizes
@PreviewLightDark
@Composable
fun VoiceRecorderPreview() {
    TranslatorTheme {
        VoiceRecorderDisplay(
            powerRatios = (0..150).map {
                Random.nextFloat()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}