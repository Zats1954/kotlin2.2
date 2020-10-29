package ru.netology

class WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post) {
        val newId = if(posts.size ==0) {0} else{posts.last().id +1}
        posts += post.copy(id = newId)
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
