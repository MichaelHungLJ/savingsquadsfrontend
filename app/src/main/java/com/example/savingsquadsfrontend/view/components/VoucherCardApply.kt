package com.example.savingsquadsfrontend.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.savingsquadsfrontend.model.data.Voucher
import com.example.savingsquadsfrontend.view.theme.SavingsquadsfrontendTheme

@Composable
fun VoucherCartApply (voucher: Voucher) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(start = 20.dp, end = 20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 14.dp
        ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            // disabled color
        ),
        border = BorderStroke(0.4.dp, MaterialTheme.colorScheme.inverseOnSurface)
    ){
        Row (
            modifier = Modifier.fillMaxSize().padding(start = 10.dp , end = 10.dp ,top=20.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column (
                modifier = Modifier.width(220.dp).fillMaxHeight(),
            ){
                Text(
                    text = voucher.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = voucher.desc,
                    color = MaterialTheme.colorScheme.inverseOnSurface

                )
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.wrapContentWidth().height(20.dp),
                contentPadding = PaddingValues(2.dp,1.dp)
            ) {
                Text(
                    text = "Apply",
                    fontSize = 10.sp,
                    )
            }
        }

    }
}

@Preview (showBackground = true)
@Composable
fun VoucherCartApplyPreview () {

    val voucher = Voucher("Free Delivery", "Min spend $30", 3.99)

    SavingsquadsfrontendTheme {
        VoucherCartApply(voucher)
    }
}
