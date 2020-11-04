import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.*
import kotlin.test.assertFalse

class MainTest {
    @Test
    fun post_Add(){
        val posts = WallService()
        var post = Post(title ="First test post",
                        text = "First test Text",
                        ownerId = 1)
        post.date = 1603890634
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
        val posts = WallService()
        var post = Post(id=0,title ="First test post",
                        text = "First test Text",
                        ownerId = 1)
        post.date = 1603890634
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
        val posts = WallService()
        var post = Post(title ="First test post",
            text = "First test Text",
            ownerId = 1)
        post.date = 1603890634

        posts.add(post)
        post = Post(id =100,title ="Second post", text = "Second test Text", ownerId = 2)
        post.date = 1603631434
        assertFalse (actual = posts.update(post))
    }

    @Test
    fun post_Attachment() {
        val posts = WallService()
        val post = Post(title ="First test post",
            text = "First test Text",
            ownerId = 1)
        val attachment = PhotoAttachment()
        attachment.id = 1
        posts.addAttachment(post,attachment)
        val attachment1 = VideoAttachment()
        attachment1.id = 2
        posts.addAttachment(post,attachment1)
        val attachment2 = AudioAttachment()
        attachment2.id = 3
        posts.addAttachment(post,attachment2)
        val attachment3 = DocAttachment()
        attachment3.id = 4
        posts.addAttachment(post,attachment3)
        val attachment4 = LinkAttachment()
        attachment4.id = 5
        posts.addAttachment(post,attachment4)
        assertEquals("show photo 1", posts.makeAttachment(post,0))
        assertEquals("play video 2", posts.makeAttachment(post,1))
        assertEquals("play audio 3", posts.makeAttachment(post,2))
        assertEquals("read doc 4", posts.makeAttachment(post,3))
        assertEquals("go to link 5", posts.makeAttachment(post,4))
    }

    @Test
    fun add_Comment_True(){
        val posts = WallService()
        val post = Post(title ="First test post",
            text = "First test Text",
            ownerId = 1)
        posts.add(post)
        posts.createComment(Comment(guid = 0, message = "хороший комментарий"))
        assertEquals ("хороший комментарий", posts.getComment(0)?.message)
        assertEquals (1, posts[0].comments.count)
    }

    @Test(expected = PostNotFoundException::class)
    fun add_Comment_False(){
        val posts = WallService()
        val post = Post(title ="First test post",
            text = "First test Text",
            ownerId = 1)
        posts.add(post)
        posts.createComment(Comment( message = "хороший комментарий", postId = 100))
        assertEquals ("хороший комментарий", posts.getComment(0)?.message)
        assertEquals (1, posts[0].comments.count)
    }

    @Test
    fun reportComment(){
        val posts = WallService()
        val post = Post(title ="First test post",
            fromId = 1,
            text = "First test Text")
        posts.add(post)
        posts.createComment(Comment(guid = 0, message = "хороший комментарий",postId = 0))
        posts.createComment(Comment(guid = 1, message = "нехороший комментарий", postId = 0))
        assertEquals ("нехороший комментарий материал для взрослых", posts.reportComment(0,1,Reason.ADULTS))
    }
}