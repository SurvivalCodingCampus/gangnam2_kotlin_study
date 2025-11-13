# 예외 Exception
- Java와 동일하다.
- Java에서 메서드 선언문에 `throw xxxException` 예외를 던지는 것을 작성할 수 있는데 코틀린에서는 안적고, try-catch가 없으면 동일하다.

# 파일 조작
- Java의 `File()`을 사용해서 Java와 동일하다.

# 직렬화 Serialization
- **직렬화**: `클래스 -> JSON`
- **역직렬화**: `JSON -> 클래스`

코틀린 공식 직렬화 라이브러리를 활용할 수 있다.
`build.gradle.kts` 파일에 추가해서 사용하면 된다.

```build.gradle.kts
plugins {
    kotlin("plugin.serialization") version "2.2.21"    
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
}
```
**JSON과 동일한 필드명인 경우 `@Serializable` 어노테이션을 붙이면 된다.**

```kotlin
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeFromString

@Serializable
data class User(val name: String, val email: String)

fun main() {
    // 직렬화
    val json = Json.encodeToString(User("홍", "a@a.com"))
    println(json) // { "name": "홍", "email": "a@a.com" }
    
    // 역직렬화
    val user = Json.decodeFromString<User>(json)
    println(user) // User(name="홍", email: "a@a.com")
}
```
