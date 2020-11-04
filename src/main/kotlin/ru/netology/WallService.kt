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

    fun createComment(comment: Comment) {
        val postComment = comment.fromId
        val post =  findById(postComment)?:
                              throw PostNotFoundException("no post with id $postComment.id")
        comments = comments.plusElement(comment)
        post.comments.count++
    }

    fun reportComment(ownerId:Int, commentId: Int, newReason: Reason): String{
        for(post in posts){
            for(comment in comments){
                if(comment.id == commentId && comment.fromId == ownerId){
                    return comment.text + " " +  newReason.attribute
                }
            }
        }
        return "не найден комментарий $commentId для $ownerId"
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
