package com.confradestech.translator_kmm.android.tanslate.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.confradestech.translator_kmm.core.presentation.UiLanguage

@Composable
fun LanguageDropDownItem(
    language: UiLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(
        modifier = Modifier,
        leadingIcon = {
            Image(
                painter = painterResource(id = language.drawableRes),
                contentDescription = language.language.langName,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
        },
        text = {
            Text(text = language.language.langName)
        },
        onClick = onClick
    )

}