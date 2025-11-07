package com.example.homework1.mainModule.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.homework1.layoutConstants.Padding

@Preview(showSystemUi = true)
@Composable
fun MainCell(item: Int = 1) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Padding.Small),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
                .background(
                    if (item % 2 == 0) {
                        Color.Blue
                    } else {
                        Color.Red
                    }
                )
                .padding(all = Padding.Small),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}