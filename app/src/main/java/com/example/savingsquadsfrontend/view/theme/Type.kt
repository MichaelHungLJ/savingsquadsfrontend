package com.example.savingsquadsfrontend.view.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    // Top Navigation Text
    displayLarge = TextStyle(
        fontSize = 22.sp,
        fontFamily = FontFamily.Default
    ),
    // Bottom Navigation Text
    displayMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal
    ),
    // Restaurant Name
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.5.sp,
    ),
    // Menu item name
    labelMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.5.sp,
    ),
    // Menu item price
    labelSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.5.sp,
    ),
)
