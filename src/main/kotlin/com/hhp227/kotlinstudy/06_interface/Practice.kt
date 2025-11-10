package com.hhp227.kotlinstudy.`06_interface`

/*
연습문제1
어떤 회사에서 자산관리 프로그램을 만들려고 한다. 현시점에서 컴퓨터, 책 을 표현하는, 다음과 같은 두개의 클래스가 있다

이후, 컴퓨터와 책 이외에도 여러가지 자산을 관리하고 싶은 경우에 유용한 유형자산(TangibleAsset) 이라는 이름의 추상클래스를 작성 하시오.
또, Computer 나 Book 은 그 부모 클래스를 활용한 형태로 수정 하시오.

연습문제2
문제 1 의 회사에서, 형태가 없는 무형자산(IntangibleAsset) 도 관리하려고 생각하고 있다.
무형자산에는, 예를들어 특허권(Patent) 등이 있다.
무형자산도 유형자산도 자산(Asset)의 일종이다.
이것을 전제로 다음의 상속도의 가, 나, 다 부분의 클래스명을 생각 해 보시오.

또한, (가) 에 들어가는 추상 클래스를 개발하고, 이 클래스를 상속하도록 TangibleAsset 를 수정하시오.

연습문제3
자산인지 아닌지 따지지 말고, 형태가 있는 것 (Thing) 이면, 무게가 있다
그래서, Double 형으로 무게(weight)를 얻을 수 있도록 getter/setter (property)를 가지는 인터페이스 Thing 을 만드시오
 */

// 책
class Book(
    var name: String,
    var price: Int,
    var color: String,
    var isbn: String,
    weight: Double
) : TangibleAsset(name, price, color, weight)

// 컴퓨터
class Computer(
    var name: String,
    var price: Int,
    var color: String,
    val makerName: String,
    weight: Double
) : TangibleAsset(name, price, color, weight)

// 자산
abstract class Asset(
    name: String,
    price: Int,
    color: String
)

// 형태가 있는것
interface Thing {
    var weight: Double
}

// 유형자산
abstract class TangibleAsset(
    name: String,
    price: Int,
    color: String,
    override var weight: Double
) : Asset(name, price, color), Thing

// 무형자산
abstract class IntangibleAsset(
    name: String,
    price: Int,
    color: String
) : Asset(name, price, color)

// 특허권
class Patent(
    var name: String,
    var price: Int,
    var color: String,
    val patentNumber: String
) : IntangibleAsset(name, price, color)