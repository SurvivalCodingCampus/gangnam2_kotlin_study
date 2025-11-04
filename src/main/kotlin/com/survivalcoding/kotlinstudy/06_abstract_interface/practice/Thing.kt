package com.survivalcoding.kotlinstudy.`06_abstract_interface`.practice

/*
3번.

자산인지 아닌지 따지지 말고, 형태가 있는 것 (Thing) 이면, 무게가 있다
그래서, Double 형으로 무게(weight)를 얻을 수 있도록 getter/setter (property)를 가지는 인터페이스 Thing 을 만드시오
*/

interface Thing {
    var weight: Double  // 무게
}