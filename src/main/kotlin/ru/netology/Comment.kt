package ru.netology

data class Comment(val ownerId:Int =0,
              val postId:Int = 0,
              val fromGroup:Int = 0,
              val message:String = "",
              val replyToComment: Int = 0,
              val attachments: String = "",
              val stickerId: Int = 0,
              val guid:String = "",
              val commentId:Int = 0)
        {
          val parentStack: Array<Int>  = emptyArray()
        }
