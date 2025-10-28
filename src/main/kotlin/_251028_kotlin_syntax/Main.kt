package `01_syntax`

const val PI = 3.14
fun main(){
    println("헬로월드!")
    readln()
    val x=5 //타입 추론
    val s:String = "Hello"
    val y:Long = x.toLong()
    val str :String = ""
        val a=2
        val b=3

    val result = when (a){
        1-> 10
        2->20
        else->30
    }

    val name:String = "홍길동"
    val name2:String? = "10"
    if(name2!=null){
        println(name2?.toInt())
    }

    sub(a=20,b=20)


    for(i in 0 ..<3){
        println("$i ")
    }
}
fun sub(a:Int, b:Int=0):Int{
    return a-b
}
