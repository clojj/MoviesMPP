package de.moviesmpp.domain.model

import de.moviesmpp.data.entity.PostEntity

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun toModel(postEntity: PostEntity): Post = Post(
    userId = postEntity.userId,
    id = postEntity.id,
    title = postEntity.title,
    body = postEntity.body
)