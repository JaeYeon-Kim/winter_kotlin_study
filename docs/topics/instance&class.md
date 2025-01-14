# 인스턴스와 클래스

## 📚 오늘 배운 내용

### 오브젝트를 도출하는 순서
1. 각 오브젝트가 가지고 있을 만한 "속성" 이나 "동작" 을 생각 해 종류와 내용을 정리 
2. 각 오브젝트를 가상세계에 도출, 동작시켜 보기 

### 용어 정리
- 오브젝트: 현실 세계의 모든 객체
- 클래스: 오브젝트를 가상세계 용으로 구체화 한 것
- 인스턴스: 클래스를 활용 해 메모리 상에 만들어 낸 것

### ex) Hero 클래스를 코드로 표현한 것
```kotlin
class Hero(name: String, hp: Int) {
    fun attack() {}
    fun run() {}
    fun sleep() {}
}
```

### 필드(field)를 상수로서 선언

```kotlin
class Slime(hp: Int, val speed: Int) {
    val level = 10

    fun run() {
        println("슬라임이 ${speed}의 속도로 뛴다.")
    }
}
```

-> 필드에서 접근하려면 var 또는 val 키워드를 지정해야 함
### 클래스와 멤버변수의 네이밍 컨벤션
- 클래스명: 명사, 단어의 맨 처음은 대문자(Pascal) -> ex) Hero, MonsterInfo
- 필드 명 : 명사, 최초 이외의 단어의 맨 처음은 대문자 -> ex) level, items, itemList
- 메소드 명: 동사, 최초 이외의 단어의 맨 처음은 대문자 -> ex) attack, findWeakPoint
### 함수와 메소드의 차이 
- 함수 : 단독으로 동작
- 메소드: 클래스의 기능

### 정리
인스턴스와 클래스
- 인스턴스와 클래스는 완전히 다른 것이다.
- 가상 세계에서 활동하는 것은 인스턴스(오브젝트)
- 인스턴스를 생성하기 위한 틀이 클래스

필드와 메소드
- 클래스에는 속성을 필드로, 동작을 메소드로 선언
- val이 붙은 필드는 상수 필드로서 값이 불변하다.

클래스 타입
- 클래스를 정의하면, 그 클래스 타입의 변수를 선언 할 수 있다. 
- 어떤 클래스 타입 변수는 그 클래스의 인스턴스를 담을 수 있다.

인스턴스화
- 어떤 클래스 타입 변수에 인스턴스가 담겨있을 때 "변수명.필드명"이나 "변수명.메소드명()"으로 그 인스턴스의 필드나 메소드를 이용할 수 있다.

### 레퍼런스 타입과 참조 
- 가상세계 = 컴퓨터 메모리 영역
- 인스턴스 = heap 영역 안에 확보된 메모리 
- Kotlin은 모든 타입이 레퍼런스 타입

### Hero 클래스를 인스턴스화 하여 이용 하는 코드 
```kotlin
val hero = Hero(name = "용사", hp = 100)
```


### Kotlin에서는 모든 타입이 레퍼런스 타입
> Int 형이나 Double 형 같은 기본형뿐만 아니라 String도 Hero와 같은 "레퍼런스 타입"이다.

### 생성자(constructor)
> 인스턴스를 생성하는 방법을 제공 


### named arguments
> 함수를 호출할 때 인수 중 하나 이상의 이름을 지정할 수 있다.   
> 순서를 자유롭게 변경할 수 있다.    
> 가독성이 좋아진다.

### 생성자의 오버로드 
> Kotlin은 기본값을 지정하는 것으로 생성자 오버로딩을 지원한다.


### 모든 클래스는 반드시 1개 이상의 생성자를 가진다. 
-> 생성자를 1개도 작성하지 않으면 기본 생성자가 있는 것으로 본다.


### 정리
레퍼런스 타입의 참조
- 레퍼런스 타입 변수의 안에는 "인스턴스의 정보가 담겨있는 메모리 번지"가 들어 있다.
- 어떤 레퍼런스 타입 변수를 다른 변수에 대입하면, 주소만 복사 된다.
- 레퍼런스 타입은 필드나 메소드의 인수, 리턴 값의 형으로서도 이용된다.

생성자
- 인수를 가지는 생성자를 정의하면, 인수를 지정하여 생성자를 실행할 수 있다.
- 기본값 정의로 생성자는 오버로드 효과를 가진다.
- 클래스에 생성자 정의가 1개도 없는 경우에 한해, 컴파일러가 "인수없음, 리턴 없음"의 기본 생성자가 있다고 본다.

