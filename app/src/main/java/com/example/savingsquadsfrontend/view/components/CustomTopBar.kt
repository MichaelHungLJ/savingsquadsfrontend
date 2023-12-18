package com.example.savingsquadsfrontend.view.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(screenName: String, navController: NavController, prevScreenTitle: String){
    TopAppBar(
        title = {
                Text(text = prevScreenTitle)
        },
        navigationIcon = {
            IconButton(
                onClick = { if (screenName == "Backstack") navController.popBackStack()
                    else navController.navigate(screenName) }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back icon")

            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview
@Composable
fun TopBarPreview() {
    val fakeNavController = rememberNavController() // Create a fake NavController for preview
    SavingsquadsfrontendTheme {
        CustomTopBar(screenName = "HomeScreen", navController = fakeNavController, prevScreenTitle = "Home" )
    }
}

