package com.survival.kotlinstudy.day15.repository

import com.survival.kotlinstudy.day15.datasource.MockCommentDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class CommentRepositoryImplTest {

    @Test
    fun `CommentRepositoryImpl 의 getComments 테스트!`(): Unit = runBlocking {
        val text = """
       [
          {
            "postId": 1,
            "id": 1,
            "name": "id labore ex et quam laborum",
            "email": "Eliseo@gardner.biz",
            "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
          },
          {
            "postId": 1,
            "id": 2,
            "name": "quo vero reiciendis velit similique earum",
            "email": "Jayne_Kuhic@sydney.com",
            "body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
          },
          {
            "postId": 1,
            "id": 3,
            "name": "odio adipisci rerum aut animi",
            "email": "Nikita@garfield.biz",
            "body": "quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione"
          },
          {
            "postId": 1,
            "id": 4,
            "name": "alias odio sit",
            "email": "Lew@alysha.tv",
            "body": "non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati"
          },
          {
            "postId": 1,
            "id": 5,
            "name": "vero eaque aliquid doloribus et culpa",
            "email": "Hayden@althea.biz",
            "body": "harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et"
          }
      ]
        """

        val expected = 5
        val postId = 1
        val repository = CommentRepositoryImpl(MockCommentDataSourceImpl(text))
        val list = repository.getComments(postId)

        assertEquals(expected, list.size)
        assertEquals(list[0].postId,postId)
        assertEquals(list[0].id,1)
        assertEquals(list[0].name,"id labore ex et quam laborum")
        assertEquals(list[0].email,"Eliseo@gardner.biz")
        assertEquals(list[0].body,"laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium")

        assertEquals(list[1].postId,postId)
        assertEquals(list[1].id,2)
        assertEquals(list[1].name,"quo vero reiciendis velit similique earum")
        assertEquals(list[1].email,"Jayne_Kuhic@sydney.com")
        assertEquals(list[1].body,"est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et")

        assertEquals(list[2].postId,postId)
        assertEquals(list[2].id,3)
        assertEquals(list[2].name,"odio adipisci rerum aut animi")
        assertEquals(list[2].email,"Nikita@garfield.biz")
        assertEquals(list[2].body,"quia molestiae reprehenderit quasi aspernatur\naut expedita occaecati aliquam eveniet laudantium\nomnis quibusdam delectus saepe quia accusamus maiores nam est\ncum et ducimus et vero voluptates excepturi deleniti ratione")

        assertEquals(list[3].postId,postId)
        assertEquals(list[3].id,4)
        assertEquals(list[3].name,"alias odio sit")
        assertEquals(list[3].email,"Lew@alysha.tv")
        assertEquals(list[3].body,"non et atque\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\nquia voluptas consequuntur itaque dolor\net qui rerum deleniti ut occaecati")

        assertEquals(list[4].postId,postId)
        assertEquals(list[4].id,5)
        assertEquals(list[4].name,"vero eaque aliquid doloribus et culpa",)
        assertEquals(list[4].email,"Hayden@althea.biz")
        assertEquals(list[4].body,"harum non quasi et ratione\ntempore iure ex voluptates in ratione\nharum architecto fugit inventore cupiditate\nvoluptates magni quo et")
    }
}