정적 멤버
- companion object는
1. 각 인스턴스가 아닌, 클래스에 실체가 준비된다.
2. 인스턴스를 1개도 생성하지 않아도 이용 가능

- companion object는 그 내부에서만 서로 접근이 가능하다.


### 캡슐화 
- 이제 클래스나 인스턴스를 이용하여 현실세계를 객체 지향 프로그램으로 자유롭게 개발 가능
- 하지만, 실수로 속성을 덮어쓰거나, 잘못된 조작을 하는 등의 휴먼 에러를 완전히 없애는 것은 불가
-> 따라서, 실수를 미연에 방지하는 "캡슐화"를 활용해 보자.

### 멤버에 대한 액세스 제어
접근 지정자

- private: 제한이 엄격, 자기 자신의 클래스에서만 접근 가능
- public: 제한이 느슨, 모든 클래스에서 접근 가능 

### getter와 setter
메소드를 경유한 필드 조작
- getter: 읽기 전용 프로퍼티를 구현할 때 사용 
- setter: 쓰기 전용 프로퍼티를 구현할 때 사용 

숨겨진 데이터를 외부에 노출하는 방법들
1)
```kotlin
class Hero(
    var name: String,
    private var _hp: Int,
    var sword: Sword? = null,
) {
    val hp: Int
        get() = _hp
}
```

2) 코드는 더 길지만 backing field 사용(Android 개발시 더 많이 사용 )
```kotlin
class Hero(
    var name: String,
    hp: Int, // 생성자 파라미터로 사용 
    var sword: Sword? = null
) {
    private var _hp = hp // 내부에서 _로 선언 
    val hp: Int
        get() = _hp
}
```
3) 또 다른 방법 - Effective Kotlin에서 실제로 권장하고 있음
```kotlin
class Hero(
    var name: String,
    hp: Int = 100,
) { // 초기화 
    var hp: Int = hp
    private set
}
```

### getter / setter 메리트
1. Read Only, Write Only 필드의 선언
2. 필드의 이름 등, 클래스의 내부 설계를 자유롭게 변경 가능
3. 필드로의 액세스를 검사 가능
4. val은 getter를 기본적으로 내장, var는 getter와 setter를 내장 

### setter에서 타당성 검사를 하면 ?
> 생성자에 var, val이 없으면 getter, setter 가 없는 것으로 간주함.
> backing field는 프로퍼티의 값을 저장하기 위한 실제 필드, field로 접근 가능

### 정리
캡슐화의 개요
- 캡슐화를 하여 멤버나 클래스로의 접근을 제어할 수 있음
- 특히, 필드에 "현실세계에서 불가능한 값"이 들어가지 않도록 제어

멤버에 대한 접근 지정
- private 멤버는 , 동일 파일 내에서만 접근 가능
- public 멤버는 모든 클래스에서 접근 가능

클래스에 대한 접근 지정
- 함수, 변수와 동일한 규칙 

## 상속
- 이전에 만든 클래스와 닮았지만, 일부 다른 클래스를 만들 필요가 있을 경우가 늘어날 것이다. 


### 복사 붙여넣기의 문제점 
- 추가, 수정에 시간이 걸림
- 소스의 파악이나 관리가 어려워 짐

-> 해결책으로 "상속"을 활용


### 코틀린의 상속에 대해
1. 코틀린은 기본적으로 상속이 금지되어 있음
2. open 키워드는 상속을 가능하게 함 
3. super 클래스의 생성자 호출이 필수 
4. 다중 상속은 Kotlin에서 불가능

### 오버라이드(override)
- 기존 기능을 재정의
- super 클래스의 재정의 대상 메소드를 open 


### 올바른 상속
- 올바른 상속은 "is - a 원칙"이라고 하는 규칙에 대해 따른 상속을 말한다. 

### 잘못된 상속
- 현실세계의 등장인물 사이에 개념적으로 is-a 관계가 되지 못함에도 불구하고 상속을 사용한 경우가 "잘못된 상속"이다.
ex) 필드로 이름과 가격을 가지는 Item 클래스(약초, 포션)를 상속 받는 House

### 잘못된 상속을 하면 안되는 이유 
- 클래스를 확장할때 현실세계와의 모순이 생긴다.
- 객체 지향의 3대 특징 중 1가지 "다형성"을 이용할 수 없게 된다.
```kotlin
// 잘못된 상속의 예시
class HealthPotion: Weapon("체력 포션", 0)  // ??? 포션이 무기를 상속? 
```
-> HealthPotion이 Weapon을 상속 받았다면, HealthPotion으로 싸울 수 있다. 
-> 이렇게 하면 개념적으로 잘못된 상속 

