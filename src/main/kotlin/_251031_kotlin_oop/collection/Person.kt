package _251031_kotlin_oop.collection

class Person(
    val name: String
) {}

fun main() {
    val han = Person("한석봉")
    val hong = Person("홍길동")
    val personList = listOf<Person>(han, hong)
    personList.forEach { person ->
        println(person.name)
    }
}
