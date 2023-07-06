package com.example.ticketopia.ui.util

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

/**
 * Created by Aziza Helmy on 7/6/2023.
 */
fun Modifier.clickableIf(condition: () -> Boolean, onClick: (() -> Unit)? = null): Modifier {
    return if (condition()) {
        then(Modifier.clickable { onClick?.invoke() })
    } else this
}