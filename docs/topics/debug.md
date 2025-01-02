# 디버깅

## 디버깅
- 디버깅은 소프트웨어의 오류를 식별하고 수정하는 과정 

## 디버깅의 중요성
- 디버깅은 소프트웨어가 올바르게 작동하는지 확인하는데 필수적이다.
- 디버깅하지 않으면 소프트웨어 오류가 발생하거나 제대로 작동하지 않을 수 있다. 

## 디버깅의 기술
- 로깅
    - 로깅은 코드가 실행되는 동안 발생하는 이벤트를 기록하는데 사용할 수 있다.
- 브레이크 포인트
    - 브레이크 포인트는 코드의 특정지점에서 실행을 중지하는 데 사용할 수 있다.

- 디버거
    - 디버거는 디버깅을 도와주는 도구이다. 다양한 기능을 제공하며 디버깅을 더 쉽게 만들 수 있다. 

- 스택 추적
    - 스택 추적은 호출 스택을 추적 하여 코드갓 실행 중인 위치를 하는데 사용할 수 있습니다. 


## 로깅
```text
void main(List<String> arguments) {
    final heroes = <Hero>{}
    
    final h1 = Hero("슈퍼맨", 100);
    final h2 = Hero("슈퍼맨", 100);
    
    heroes.add(h1);
    print(heroes.length);       // ?
    
    heroes.remove(h2)
    print(heroes.length);       // ?
}

print() 함수를 활용하는 법 
```

## 브레이크 포인트 
