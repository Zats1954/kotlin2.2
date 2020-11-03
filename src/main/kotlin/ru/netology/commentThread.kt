package ru.netology

class CommentThread (
                     val count: Int = 0,
                     val items: Array<Comment>? = null,
                     val canPost:Boolean = true,
                     val showReplyButton: Boolean = true,
                     val groupsCanPost: Boolean = true
                     ){ }
