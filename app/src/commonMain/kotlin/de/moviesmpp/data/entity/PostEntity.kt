package de.moviesmpp.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class PostEntity(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
