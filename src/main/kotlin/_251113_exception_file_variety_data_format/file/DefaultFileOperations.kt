package _251113_exception_file_variety_data_format.file

import java.io.File

class DefaultFileOperations : FileOperations {
    override fun copyFile(source: File, destination: File) {
        try {
            val str = source.readText()
            destination.writeText(str)
        } catch (e: Exception) {
            println("파일이 없습니다.")
        }
    }
}