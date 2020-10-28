import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.Post
import ru.netology.WallService
import kotlin.test.assertFalse

class MainTest {
    @Test
    fun post_Add(){
        var post = Post(title ="First post", date = 1603890634, ownerId = 1)
        val posts = ru.netology.WallService
        posts.add(post)
        post = Post(title ="Second post", date = 1603631434, ownerId = 1)
        posts.add(post)
        assertEquals(1,posts[1].id)
    }

    @Test
    fun post_UpdateTrue(){
        var post = Post(title ="First post", date = 1603890634, ownerId = 1)
        val posts = ru.netology.WallService
        posts.add(post)
        post = Post(id =0,title ="Second post", date = 1603631434, ownerId = 2)
        posts.update(post)
        assertEquals(1,posts[0].ownerId)
        assertEquals(1603890634,posts[0].date)
    }

    @Test
    fun post_UpdateFalse(){
        var post = Post(title ="First post", date = 1603890634, ownerId = 1)
        val posts = ru.netology.WallService
        posts.add(post)
        post = Post(id =1,title ="Second post", date = 1603631434, ownerId = 2)
        assertFalse (actual = posts.update(post))
    }
}