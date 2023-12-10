package com.example.savingsquadsfrontend.composable

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.savingsquadsfrontend.R
import com.example.savingsquadsfrontend.VoucherApp
import com.example.savingsquadsfrontend.ui.theme.SavingsquadsfrontendTheme


@Composable
fun VoucherCardRedeem () {
    Card (
        modifier = Modifier
            .width(300.dp)
            .height(60.dp),
        shape = RoundedCornerShape(0.dp),
        ){

        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier
                    .size(90.dp, 60.dp)
                    .padding(start = 15.dp, end = 15.dp),
                painter = painterResource(id = R.drawable.voucher),
                contentDescription = "$5 voucher",
                contentScale = ContentScale.Crop,
            )

            Column (
                modifier = Modifier.weight(1f),
                ){
                Text(
                    text = "$5 Off",
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "100 Points",
                    fontSize = 10.sp
                )
            }

            Button(
                modifier = Modifier
                    .size(90.dp,30.dp)
                    .padding(end=10.dp),
                onClick = {
                /*TODO*/
                }
            ) {
                Text(
                    fontSize = 8.sp,
                    text = "Redeem")
            }
        }
    }

}

@Preview
@Composable
fun VoucherCardRedeemPreview () {
    val fakeNavController = rememberNavController() // Create a fake NavController for preview
    SavingsquadsfrontendTheme {
        VoucherCardRedeem()
    }
}



