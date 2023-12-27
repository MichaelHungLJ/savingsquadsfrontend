package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CartCostBar (name: String, cost: Double) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){

        Text(
            modifier = Modifier.padding(start = 5.dp),
            text = name,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            modifier = Modifier.width(60.dp).padding(end=5.dp),
            text = "$"+ String.format("%.2f", cost),
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
    }

}

@Preview (showBackground = true)
@Composable
fun CartCostBarPreview () {
    CartCostBar(name = "Sub total", cost = 55.23)
}
