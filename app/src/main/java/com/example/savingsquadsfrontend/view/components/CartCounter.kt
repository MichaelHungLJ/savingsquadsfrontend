package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.savingsquadsfrontend.R

@Composable
fun CartCounter(quantityState : Int, onQuantityChange: (Int)-> Unit){

    // if we do this, we need a callback function to update the viewModel
    var count by remember { mutableStateOf(quantityState) }

    Row (
        modifier = Modifier
            .width(60.dp)
            .height(25.dp)
            .background(Color.White, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Button(
            onClick = {
                if (count > 0) count--
                onQuantityChange(count)
                      },
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Gray),
        ) {
            Icon(painter = painterResource(id = R.drawable.remove), contentDescription = "remove")
        }

        Text(
            text = "$count",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Button(
            onClick = {
                count++
                onQuantityChange(count)
                      },
            modifier = Modifier
                .width(20.dp)
                .fillMaxHeight(),
            contentPadding = PaddingValues(),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = Color.Gray),
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }
    }
}
