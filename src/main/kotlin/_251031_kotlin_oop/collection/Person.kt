package _251031_kotlin_oop.collection

class Person(
    val name: String,
    val age: Int
) {}

fun main() {
    val hong = Person("홍길동", 20)
    val han = Person("한석봉", 25)
    val personList = listOf<Person>(hong, han)
    personList.forEach { person ->
        println("${person.name}의 나이는 ${person.age}살")
    }
}
