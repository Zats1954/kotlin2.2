package ru.netology

object WallService {
    private var id = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post) {
        posts += post.copy(id = id++)
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (currentPost.id == post.id) {
                val currentDate = currentPost.date
                val currentOwnerId = currentPost.ownerId
                posts[index] = post
                posts[index].date = currentDate
                posts[index].ownerId = currentOwnerId
                return true
            }
        }
        return false
    }

    operator fun get(i:Int):  Post  {
        return posts[i]
    }
}
