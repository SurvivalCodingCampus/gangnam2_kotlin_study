package com.hhp227.kotlinstudy.`12_async`

import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/*
연습문제1. API 호출 및 데이터 처리
다음과 같은 영화 정보를 반환하는 함수가 있다
suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

    // TODO : Movie 데이터를 리턴하도록 작성
    return
}
Movie 클래스를 작성,
위 함수를 완성하고 title 이 Star Wars인지 확인하는 테스트 코드를 작성하시오

연습문제2
매일 아침, 당신은 새소리에 잠에서 깹니다. 시간이 지나면서, 당신은 세 가지 독특한 새소리를 알아차렸고, 각각 다른 간격으로 반복되는 것을 발견했습니다.

한 새는 1초마다, 다른 새는 2초마다, 마지막 새는 3초마다 소리를 냅니다.

요구사항
각 새의 소리 타이밍을 재현하되, 각 새마다 하나의 코루틴을 사용하세요. 각 코루틴은 4번만 출력한 후 완료되어야 합니다.
1.첫 번째 새는 "꾸우" 소리를 냅니다.
2.두 번째 새는 "까악" 소리를 냅니다.
3.마지막 새는 "짹짹" 소리를 냅니다.

연습문제3
요구사항
이전 과제를 확장하여 콘솔에 4번만 출력하는 제한을 제거하세요.
이제 각 코루틴은 무기한으로 출력할 수 있습니다.
10초 후에 모든 실행 중인 코루틴을 취소하는 메커니즘을 추가하세요.

 */

@Serializable
data class Movie(val title: String, val director: String, val year: Int)

class MovieLoader {
    suspend fun getMovieInfo(): Movie {
        delay(1000)
        val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

        // TODO : Movie 데이터를 리턴하도록 작성
        return Json.decodeFromString<Movie>(json)
    }
}

class BirdSound {
    suspend fun launchBirdSounds(callback: (String) -> Unit) = coroutineScope {
        launch {
            repeat(4) {
                callback.invoke("꾸우")
                delay(1000)
            }
        }
        launch {
            repeat(4) {
                callback.invoke("까악")
                delay(2000)
            }
        }
        launch {
            repeat(4) {
                callback.invoke("짹짹")
                delay(3000)
            }
        }
    }

    suspend fun launchBirdSoundsInfinite(callback: (String) -> Unit) = coroutineScope {
        val currentJob = this

        launch {
            while (isActive) {
                callback("꾸우")
                delay(1000)
            }
        }
        launch {
            while (isActive) {
                callback("까악")
                delay(2000)
            }
        }
        launch {
            while (isActive) {
                callback("짹짹")
                delay(3000)
            }
        }
        launch {
            delay(10_000)
            currentJob.cancel()
        }
    }
}