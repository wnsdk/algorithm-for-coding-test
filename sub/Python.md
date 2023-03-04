# Python

## 자료형

| immutable
(변할 수 없다) | mutable
(변할 수 있다) |
| --- | --- |
| - 불
- 숫자
- 문자열
- 튜플 | - 리스트
- 딕셔너리
- 집합 |

## 문자열 ↔ 숫자

```python
int(x[, y])    # y진수로 표현된 문자열 형태의 숫자 또는 소수점이 있는 숫자 등을 입력받아 정수로 변환

str(x)         # x를 10진수 문자열로 변환
oct(x)         # x를 8진수 문자열로 변환
hex(x)         # x를 16진수 문자열로 변환
```

## 아스키 코드 ↔ 문자

```python
chr(x)    # 숫자(아스키 코드) -> 문자
ord(x)    # 문자 -> 숫자(아스키 코드)
```

## 수학

```python
abs(x)           # x의 절댓값
min(x)           # 반복 가능한 자료형 x의 최솟값
max(x)           # 반복 가능한 자료형 x의 최댓값
sum(x)           # 반복 가능한 자료형 x의 모든 요소의 합
pow(x, y)        # x의 y 제곱
round(x[, y])    # x를 소수점 y자리까지 반올림
```

## 기타 내장함수

```python
dir(x)     # x와 관련된 변수나 함수를 보여줌
type(x)    # x의 자료형을 반환

map(x, y)           # x는 함수, y는 반복 가능한 자료형. y를 x에 대입한 결과를 묶어서 반환
range([x], y, [z])  # x이상 y미만 증감값이 z인 숫자들을 반복 가능한 객체로 반환
enumerate(x)        # 순서가 있는 자료형 x를 입력받아 인덱스 값을 포함하는 enumerate 객체로 반환

list(x)    # 반복 가능한 자료형 x를 리스트로 변환
tuple(x)   # 반복 가능한 자료형 x를 튜플로 변환
```

## 문자열 함수

```python
s1.count(s2)       # 문자열 s2의 개수
s1.find(s2)        # 문자열 s2의 인덱스 (없으면 -1)
s1.join(s2)        # 문자열 s2의 요소 사이사이에 문자열 s1을 삽입
s1.split([s2])     # 문자열 s1을 문자열 s2를 기준으로 나누기 (비워두면 공백문자를 기준으로)
s1.upper()         # 전체를 대문자로
s1.lower()         # 전체를 소문자로
s1.strip()         # 양쪽 공백 지우기
s1.lstrip()        # 왼쪽 공백 지우기
s1.rstrip()        # 오른쪽 공백 지우기
s1.replace(s2, s3) # 문자열 s1에 있는 문자열 s2를 문자열 s3로 바꾸기
```

## 리스트 함수

```python
l.append(x)    # 맨 마지막에 요소 x를 추가
l.pop([i])     # i번째 요소 반환하고 삭제 (비워두면 맨 마지막 요소)
l.remove(x)    # 처음으로 나오는 요소 x를 삭제
l.sort()       # 정렬
l.reverse()    # 뒤집기
l.count(x)     # 요소 x의 개수
l.index(i)     # i번째 위치에 있는 값 반환
l.insert(i, x) # i번째 위치에 요소 x를 삽입
```

## 딕셔너리 함수

```python
d.keys()    # d의 key값들을 가지고 dict_keys 객체를 생성
d.values()  # d의 value값들을 가지고 dict_values 객체를 생성
d.items()   # d의 key값들과 value값들의 쌍을 튜플로 묶은 후 dict_items 객체를 생성
```

## 집합 함수

```python
s.add(x)      # 값 1개 추가
s.update(x)   # 값 여러 개 추가 (x는 반복 가능한 자료형)
s.remove(x)   # 값 x를 삭제
```

## 정렬

```python
sorted(x)               # 반복 가능한 자료형 x를 정렬한 결과를 반환
sorted(x, reverse=True) # 역순으로 정렬
```

# heapq

※ 파이썬의 힙큐는 정렬조건을 커스텀할 수 없다. 최대힙을 하고 싶으면 값을 넣고 뺄 때 - 기호 붙이는 방법 말곤 없다. (굳이 커스텀 정렬할 수 있긴 한데 복잡하다.)

```python
import heapq

list = []

# 힙 기본 사용법
heapq.heappush(list, 1)
heapq.heappop(list)

# 힙 구조를 가지지 않은 리스트를 힙 구조로 만들어준다.
heapq.heapify(list)
```

# deque

```python
from collections import deque

deq = deque()

# Add element to the start
deq.appendleft(10)

# Add element to the end
deq.append(0)

# Pop element from the start
deq.popleft()

# Pop element from the end
deq.pop()
```

# 아스키코드

```python
# 65
ord('A')

# A
chr(65)
```

# string 변경하고 싶을 때

```python
# 인덱스를 이용해서 변경하고 싶을 때
str = str[:2] + 'a' + str[3:]
```

# list가 비어있는지 확인

```python
# 리스트가 비어있다면
if not list:

# 리스트에 요소가 1개라도 있다면
if list:
```

# list 잡다한 스킬

```python
# 리스트 길이
len(list)

# 리스트의 제일 마지막 요소
list[-1]

# 리스트의 제일 마지막에 값 넣고 빼기
list.pop()
list.append()

# list에서 value로 요소 제거
list.remove('a')

# list에서 요소 개수 세기
list.count('a')

# list 복사
list[:]

# list 순서 뒤집어서 복사
list[::-1]
```

# for문 index와 value 동시에 참조하기

enumerate는 ‘열거하다’라는 뜻이다.

enumerate 내장 함수는 순서가 있는 자료형(tuple, list, string)을 첫번째 인자로 받아서 각각의 index 값과 value 값들을 enumerate 객체로 리턴한다.

두번째 인자로 정수를 전달하면 시작하는 index 값을 조정할 수도 있다.

```python
arr = [2, 7, 10]
for idx, val in enumerate(arr, 5):
    print(idx, val)

# Output:
# 5 2
# 6 7
# 7 10
```

# 최대 정수, 최소 정수, 양의 무한, 음의 무한

```jsx
import sys

max_int = sys.maxsize
min_int = -(sys.maxsize + 1)

max_float = float('inf')
min_float = float('-inf')
```

# 어떤 변수가 갖고 있는 메서드 목록 보기

```jsx
dir(변수명)
```

# 올림, 내림, 버림, 반올림

※ 내림(floor) → 소수점을 버리되, 숫자가 더 작아지는 방향으로

※ 버림(trunc) → 소수점을 버리되, 0과 가까운 방향으로

```python
round(2.55) # 3
round(2.55, 1) # 2.6

import math

math.ceil(1.5) # 2
math.ceil(-1.5) # -1

math.floor(1.5) # 1
math.floor(-1.5) # -2

math.trunc(1.5) # 1
math.trunc(-1.5) # -1
```