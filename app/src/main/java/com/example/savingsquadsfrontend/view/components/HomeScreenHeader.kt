package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenHeader(logo: Int) {
    Column(
        modifier = Modifier.fillMaxWidth().height(56.dp).background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = logo),
            contentDescription = "FoodPanda Logo",
            modifier = Modifier.width(200.dp).height(40.dp),
        )
    }
}


//    TopAppBar(
//        title = {
//            Column (
//                modifier = Modifier.fillMaxSize(),
//            ){
//                Icon(
//                    painter = painterResource(id = logo),
//                    contentDescription = "FoodPanda Logo",
//                    modifier = Modifier.fillMaxSize(),
//                )
//            }
//        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer,
//            titleContentColor = MaterialTheme.colorScheme.primary
//        )
//    )


@Preview (showBackground = true)
@Composable
fun HeaderPreview() {
    SavingsquadsfrontendTheme {
        HomeScreenHeader(R.drawable.foodpanda_logo)
    }
}
