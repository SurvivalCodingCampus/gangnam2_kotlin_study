package com.survivalcoding.kotlinstudy.`06`.practice

/*
1번.

어떤 회사에서 자산관리 프로그램을 만들려고 한다. 현시점에서 컴퓨터, 책 을 표현하는, 다음과 같은 두개의 클래스가 있다

이후, 컴퓨터와 책 이외에도 여러가지 자산을 관리하고 싶은 경우에 유용한 유형자산(TangibleAsset) 이라는 이름의 추상클래스를 작성 하시오.
또, Computer 나 Book 은 그 부모 클래스를 활용한 형태로 수정 하시오.
*/

abstract class TangibleAsset(
    var name: String,
    var price: Int,
    var color: String,
) {
}