package com.jason.domain.entities

data class Resolution(
    val id: String,
    val name: String,
    val description: String,
    val avatar: String,
    val participants: Int,
    val challenges: Int
)
