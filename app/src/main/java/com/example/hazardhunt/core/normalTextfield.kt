// ktlint-disable filename
package com.example.hazardhunt.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hazardhunt.R

@Composable
fun NormalTextField(textValue: String) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(dimensionResource(id = R.dimen.ordinary_text_height)),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.tertiary,
    )
}

@Composable
fun BoldTExtField(textValue: String) {
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        fontSize = 30.sp,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
        ),
        textAlign = TextAlign.Center,

    )
}
