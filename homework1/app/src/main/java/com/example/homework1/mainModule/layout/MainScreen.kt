package com.example.homework1.mainModule.layout

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.homework1.R
import com.example.homework1.layoutConstants.Padding
import com.example.homework1.mainModule.viewModel.MainViewModel

@Preview(showSystemUi = true)
@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val currentCount = viewModel.itemsCount.value

    val items = remember(currentCount) {
        List(currentCount) { "$it" }
    }

    val cellsCount: Int = when (LocalConfiguration.current.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> MainGridConfig.LANDSCAPE_CELLS
        Configuration.ORIENTATION_PORTRAIT -> MainGridConfig.PORTRAIT_CELLS
        else -> MainGridConfig.DEFAULT_CELLS
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(cellsCount),
            modifier = Modifier
                .padding(top = Padding.ExtraLarge)
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = Padding.ExtraExtraLarge)
        ) {
            items(items = items) { item ->
                MainCell(item = item.toInt())
            }
        }

        Button(
            onClick = { viewModel.onClickAction() },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = Padding.Button.Horizontal)
                .padding(vertical = Padding.Button.Vertical)
        ) {
            Text(stringResource(R.string.main_button_text))
        }
    }
}

private object MainGridConfig {
    const val LANDSCAPE_CELLS = 4
    const val PORTRAIT_CELLS = 3
    const val DEFAULT_CELLS = 3
}