package ru.netology

data class Comments(
    var count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = false,
    val canOpen: Boolean = true,
    var comments: Array<Comment> = emptyArray())
   {
    fun getComment(index: Int) = comments[index]
    fun setComment(value: Comment) {
        comments = comments.plus(value)
    }
}