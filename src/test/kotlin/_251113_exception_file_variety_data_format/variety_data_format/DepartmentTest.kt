package _251113_exception_file_variety_data_format.variety_data_format

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class DepartmentTest {
    companion object {
        val name = "홍길동"
        val age = 41
        val employee = Employee(name, age)
        val departmentName = "부서명"
        val fileName = "company.txt"
    }

    @Test
    fun `Employee 인스턴스 테스트`() {
        //given
        val employee = Employee(name, age)
        //when

        //then
        assertEquals(true, employee.name == name)
        assertEquals(true, employee.age == age)
        assertEquals(true, Companion.employee == employee)
        assertNotEquals(true, Companion.employee === employee)
    }

    @Test
    fun `Department 인스턴스 테스트`() {
        //given
        val department = Department(departmentName, employee)
        //when

        //then
        assertEquals(true, department.name == departmentName)
        assertEquals(true, department.leader == employee)
    }

    @Test
    fun `파일이 잘 만들어지는지 테스트`() {
        //given
        val department = Department(departmentName, employee)
        val file = File(fileName)
        //when
        saveToFile(department)
        //then
        assertEquals(true, file.exists())

        val fileRead = file.readText() //파일을 직접 읽이서 문자열 비교로 테스트하는 방식
        assertTrue(fileRead.contains(name))
        assertTrue(fileRead.contains(age.toString()))
        assertTrue(fileRead.contains(Json.encodeToString(department)))
        assertTrue(fileRead.contains(name))

        val jsonToObject = Json.decodeFromString<Department>(fileRead) //역직렬화하여 객체를 비교하는 방식
        assertEquals(department, jsonToObject)

        file.delete()
    }


}