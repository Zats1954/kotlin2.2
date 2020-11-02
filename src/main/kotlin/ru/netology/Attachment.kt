package ru.netology

abstract class Attachment(
    var id: Int = 0,
    val albumId: Int = 0,
    val ownerId: Int = 0,
    val userId: Int = 0)
    {
    abstract val type: String
    fun print() {
        print("opened $type $id")
    }
}

class PhotoAttachment(): Attachment()  {
    override val type: String = "photo"
    fun showPhoto(): String {
        return "show $type $id"
    }
}

class VideoAttachment() :Attachment(){
    override val type: String = "video"
    fun playVideo(): String  {
        return "play $type $id"
    }
}


class AudioAttachment() :Attachment(){
    override val type: String = "audio"
    fun playAudio(): String  {
        return "play $type $id"
    }
}

class DocAttachment() :Attachment(){
    override val type: String = "doc"
    fun readDoc(): String  {
        return "read $type $id"
    }
}

class LinkAttachment() :Attachment(){override val type: String = "link"
    fun goLink(): String  {
        return "go to $type $id"
    }
}