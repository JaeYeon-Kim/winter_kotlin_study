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










