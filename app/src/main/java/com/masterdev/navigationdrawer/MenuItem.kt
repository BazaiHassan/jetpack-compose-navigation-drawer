package com.masterdev.navigationdrawer
import androidx.compose.ui.graphics.vector.ImageVector

data class MenuItem(
    val id: String,
    val title:String,
    val content_description:String,
    val icon:ImageVector
)