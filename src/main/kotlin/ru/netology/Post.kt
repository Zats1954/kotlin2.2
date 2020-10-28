package ru.netology

data class Post(
    val id: Int = 0,
    var ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy: Int = 0,
    var date: Int = 0,
    val text: String = "",
    val replyOwnerId: Int = 0,
    val friendsOnly: Boolean = true,
    val comments: Comments = Comments(),
    val copyright: String = "",
    val likes: Likes = Likes(),
    val reposts: Reposts = Reposts(),
    val views: Views = Views(),
    val postType: String = "",
    val signerId: Int = 0,
    val title: String = "",
    val canPin: Boolean = true,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = true,
    val postponedId: Int = 0
) {

    class Comments (
        var Count: Int = 0,
        val canPost: Boolean = true,
        val groupsCanPost: Boolean = true,
        val canClose: Boolean = false,
        val canOpen: Boolean = true
    ){    }

    class Likes(
        var Count: Int = 0,
        val userLikes: Boolean = true,
        val canLike: Boolean = true,
        val canPublish: Boolean = true
    ) {    }

    class Reposts(
        var Count: Int = 0,
        val userReposted: Boolean = false
    ) {    }

    class Views(
        var Count: Int = 0
    ) {    }

}