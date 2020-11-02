import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.*
import kotlin.test.assertFalse

class MainTest {
    @Test
    fun post_Add(){
        var post = Post(title ="First test post",
                        text = "First test Text",
                        ownerId = 1)
        post.date = 1603890634
        val posts = WallService()
        posts.add(post)
        post = Post(title ="Second test post",
                    text = "Second test Text",
                    ownerId = 1)
        post.date = 1603631434
        posts.add(post)
        assertEquals(1,posts[1].id)
    }

    @Test
    fun post_UpdateTrue(){
        var post = Post(id=0,title ="First test post",
                        text = "First test Text",
                        ownerId = 1)
        post.date = 1603890634
        val posts = WallService()
        posts.add(post)
        post = Post(id=0,title ="Second test post",
                    text = "Second test Text",
                    ownerId = 2)
        post.date = 1603631434
        posts.update(post)
        assertEquals(1,posts[0].ownerId)
        assertEquals(1603890634,posts[0].date)
    }

    @Test
    fun post_UpdateFalse(){
        var post = Post(title ="First test post",
            text = "First test Text",
            ownerId = 1)
        post.date = 1603890634
        val posts = WallService()
        posts.add(post)
        post = Post(id =100,title ="Second post", text = "Second test Text", ownerId = 2)
        post.date = 1603631434
        assertFalse (actual = posts.update(post))
    }

    @Test
    fun post_Attachment() {
        val post = Post(title ="First test post",
            text = "First test Text",
            ownerId = 1)
        val attachment = PhotoAttachment()
        attachment.id = 1
        post.attachments?.addAttachment(attachment)
        val attachment1 = VideoAttachment()
        attachment1.id = 2
        post.attachments?.addAttachment(attachment1)
        val attachment2 = AudioAttachment()
        attachment2.id = 3
        post.attachments?.addAttachment(attachment2)
        val attachment3 = DocAttachment()
        attachment3.id = 4
        post.attachments?.addAttachment(attachment3)
        val attachment4 = LinkAttachment()
        attachment4.id = 5
        post.attachments?.addAttachment(attachment4)
        assertEquals("show photo 1", post.attachments?.makeAttachment(0))
        assertEquals("play video 2", post.attachments?.makeAttachment(1))
        assertEquals("play audio 3", post.attachments?.makeAttachment(2))
        assertEquals("read doc 4", post.attachments?.makeAttachment(3))
        assertEquals("go to link 5", post.attachments?.makeAttachment(4))
    }
}