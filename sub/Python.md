# Python
알고리즘 문제를 풀 때 유용한 문법들을 위주로 작성하였습니다.
- 변환
    - [문자열 ↔ 숫자](#문자열-↔-숫자)
    - [아스키 코드 ↔ 문자](#아스키-코드-↔-문자)
    - [10진수 ↔ 2 8 16진수](#10진수-↔-2-8-16진수)
- 수학
    - [수학](#수학)
    - [올림, 내림, 버림, 반올림](#올림-내림-버림-반올림)
    - [최대 정수, 최소 정수, 양의 무한, 음의 무한](#최대-정수-최소-정수-양의-무한-음의-무한)
- 문자열
    - [문자열 함수](#문자열-함수)
    - [f 문자열 포매팅](#f-문자열-포매팅)
    - [string 변경하고 싶을 때](#string-변경하고-싶을-때)
- 리스트
    - [리스트 함수](#리스트-함수)
    - [커스텀 정렬](#커스텀-정렬)
    - [리스트 컴프리헨션](#리스트-컴프리헨션)
    - [list 잡다한 스킬](#list-잡다한-스킬)
- [자료형](#자료형)
- [입력받기](#입력받기)
- [기타 내장함수](#기타-내장함수)
- [딕셔너리 함수](#딕셔너리-함수)
- [집합 함수](#집합-함수)
- [heapq](#heapq)
- [deque](#deque)
- [for문](#for문)
- [재귀호출 제한 늘리기](#재귀호출-제한-늘리기)
- [Counter](#counter)
- [더 자잘한 팁](#더-자잘한-팁)

<br>

# 자료형

| immutable (변할 수 없다) | mutable (변할 수 있다) |
| --- | --- |
| 불 / 숫자 / 문자열 / 튜플 | 리스트 / 딕셔너리 / 집합 |

<br>

# 입력받기
```python
v1 = input()							#한 줄씩 문자열로 입력받음
v2 = int(input())						#정수로 변환하여 입력받음
v3 = list(input())						#'5263'처럼 띄어쓰기 없이 주어진 입력을 끊어서 저장
v4 = list(map(int, input().split()))	#'5 2 6 3'처럼 띄어쓰기로 구분된 입력을 끊어서 저장
v5 = [list(input()) for _ in range(n)]	#n개의 행으로 이뤄진 2차원 격자판 입력받기
```
```python
import sys

#빠른 입출력 (개행 문자도 같이 입력받으므로 rstrip() 함수도 기억하자)
input = sys.stdin.readline			

#해당 .py 파일이 존재하는 곳에 'input.txt'파일을 두면 여기서 입력을 받아온다.
sys.stdin = open("input.txt", "r")
```
```python
# 입력 뒤에 따라 붙는 공백 문자, 줄바꿈 문자를 없애고 싶다면
input().rstrip()
```

<br>

# 리스트 컴프리헨션
어떤 반복적인 값으로 초기화하며 리스트를 생성
```python
# 1차원 배열 [3, 3, 3, 3, 3, 3, 3, 3]
a1 = [3] * 8
a2 = [3 for i in range(8)]
a3 = list(3 for i in range(8))
a4 = [3, 3, 3] + [3] * 5

# 1차원 배열 [0, 1, 2, 3, 4, 5, 6, 7]
b1 = [* range(8)]
b2 = [i for i in range(8)]
b3 = list(i for i in range(8))


# 2차원 배열 [[1, 1], [1, 1], [1, 1]]
c1 = [[1] * 2 for _ in range(3)]
c2 = [[1 for _ in range(2)] for _ in range(3)]


# 3차원 배열 [[[0, 0], [0, 0]], [[0, 0], [0, 0]]]
d1 = [[[0] * 2 for _ in range(2)] for _ in range(2)]


# [[1] * 4] * 3 이렇게 쓰는 것은 지양할 것
# 다차원 배열을 만들 때 위와 같이 만들면 모두 같은 메모리 주소를 가리키게 됨
```

<br>

# f 문자열 포매팅
```python
val = 'hi'
n = 3.141592

f'{val:<10}' # 왼쪽 정렬   (hi        )
f'{val:^10}' # 가운데 정렬 (    hi    )
f'{val:>10}' # 오른쪽 정렬 (        hi)

f'{val:=^10}' # 가운데 정렬하고 공백을 '='로 채우기 (====hi====)
f'{val:!>10}' # 오른쪽 정렬하고 공백을 '!'로 채우기 (!!!!!!!!hi)

f'{n:0.4f}' # 소수점 4자리까지만 표현 (3.1415)
f'{n:5.4f}' # 소수점 4자리까지만 표현 + 총 자릿수는 10자리 (    3.1415)

f'{{'	# {	
f'}}'	# }
```

<br>

# 문자열 ↔ 숫자

```python
int(x[, y])    # y진수로 표현된 문자열 형태의 숫자 또는 소수점이 있는 숫자 등을 입력받아 정수로 변환

str(x)         # x를 10진수 문자열로 변환
oct(x)         # x를 8진수 문자열로 변환
hex(x)         # x를 16진수 문자열로 변환
```

<br>

## 아스키 코드 ↔ 문자

```python
chr(x)    # 숫자(아스키 코드) -> 문자
ord(x)    # 문자 -> 숫자(아스키 코드)

chr(65) # A
ord('A') # 65
```

<br>

## 수학

```python
abs(x)           # x의 절댓값
min(x)           # 반복 가능한 자료형 x의 최솟값
max(x)           # 반복 가능한 자료형 x의 최댓값
sum(x)           # 반복 가능한 자료형 x의 모든 요소의 합
pow(x, y)        # x의 y 제곱
round(x[, y])    # x를 소수점 y자리까지 반올림
```

<br>

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

<br>

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

<br>

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

<br>

## 딕셔너리 함수

```python
d.keys()    # d의 key값들을 가지고 dict_keys 객체를 생성
d.values()  # d의 value값들을 가지고 dict_values 객체를 생성
d.items()   # d의 key값들과 value값들의 쌍을 튜플로 묶은 후 dict_items 객체를 생성
```

<br>

## 집합 함수

```python
s.add(x)      # 값 1개 추가
s.update(x)   # 값 여러 개 추가 (x는 반복 가능한 자료형)
s.remove(x)   # 값 x를 삭제
```

<br>

## 커스텀 정렬
```python
arr = [(4, 0), (4, 3), (4, 2), (3, 2), (2, 1), (1, 0)]

ex1 = sorted(arr)                                               # 첫번째 요소로 정렬, 첫번째 요소가 같다면 두번째 요소로 정렬
ex2 = sorted(x, reverse=True)                       # 역순으로 정렬
ex3 = sorted(arr, key = lambda x : -x[1])			# 두번째 요소로만 내림차순 정렬
ex4 = sorted(arr, key = lambda x : (x[1], x[0]))	# 두번째 요소로 정렬, 두번째 요소가 같다면 첫번째 요소로 정렬

ex5 = sorted(arr, reverse = False)	# 내림차순 정렬
ex6 = sorted(arr, reverse = True) 	# 오름차순 정렬

ex7 = sorted(arr)   # arr를 정렬한 결과를 반환 (arr는 변경 없음)
arr.sort()          # arr가 정렬됨			  (arr가 변경됨)
```

<br>

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

<br>

# deque

```python
from collections import deque

dq = deque()

dq.append(0)
dq.pop()

dq.appendleft(10)
dq.popleft()
```

<br>

# string 변경하고 싶을 때

```python
# 인덱스를 이용해서 변경하고 싶을 때
str = str[:2] + 'a' + str[3:]
```

# list 잡다한 스킬

```python
# 리스트가 비어있다면
if not list:

# 리스트에 요소가 1개라도 있다면
if list:

# 리스트 길이
len(list)

# 리스트의 제일 마지막 요소
list[-1]

# 리스트 복사
list[:]
list.copy()

# 2차원 이상인 리스트 복사
import copy
copy.deepcopy(list)

# list 순서 뒤집어서 복사
list[::-1]

# 1 2 3으로 출력됨 (리스트 언패킹)
print(*[1, 2, 3])

# 특정 요소가 리스트에 들어있는지 알고 싶을 때 → 집합으로 만들어서 탐색하면 더 빠름
if 2 in [1, 2, 3]:		
if 2 in set([1, 2, 3]):	# 더 빠르다


```

# for문

```python
#테스트 케이스 횟수가 주어지고, 테스트 케이스만큼 같은 연산을 수행해야될 때
for _ in range(int(input())):

#입력받은 문자열을 바로 1글자씩 탐색할 때
for ch in input():

#딕셔너리 d의 key값과 value값을 동시에 탐색할 때
for k, v in d.items():

#리스트 l의 index와 value를 함께 탐색하고 싶을 때
for i, v in enumerate(arr):
```

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

```python
import sys

max_int = sys.maxsize
min_int = -(sys.maxsize + 1)

max_float = float('inf')
min_float = float('-inf')
```

# 올림, 내림, 버림, 반올림

※ 내림(floor) → 소수점을 버리되, 숫자가 더 작아지는 방향으로  
※ 버림(trunc) → 소수점을 버리되, 0과 가까운 방향으로

```python
round(2.55)     # 3
round(2.55, 1)  # 2.6

import math

math.ceil(1.5)      # 2
math.ceil(-1.5)     # -1

math.floor(1.5)     # 1
math.floor(-1.5)    # -2

math.trunc(1.5)     # 1
math.trunc(-1.5)    # -1
```

<br>

# 재귀호출 제한 늘리기
```python
import sys

sys.setrecursionlimit(10 ** 6)
```

<br>

# Counter
```python
from collections import Counter

Counter('hello world') 
# Counter({'l': 3, 'o': 2, 'h': 1, 'e': 1, ' ': 1, 'w': 1, 'r': 1, 'd': 1})

Counter('hello world').most_common()
# 제일 개수가 많은 것부터 순서대로 정렬해서 리스트로 반환한다.
# [('l', 3), ('o', 2), ('h', 1), ('e', 1), (' ', 1), ('w', 1), ('r', 1), ('d', 1)]

Counter('hello world').most_common(1)
# 제일 개수가 많은 것부터 순서대로 정렬하고, 앞에서부터 n개까지만 리스트로 반환한다.
# [('l', 3)]
```

<br>

# 10진수 ↔ 2 8 16진수
```python
# 10진수 → 2진수
bin(102)

# 10진수 → 8진수
oct(102)

# 10진수 → 16진수
hex(102)

# n진수 → 10진수
int('숫자문자열', n)
```

<br>

# 더 자잘한 팁
프로그램 즉시 종료하기
```python
exit(0)
```
두 변수 서로 바꾸기
```python
a, b = b, a
```
삼항연산자
```python
a = '홀' if num % 2 else '짝'
```
2차원 배열 90도 회전
```python
for y in range(N):
    for x in range(N):
        board90[x][N - y - 1] = board0[y][x]
```
- 구간합 : 누적합 만든 후 arr[j] - arr[i - 1]

- 카운팅정렬 : 수의 범위가 좁을 때 빠르게 정렬할 수 있는 방법

- 소수

- 회문(좌우대칭)인지 알수 있는방법 : s == s[::-1] 이면 회문임