### 구체화와 일반화의 관계
> 자식클래스 일 수록 구체화 되고, 부모 클래스 일 수록 추상적인 것으로 일반화 된다.

### 정리
상속의 기초 
- open 키워드를 사용하여 기존 클래스를 기초롤 하는 새로운 클래스를 정의할 수 있다.
- 부모 클래스의 멤버는 자동적으로 자식 클래스에 상속되므로, 자식 클래스에는 추가 된 부분만 기술하면 된다. 
- 부모 클래스에 있는 메소드를, 자식 클래스에서 재작성 할 경우 이것을 오버라이드 라고 한다.
- 올바른 상속이란 "자식 클래스 is-a 부모 클래스"
- 상속에는 "추상적, 구체적" 관계에 있다는 것을 정의하는 역할도 있음 

인스턴스
- 인스턴스는 내부에 부모클래스의 인스턴스를 가지는 다중구조를 가진다.
- 보다 외측의 인스턴스에 속하는 메소드가 우선적으로 동작한다. 
- 외측의 인스턴스에 속하는 메소드는 super을 사용하여 내측 인스턴스의 멤버에 접근할 수 있다.

생성자 동작
- 다중구조의 인스턴스가 생성되는데, 자동적으로 가장 외측 인스턴스의 생성자부터 호출 됨
- 모든 생성자는, "부모 인스턴스의 생성자를" 호출 할 필요가 있다. 

### 추상클래스와 인터페이스



### 추상클래스
- 상속의 재료로 사용 되는 클래스
- 상세 부분이 미정의 된 클래스 

### 추상클래스의 모습 및 특징
```kotlin
// 추상 클래스
abstract class Character(
    var name: String,
    var hp: Int,
) {
    fun run() = println("$name이 도망갔다.")
    
    // 추상 메서드
    abstract fun attack(slime: Slime)
}

```
- 오버라이드 강제 
- 추상클래스의 제약: 추상클래스는 인스턴스화가 금지되어 있다. 


### 인터페이스
1. 모든 메소드는 추상 메소드 여야 한다.
2. 필드를 가지지 않는다.

### 추상메서드만 가지는 추상클래스 == 인터페이스 
```kotlin
interface Human {
    fun speak()
}
```


### 인터페이스 예시 - 전투 관련 인터페이스 및 인터페이스의 구현 
```kotlin
// 전투가능한
interface Attackable {
    fun attack(target: Slime)     // 슬라임 공격
    fun defend()
}

// 치유 가능한
interface Healable {
    fun heal(target: Hero)  // Hero만 치유 가능 
}

// 기본 영웅 - Attackable만 구현 
open class Hero(
    val name: String,
    var hp: Int = 100
): Attackable {
    override fun attack(target: Slime) {
        println("$name의 물리 공격!")
        target.hp -= 10
        println("${target.name}에게 10의 데미지! (남은 HP: ${target.hp})")
    }
}
```


### 인터페이스의 효과
1. 같은 인터페이스를 구현한 클래스들은 공통 메소드를 구현하고 있음을 보장
2. 어떤 클래스가 인터페이스를 구현하고 있다면, 적어도 그 인터페이스에 정의된 메소드를 가지고 있다는 것이 보증된다. 
3. 다중상속 허용 

### 정리
상속의 재료를 작성하는 개발자의 입장과 역할
- 다른 사람이 상속의 재료로 사용할 부모 클래스를 만드는 입장의 개발자도 존재한다.
- 미래의 개발자가 효율 좋게 안심하고 이용할 수 있는 상속의 재료를 작성하는 것이 그의 사명

추상 클래스
- 내용이 정의되지 않고 상세정의 미정인 메소드가 있는 클래스는 abstract를 붙여서 추상메소드로 한다. 
- 추상 클래스는 인스턴스화 할 수 없다. 
- 추상 클래스와 추상 메소드를 활용한 상속의 재료로서 부모클래스를 개발하면 예기치 않은 인스턴스화나 오버라이드의 미구현의 걱정이 없다.
- open 키워드 없이 사용한다.

인터페이스 
- 추상 클래스 중에, 기본적으로 추상메소드만 가지고 있는 것을 인터페이스로서 특별 취급 할 수 있다. 
- 복수의 인터페이스를 부모로 두는 다중상속 효과가 가능
- 인터페이스를 구현한다고 한다.

### 다형성


### 개발을 즐겁게 하는 다형성
다형성
- 어떤 것을 이렇게도 볼 수 있고, 저렇게도 볼 수 있는 것


### 다형성을 활용하는 방법
- 선언을 상위 개념으로 인스턴스 생성으로 하위 개념으로 한다.
- 추상적인 선언 = 상세 정의로 인스턴스화 

