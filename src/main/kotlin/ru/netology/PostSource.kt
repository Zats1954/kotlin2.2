package ru.netology


class PostSource(
    val type: SourceType,
    val osPlatform: OSPlatform,
    val typeData: TypeData?,
    val url: String = ""
) {

}

enum class TypeData(val typeData: String) {
    PROFILE_ACTIVITY("profileActivity"),
    PROFILE_PHOTO("profile_photo"),
    COMMENTS("comments"),
    LIKE("like"),
    POLL ("poll")
}

enum class OSPlatform(val osPlatform: String) {
    ANDROID("android"),
    IPHONE("iphone"),
    WPHONE("wphone")
}

enum class SourceType(val sourceType: String) {
    VK("vk"),
    WIDGET("widget"),
    API("api"),
    RSS("rss"),
    SMS("sms")
}
