package _251113_exception_file_variety_data_format.file

import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DefaultFileOperationsTest {

    @Test
    fun `copy가 잘 되는지 테스트`() {
        //given
        val defaultFileOperations = DefaultFileOperations()
        val sourceFile = File("src.txt")
        sourceFile.writeText("Hi")
        val destFile = File("dst.txt")
        //when
        defaultFileOperations.copyFile(sourceFile, destFile)
        //then
        assertEquals(sourceFile.readText(), destFile.readText())
        sourceFile.delete()
        destFile.delete()
    }

    @Test
    fun `파일이 없는 경우 예외처리가 되었는지 테스트`() {
        //given
        val defaultFileOperations = DefaultFileOperations()
        val sourceFile = File("src.txt")
        val destFile = File("dst.txt")
        //when
        defaultFileOperations.copyFile(sourceFile, destFile)
        //then

    }

}