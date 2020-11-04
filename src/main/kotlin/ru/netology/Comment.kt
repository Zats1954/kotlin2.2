package ru.netology

data class Comment(
                    val postId: Int = 0,
                    val ownerId:Int =0,
                    val fromGroup: Int = 0,
                    val message:String = "",
                    val replyToComment: Int = 0,
                    val attachments: Array<Attachment> = emptyArray(),
                    val stickerId: Int = 0,
                    val guid:  Int = 0
                  )  {  }
