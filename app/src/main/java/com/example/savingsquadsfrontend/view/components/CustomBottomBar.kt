package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme
import com.example.savingsquadsfrontend.view.theme.Typography

@Composable
fun CustomBottomBar (navController: NavController, nextPage: String,buttonName: String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp).background(MaterialTheme.colorScheme.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { navController.navigate(nextPage) },
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 30.dp,vertical = 10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary ,
                containerColor = MaterialTheme.colorScheme.primary),
        ) {
            Text(
                text = buttonName,
                style = Typography.displayMedium,
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CustomBottomBarPreview() {
    val fakeNavController = rememberNavController() // Create a fake NavController for preview

    SavingsquadsfrontendTheme {
        CustomBottomBar(fakeNavController, "CartScreen", "Checkout")
    }
}
