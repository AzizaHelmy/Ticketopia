package com.example.ticketopia.ui.composable

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketopia.ui.theme.Adamina
import com.example.ticketopia.ui.theme.Orange

/**
 * Created by Aziza Helmy on 7/5/2023.
 */
@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun DefaultButton(text: String, icon: Painter?, modifier: Modifier = Modifier) {
    Button(
        onClick = {}, modifier = modifier
            .height(54.dp),

        shape = RoundedCornerShape(32.dp),
        colors = ButtonDefaults.buttonColors(Orange),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {
        Row {
            icon?.let {
                Icon(
                    painter = it,
                    contentDescription = "Booking Icon"
                )
            }
            SpacerHorizontal8()
            Text(
                text = text,
                fontFamily = Adamina,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.White,

                )
        }

    }
}