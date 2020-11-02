package ru.netology

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

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



    fun addAttachment(post: Post, value: Attachment) {
        post.attachments = post.attachments.plus(value)
    }

    fun makeAttachment(post: Post, index: Int):String = when(post.attachments[index]){
        is PhotoAttachment -> {
            val attachment = post.attachments[index] as PhotoAttachment
            attachment.showPhoto()
        }
        is VideoAttachment -> {
            val attachment = post.attachments[index] as VideoAttachment
            attachment.playVideo()
        }
        is AudioAttachment -> {
            val attachment = post.attachments[index] as AudioAttachment
            attachment.playAudio()
        }
        is DocAttachment -> {
            val attachment = post.attachments[index] as DocAttachment
            attachment.readDoc()
        }
        is LinkAttachment -> {
            val attachment = post.attachments[index] as LinkAttachment
            attachment.goLink()
        }
        else -> {"Unknown type"}
    }

//    fun createomment(comment: Comment) {
//         comment.guid = comments?.lastIndex?: 0
//         comments = comments.plus(comment)
//
//    }
}
