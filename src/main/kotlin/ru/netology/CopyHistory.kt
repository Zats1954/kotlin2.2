package ru.netology

class CopyHistory(var histories:Array<Post> = emptyArray()) {
    fun getPost(index: Int) = histories[index]
    fun setPost(value: Post) {
        histories = histories.plus(value)
    }
}
