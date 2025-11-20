package _251120_test_double_model_class_repository.exercise5

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class AlbumRepositoryImplTest {
    val mockAlbumDataSourceImpl = MockAlbumDataSourceImpl()
    val repository = AlbumRepositoryImpl(mockAlbumDataSourceImpl)

    @Test
    fun `Mock객체에 앨범이 6개 저장되어있다`() = runTest {
        assertEquals(6, repository.getAlbums().size)
    }

    @Test
    fun `repository의 getAlbum의 인자를 넣어주면 인자의 수 만큼 앨범을 반환해준다`() = runTest {
        assertEquals(4, repository.getAlbums(4).size)
    }

    @Test
    fun `repository의 getAlbum의 인자가 실제 객체의 size보다 큰 경우 그냥 전체를 반환해준다`() = runTest {
        assertEquals(mockAlbumDataSourceImpl.mockAlbumList.size, repository.getAlbums(100).size)
        //따로 예외처리 안해도 take함수에서 알아서 해줌

        /*
        public fun <T> Iterable<T>.take(n: Int): List<T> {
            require(n >= 0) { "Requested element count $n is less than zero." }
            if (n == 0) return emptyList()
            if (this is Collection<T>) {
                if (n >= size) return toList() //이 부분
                if (n == 1) return listOf(first())
            }
            var count = 0
            val list = ArrayList<T>(n)
            for (item in this) {
                list.add(item)
                if (++count == n)
                    break
            }
            return list.optimizeReadOnlyList()
        }
        */
    }
}