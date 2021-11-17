package com.jason.mota.ui.home.model

import androidx.compose.ui.graphics.Color
import com.jason.domain.entities.Resolution

data class ResolutionState(
    val data: Resolution,
    val colorState: List<Color>
)