```kotlin
val character: Character = Hero(name = "홍길동", hp = 100)
```

### 인터페이스를 변수의 타입으로 사용하기
```kotlin
interface Human {
    // 말하기 동작을 정의
    fun speak()
}

val human: Human = Dancer(name = "댄서", hp = 100)
```

### 메소드 오버로딩

```kotlin
abstract class Character(val name: String, var hp: Int) {
    abstract fun attack(slime: Slime)
}
class Hero(name: String, hp: Int) : Character(name, hp) {
    override fun attack(slime: Slime) {
        println("$name $slime을 공격했다.")
        println("10의 데미지")
        slime.hp -= 10
    }
    
    fun attack(goblin: Goblin) {
        // 고블린 공격 
    }
}
```

-> 이름이 같고 Input 형식이 다른 메소드를 추가로 정의 가능 

### 정리
인스턴스를 애매하게 퉁치기
- 상속에 의한 is-a 관계가 성립한다면, 인스턴스를 부모 클래스 타입의 변수에 대입할 수 있다. 
- 부모 클래스 타입 변수에 대입하는 것으로, 퉁 칠 수 있음 

상자의 타입 과 내용의 타입의 역할
- 어떤 멤버를 이용할 수 있는가는 상자의 타입이 결정한다.
- 멤버가 어떻게 움직이는지는 내용의 타입이 결정한다. 

취급 변경
- as 키워드를 사용하여 타입 캐스팅을 수행한다.
- is 키워드를 사용하여 타입을 검사할 수 있다. 

다형성
- 같은 부모를 가지는 다른 인스턴스를 동일시하여, 부모 클래스 타입에 담을 수 있다.
- 마찬가지로, 부모 클래스 타입의 인수나 리턴 값을 이용하여, 다른 클래스를 모아서 처리 가능
- 동일시 취급해도, 각각의 인스턴스는 각 클래스의 정의를 따르고 다른 동작을 한다. 


### 인스턴스 기본 조작

### Object 클래스의 기본 기능 
1. Java에서 모든 클래스는 Object 클래스의 메서드와 프로퍼티를 가지고 있다.
2. Java에서 Object 타입 변수에는 모든 인스턴스를 대입할 수 있다. 
3. Kotlin에서는 Any, 하지만 근본은 Object를 따름

<Object 클래스의 대표 메서드>
- toString() : 문자열 표현을 얻음
- equals(): 비교(Kotlin 에서는 == 과 동일함)
- hashCode(): 해시값을 얻음

### toString()
- 오버라이드하여 원하는 결과를 얻도록 수정할 수 있음



### equals()
- equals()를 재정의 하여 ==으로 비교시 나만의 동등성 규칙을 정의할 수 있다.
- List에서 동등성 비교 시 사용됨 

### hashCode()
- hashCode()를 재정의하면 Set, Map 내부에서의 동등성 규칙으로 사용 됨 


-> 클래스 내부의 모든 레퍼런스의 동등함을 비교해야 한다. 


### Set, Map의 동작 원리
Set, Map 계열은 요소를 검색할 때 hashCode를 사용하여 빠르다. List는 순차검색이라 느림
1. 모든 객체는 해시값을 가진다.
2. 동일한 객체는 항상 같은 해시값을 가진다.


### 리스트에서 요소 정렬 
- List.sorted() 메서드는 Comparable을 구현한 객체를 가지는 컬렉션 내부를 정렬해 줌 

### 미리 정렬 규칙을 정하기 위한 Comparable 인터페이스 
```java
public interface Comparable<in T> {
    public operator fun compareTo(other:T):Int
}
```

### copy 메서드
```kotlin
class Person(
    val name: String,
    val age: Int
) {
    fun copy(
        name: String = this.name,
        age: Int = this.age
    ) = Person(name, age)
}
```

-> Primitive 타입과 String 복사


### 얕은 복사
```kotlin
class Address(
    var street: String
)

class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    fun shallowCopy() = Person(name, age, address)
}
```

### 깊은 복사

```kotlin
class Address(
    var street: String
) {
    fun deepCopy() = Address(street)
}

class Person(
    val name: String,
    val age: Int,
    val address: Address
) {
    fun deepCopy() = Person(name, age, address.deepCopy())  // 주소 객체도 새로 생성 
}
```

### Data class
- Kotlin에서는 data class로 정의하면 copy()를 통해 복사를 제공함(분류로는 얕은 복사)


### Data class의 효과
다음 메서드를 정의해준다.

- equals()
- hashCode()
- toString()

-> 다음 메서드를 추가해준다. 얕은 복사 기본 지원
- copy()
































