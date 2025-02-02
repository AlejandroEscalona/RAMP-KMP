package kmp.project.rickandmortyapp.ui.core.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

fun Modifier.vertical() = layout { measurable, contrains ->
    val placeable = measurable.measure(contrains)
    layout(placeable.height, placeable.width) {
        placeable.place(
            x = -((placeable.width/2) - (placeable.height/2)),
            y = -((placeable.height/2) - (placeable.width/2))
        )
    }
}

