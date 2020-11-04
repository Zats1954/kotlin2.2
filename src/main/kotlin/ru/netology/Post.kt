package ru.netology

import java.time.Clock

data class Post(
    val id: Int = 0,
    var title: String = "",
    var text: String = "",
    var date: Int = Clock.systemUTC().millis().toInt(),
    var ownerId: Int = 0,
    var fromId: Int = 0,
    var createdBy: Int = 0,
    var replyOwnerId: Int = 0,
    var friendsOnly: Boolean = true,
    var comments: Comments = Comments(),
    var copyright: String = "",
    var likes: Likes? = null,
    var reposts: Reposts? = null,
    var views: Views? = null,
    var attachments: Array<Attachment> = emptyArray(),
    var postType: PostType = PostType.POST,
    var postSource: PostSource? = null,
    var geo: Geo? = null,
    var signerId: Int = 0,
    var copyHistory: Array<Post> = emptyArray(),
    var canPin: Boolean = true,
    var canDelete: Boolean = false,
    var canEdit: Boolean = false,
    var isPinned: Boolean = false,
    var markedAsAds: Boolean = false,
    var isFavorite: Boolean = true,
    var postponedId: Int? = 0
) {}

    class Likes(
        val userLikes: Boolean = true,
        val canLike: Boolean = true,
        val canPublish: Boolean = true,
        var Count: Int = 0) { }

    class Reposts(
        val userReposted: Boolean = false,
        var Count: Int = 0){}

    class Views(var Count: Int = 0) { }

    class Geo(
        val type: String = "",
        val coordinates: String = "",
        val place: Place?){}


    class Place(
        val id: Int = 0,
        var title: String = "",
        var latitude: Int = 0,
        var longitude: Int = 0,
        val created: Int = 0,
        val icon: String = "",
        val checkins: Int = 0,
        val updated: Int = 0,
        val type: Int = 0,
        val country: Int = 0,
        val city: Int = 0,
        val address: String = ""
    ){ }

enum class PostType {
    POST,
    COPY,
    REPLY,
    POSTPONE,
    SUGGEST
}

