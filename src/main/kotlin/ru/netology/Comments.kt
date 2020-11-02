package ru.netology

data class Comments(
    var Count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = false,
    val canOpen: Boolean = true,
    var content: Array<String> = emptyArray())
   {
    fun getComment(index: Int) = content[index]
    fun setComment(value: String) {
        content = content.plus(value)
    }
}