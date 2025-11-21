package com.hhp227.kotlinstudy.`15_http`

import com.hhp227.kotlinstudy.`15_http`.post.Post
import com.hhp227.kotlinstudy.`15_http`.post.PostRemoteDataSourceImpl
import com.hhp227.kotlinstudy.`15_http`.post.PostRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class PostRepositoryImplTest {
    val postRepository = PostRepositoryImpl(PostRemoteDataSourceImpl())

    @Test
    fun `keyword(eum)가 포함된 게시글만 필터링되는지 테스트`() = runTest {
        val expected = listOf(
            "eum et est occaecati",
            "dolorem eum magni eos aperiam quia",
            "optio molestias id quia eum",
            "et fugit quas eum in in aperiam quod",
            "dignissimos eum dolor ut enim et delectus in"
        )
        val result = postRepository.getPostsByKeyword("eum")
        val titles = result.map { it.title }

        assertEquals(expected.size, result.size)
        assertEquals(expected, titles)
    }

    @Test
    fun `keyword(at)가 포함된 게시글만 필터링되는지 테스트`() = runTest {
        val expected = listOf(
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "ea molestias quasi exercitationem repellat qui ipsa sit aut",
            "eum et est occaecati",
            "voluptatem eligendi optio",
            "sint suscipit perspiciatis velit dolorum rerum ipsa laboriosam odio",
            "fugit voluptas sed molestias voluptatem provident", "voluptate et itaque vero tempora molestiae",
            "adipisci placeat illum aut reiciendis qui",
            "doloribus ad provident suscipit at",
            "asperiores ea ipsam voluptatibus modi minima quia sint",
            "iusto eius quod necessitatibus culpa ea",
            "id nihil consequatur molestias animi provident",
            "provident vel ut sit ratione est",
            "eligendi iste nostrum consequuntur adipisci praesentium sit beatae perferendis",
            "ut voluptatem illum ea doloribus itaque eos",
            "laborum non sunt aut ut assumenda perspiciatis voluptas",
            "repellendus qui recusandae incidunt voluptates tenetur qui omnis exercitationem",
            "soluta aliquam aperiam consequatur illo quis voluptas",
            "qui enim et consequuntur quia animi quis voluptate quibusdam",
            "sit vel voluptatem et non libero",
            "qui et at rerum necessitatibus",
            "voluptatum itaque dolores nisi et quasi",
            "qui commodi dolor at maiores et quis id accusantium",
            "consequatur placeat omnis quisquam quia reprehenderit fugit veritatis facere",
            "voluptatem doloribus consectetur est ut ducimus",
            "beatae enim quia vel",
            "consequatur id enim sunt et et",
            "fugiat quod pariatur odit minima",
            "voluptatem laborum magni",
            "sint hic doloribus consequatur eos non id",
            "consequuntur deleniti eos quia temporibus ab aliquid at",
            "enim unde ratione doloribus quas enim ut sit sapiente",
            "necessitatibus quasi exercitationem odio",
            "quam voluptatibus rerum veritatis",
            "pariatur consequatur quia magnam autem omnis non amet",
            "tempora rem veritatis voluptas quo dolores vero",
            "laudantium voluptate suscipit sunt enim enim",
            "odit et voluptates doloribus alias odio et",
            "optio ipsam molestias necessitatibus occaecati facilis veritatis dolores aut",
            "dolore veritatis porro provident adipisci blanditiis et sunt",
            "placeat quia et porro iste",
            "nostrum quis quasi placeat",
            "ad iusto omnis odit dolor voluptatibus",
            "ratione ex tenetur perferendis",
            "beatae soluta recusandae",
            "qui qui voluptates illo iste minima",
            "quaerat velit veniam amet cupiditate aut numquam ut sequi",
            "quas fugiat ut perspiciatis vero provident",
            "laboriosam dolor voluptates",
            "at nam consequatur ea labore ea harum"
        )
        val result = postRepository.getPostsByKeyword("at")
        val titles = result.map { it.title }

        assertEquals(expected.size, result.size)
        assertEquals(expected, titles)
    }

    @Test
    fun `keyword(dolorem)가 포함된 게시글만 필터링되는지 테스트`() = runTest {
        val expected = listOf(
            "dolorem eum magni eos aperiam quia",
            "dolorem dolore est ipsam",
            "nesciunt iure omnis dolorem tempora et accusantium",
            "in quibusdam tempore odit est dolorem",
            "doloremque illum aliquid sunt",
            "qui explicabo molestiae dolorem",
            "eos dolorem iste accusantium est eaque quam",
            "doloremque officiis ad et non perferendis"
        )
        val result = postRepository.getPostsByKeyword("dolorem")
        val titles = result.map { it.title }

        assertEquals(expected.size, result.size)
        assertEquals(expected, titles)
    }

    @Test
    fun `statusCode가 200이 아닐 경우 빈 리스트를 반환`() = runTest {
        val result = postRepository.getPostsByKeyword("Test")

        assertEquals(emptyList<Post>(), result)
    }
}
