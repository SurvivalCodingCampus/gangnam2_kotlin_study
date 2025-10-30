### Test Code 작성
#### 1. 테스트 코드 목적
> 프로그램이 의도한 대로 동작하는지 검증
---

#### 2. Given > When > Then 기법
| 단계             | 의미                         | 내용                         |
| -------------- | -------------------------- | -------------------------- |
| **Given (준비)** | 테스트를 수행하기 위한 **초기 상태 설정**  | 필요한 객체 생성, 값 초기화, 전제 조건 설정 |
| **When (실행)**  | 테스트 대상 **행동(기능)**을 수행      | 특정 메서드 호출, 이벤트 트리거         |
| **Then (검증)**  | 실행 결과가 기대한 값과 **일치하는지 확인** | `assert*()` 함수로 결과 비교      |

#### 예제
```kotlin
class WizardTest {

    @Test
    fun `Wizard Heal Test`() {
        // given (준비)
        val wizard = Wizard(name = "마법사", hp = 100)
        val hero = Hero(name = "히어로", hp = 10)

        // when (실행)
        wizard.heal(hero)

        // then (검증)
        assertEquals(20, hero.hp)  // hero의 hp가 20이 되었는지 확인
    }
}
```
**Given**

- Wizard와 Hero 객체를 미리 생성
- Hero의 초기 체력은 10

**When**

- wizard.heal(hero) 메서드를 실행하여 Hero의 HP를 회복

**Then**

- assertEquals(expected, actual)을 사용
- Hero의 HP가 20이 되었는지 검증
---

### 3. Assert 함수 
| 함수                                | 설명                        | 예시                              |
| --------------------------------- | ------------------------- | ------------------------------- |
| `assertEquals(expected, actual)`  | 예상값과 실제값이 같은지 비교          | `assertEquals(20, hero.hp)`     |
| `assertTrue(condition)`           | 조건이 `true`인지 검사           | `assertTrue(hero.hp > 0)`       |
| `assertFalse(condition)`          | 조건이 `false`인지 검사          | `assertFalse(hero.isDead)`      |
| `assertNotNull(value)`            | 값이 `null`이 아닌지 검사         | `assertNotNull(hero)`           |
| `assertTrue(condition)` *(범위 검사)* | 실제값이 예상한 **범위 안에 있는지** 검사 | `assertTrue(hero.hp in 10..20)` |
