package _251111_kotlin_instanceBasic

import org.junit.Assert.assertEquals
import java.time.LocalDateTime
import kotlin.test.Test

class BookTest {

    @Test
    fun `제목과 출간일(연월일시분초)이 완전히 같으면 같은 책으로 판단하는지 테스트`() {
        //given
        val title = "책"
        val publishDate = LocalDateTime.of(2025, 12, 25, 10, 30, 0)
        val book1 = Book(title, "작가", publishDate)
        val book2 = Book(title, "작가", publishDate)
        //then
        assertEquals(true, book1 == book2)

    }

    @Test
    fun `제목과 출간일(연월일시분초)이 완전히 같지만 작가가 다른 경우 같은 책으로 판단하는지 테스트`() {
        //given
        val title = "책"
        val author1 = "책1 작가"
        val author2 = "책2 작가"
        val publishDate = LocalDateTime.of(2025, 12, 25, 10, 30, 0)
        val book1 = Book(title, author1, publishDate)
        val book2 = Book(title, author2, publishDate)
        //then
        assertEquals(true, book1 == book2)

    }

    @Test
    fun `제목은 동일하고 출간일의 연월일만 같은경우 같은 책으로 판단하는지 테스트`() {
        //given
        val title = "책"
        val author1 = "책1 작가"
        val author2 = "책2 작가"
        val publishDate1 = LocalDateTime.of(2025, 12, 25, 1, 1, 1)
        val publishDate2 = LocalDateTime.of(2025, 12, 25, 2, 2, 2)
        val book1 = Book(title, author1, publishDate1)
        val book2 = Book(title, author2, publishDate2)
        //then
        assertEquals(true, book1 == book2)
    }

    @Test
    fun `제목은 동일하고 출간일의 연월만 같은경우 다른 책으로 판단하는지 테스트`() {
        //given
        val title = "책"
        val author1 = "책1 작가"
        val author2 = "책2 작가"
        val publishDate1 = LocalDateTime.of(2025, 12, 1, 1, 1, 1)
        val publishDate2 = LocalDateTime.of(2025, 12, 2, 2, 2, 2)
        val book1 = Book(title, author1, publishDate1)
        val book2 = Book(title, author2, publishDate2)
        //then
        assertEquals(false, book1 == book2)
    }

    @Test
    fun `제목이 다른 경우 다른 책으로 판단하는지 테스트`() {
        //given
        val title1 = "책1"
        val title2 = "책2"
        val author = "작가"
        val publishDate = LocalDateTime.of(2025, 12, 1, 1, 1, 1)
        val book1 = Book(title1, author, publishDate)
        val book2 = Book(title2, author, publishDate)
        //then
        assertEquals(false, book1 == book2)
    }


    @Test
    fun `Book 인스턴스를 담고있는 컬렉션을 정렬하면 신상순서대로 정렬되는지 테스트`() {
        //given
        val olderBookTime = LocalDateTime.of(1025, 12, 25, 10, 30, 0) //출간된지 오래된 책
        val newBookTime = LocalDateTime.of(2025, 12, 25, 10, 30, 0) //최근에 출간한 책
        val book = Book("책", "저자", olderBookTime)
        val book2 = Book("책2", "저자", newBookTime)
        //when
        val bookList = listOf(book, book2).sorted()
        //then
        assertEquals(listOf(book2, book), bookList)
    }

    @Test
    fun `깊은 복사로 새로운 인스턴스가 만들어졌는지 테스트`() {
        //given
        val book = Book("책", "작가")
        //when
        val deepCopiedBook = book.deepCopy()
        //then
        assertEquals(false, book === deepCopiedBook)

    }

}