package ru.netology

class Attachments(var attachments:Array<Attachment> = emptyArray()) {
    fun getAttachment(index: Int) = attachments[index]
    fun addAttachment(value: Attachment) {
        attachments = attachments.plus(value)
    }
    fun makeAttachment(index: Int):String = when(attachments[index]){
        is PhotoAttachment -> {
                                val attachment = attachments[index] as PhotoAttachment
                                attachment.showPhoto()
                               }
        is VideoAttachment -> {
                                val attachment = attachments[index] as VideoAttachment
                                attachment.playVideo()
                               }
        is AudioAttachment -> {
            val attachment = attachments[index] as AudioAttachment
            attachment.playAudio()
        }
        is DocAttachment -> {
            val attachment = attachments[index] as DocAttachment
            attachment.readDoc()
        }
        is LinkAttachment -> {
            val attachment = attachments[index] as LinkAttachment
            attachment.goLink()
        }
        else -> {"Unknown type"}
    }
}
