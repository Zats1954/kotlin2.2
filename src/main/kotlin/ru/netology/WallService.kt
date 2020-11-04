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

    fun getComment(i:Int):  Comment?  {
        try{
            return comments[i]
        } catch(e:ArrayIndexOutOfBoundsException){
            return null
        }
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

    fun createComment(newComment: Comment) {
        val post =  findById(newComment.postId)?:
                              throw PostNotFoundException("no post with id $newComment.postId")
        for(comment in comments){  // для предотвращения повторной отправки одинакового комментария
            if(comment.guid == newComment.guid)
                return
        }
        comments = comments.plusElement(newComment)
        post.comments.count++
    }

    fun reportComment(postId:Int, guid: Int, newReason: Reason): String{
        for(post in posts){
            for(comment in comments){
                if(comment.guid == guid && comment.postId == postId){
                    return comment.message + " " +  newReason.attribute
                }
            }
        }
        return "не найден комментарий $guid для $postId"
    }

    fun  findById(postComment: Int): Post? {
        for (post in posts) {
            if(postComment == post.id)
                return post
        }
        return null
    }
}

class PostNotFoundException(s: String) : RuntimeException(s)

enum class Reason(val order: Int,val attribute: String) {
    SPAM(0,"спам"),
    CHILDPORN(1,"детская порнография"),
    EXTREMIZM(2,"экстремизм"),
    VIOLENCE(3,"насилие"),
    DRUGS(4," пропаганда наркотиков"),
    ADULTS(5,"материал для взрослых"),
    OUTRAGE(6,"оскорбление"),
    SUICIDE(8,"призывы к суициду");  // а где 7 ?
    }
