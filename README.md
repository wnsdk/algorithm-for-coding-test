# 🧠 코딩테스트를 위한 알고리즘 유형 정리

예시 코드는 모두 파이썬으로 작성되었다.  
파이썬 문법은 [여기](./sub/python.md)에서 확인.  
아래 목차에서 다루지 않은 기타 자잘한 알고리즘은 [여기](./sub/etc.md)에서 확인.

### 목차
- [자료구조](#자료구조)
- [완전 탐색](#완전-탐색)
- [이분 탐색](#이분-탐색)
- [동적 계획법](#동적-계획법)
- [탐욕법](#탐욕법)
- [소수](#소수)
- [약수와 배수](#약수와-배수)
- [위상정렬](#위상정렬)
- 누적 합 (예정)
- 분할 정복 (예정)
- 최소 신장 트리 (예정)
- 컨벡스 헐 (예정)
- 세그먼트 트리 (예정)
- 문자열 알고리즘 (예정)

<br><br><br><br><br>

# 자료구조

알고리즘 문제를 풀 때 필요한 데이터들을 어떤 자료구조에 담을 것인지를 고민해야한다.

## 배열 / 스택

→ list

```python
list = []

list.append(x)
list.pop()
```

- 배열 Array
- 스택 Stack : 한 쪽 끝에서만 데이터를 넣고 뺄 수 있는 선형 자료구조 (FILO 또는 LIFO)

## 큐 / 덱

→ deque

```python
from collections import deque

dq = deque()

dq.append(x)
dq.pop()

dq.appendleft(x)
dq.popleft()
```

- 큐 Queue : 한 쪽에서는 데이터를 넣을 수만 있고, 다른 한 쪽은 데이터를 뺄 수만 있는 선형 자료구조 (FIFO 또는 LILO)
- 덱 Deque : 양 쪽 모두에서 데이터를 넣고 뺄 수 있는 선형 자료구조

## 우선순위 큐

→ heap

```python
import heapq

h = []

heapq.heappush(h, x)
heapq.heappop(h)
```

- 우선순위 큐 Priority Queue : 우선순위 큐는 내부적으로 힙(heap)이라는 완전이진트리로 구성되어있다. 파이썬의 경우 힙의 루트 노드에는 ‘언제나’ 최솟값이 들어있다. (최소힙)

## 맵

→ dict

```python

```

## 집합

→ set

## 그래프

→ 인접 행렬 / 인접 리스트

**구성**

- 정점 (Vertex 또는 Node)
- 간선 (Edge)

**그래프의 연결 요소 Connected Component**

- 서로 완전히 분리된 요소들을 '연결 요소'라고 합니다.
- 위 그림은 각각의 그래프 2개가 아닌, 연결 요소 2개로 이뤄진 그래프 1개 입니다.

### **[그래프의 분류](https://beluga9.tistory.com/369#%EA%B-%B-%EB%-E%--%ED%--%--%EC%-D%--%--%EB%B-%--%EB%A-%--)**

**1. 그래프의 방향성**

![https://blog.kakaocdn.net/dn/bsyTRB/btrAcQbq66m/2DOJGKE0xA2pgbz9k5lWD0/img.png](https://blog.kakaocdn.net/dn/bsyTRB/btrAcQbq66m/2DOJGKE0xA2pgbz9k5lWD0/img.png)

| 방향 그래프 | 방향이 정해져 있음 |
| --- | --- |
| 무방향 그래프 | 어느 방향으로 가도 상관 없음 (양방향 그래프) |

**2. 그래프의 순환성**

![https://blog.kakaocdn.net/dn/bamCjZ/btrAcuGq9dD/zTlfXjZ1QwdFB90QpiIvcK/img.png](https://blog.kakaocdn.net/dn/bamCjZ/btrAcuGq9dD/zTlfXjZ1QwdFB90QpiIvcK/img.png)

| 순환 그래프 | 순환하는 부분이 한 군데만 있어도 순환 그래프 |
| --- | --- |
| 비순환 그래프 | 순환하는 부분이 전혀 없음 |


무엇을 구하는 문제인가?

 

1. 연결 요소 개수 구하기

for문으로 모든 노드를 돌면서, 방문한 적 없는 노드라면 bfs의 시작 노드로 대입한다.

bfs 함수가 발동된 횟수가 연결 요소의 개수이다.

 

2. 최단거리 구하기

bfs의 큐에 현재 좌표를 append할 때, 현재 좌표까지 오는데 걸렸던 거리 d값을 같이 append한다.

목적지에 도달했을 때의 d는 최단거리임이 보장된다.

 

3. 경로 구하기

chk 리스트는 보통, 각 노드별로 True/False 값만 담기게끔 구성하지만,

각 노드별로 "이 노드에 올 때까지 걸린 경로들(자료형은 집합)"을 담을 수도 있다.

 

경로만 구해야되는 문제일 수도 있고,

가능한 모든 경로의 수를 구해야되는 문제일 수도 있고,

세세한 경로들을 매순간 파악하고 있어야 풀리는 문제도 있을 수 있다.

 

 

목적지가 정해져있는가?

 

1. 목적지가 정해져 있다.

단순히 탐색 노드가 목적 노드와 일치하는지만 따져서 탐색을 종료한다.

 

2. 목적지가 정해져 있지 않다.

목적지가 명시되어 있지 않더라도, 분명 탐색 종료 조건이 있을 것이다.

탐색 종료 조건을 따로 파악해줘야 한다.

 

 

자료구조인 그래프를 저장하는 방법

 

1. 노드간의 연결 정보만 주어졌을 때

인접 행렬(adj)로 구현한다.

 

2. 격자판이 주어졌을 때

격자판(board) 그대로 저장한다.

이동은 dy, dx를 이용한다.

# 완전 탐색

- 모든 경우를 다 살펴본다!
- 거의 같은 의미인 '브루트 포스(무차별 대입)'라는 용어로도 불린다.
- 완전탐색은 모든 경우를 살펴보기에 시간이 오래 걸립니다. 시간을 단축시키고 싶다면 **백트래킹**을 사용한다. 백트래킹이란 탐색 과정에서 더 이상 답이 되지 않는 분기를 발견했을 때 되돌아가는 기법을 의미한다.
- 완전탐색은 크게 반복문 / 재귀 / 큐로 구현할 수 있다.
- 재귀(dfs)로 풀었는데 시간 / 메모리 초과나면 반복문으로 풀어보기

- 조합의 가짓수를 구하는 문제는 파스칼의 삼각형 공식을 이용하여 dp로 풀 수도 있다.

| <!-- --> | <!-- --> |
| --- | --- |
| 순열 | dfs, 백트래킹으로 구현 |
| 중복순열 | 순열과 똑같이 구현하되, 방문체크를 하지 않음 |
| 조합 | 순열과 똑같이 구현하되, 인덱스가 오름차순을 만족하고, 방문체크를 하지 않음 |
| 중복조합 | 순열과 똑같이 구현하되, 인덱스가 비내림차순을 만족하고, 방문체크를 하지 않음 |

## 순열

n개의 수 중 r개를 뽑아 줄을 세우는 방법의 수

- 라이브러리 사용하는 방법
    
    ```python
    from itertools import permutations
    
    arr = [0, 1, 2, 3]
    
    for i in permutations(arr, 4):
        print(i)
    ```
    
- 직접 구현하는 방법
    
    ```python
    chk = [False] * (N + 1)
    ans = []
    
    def permutation(n, m):
        if m == 0:
            print(*ans)
        else:
            for i in range(1, n + 1):
                if not chk[i]:
                    chk[i] = True
                    ans.append(i)
                    permutation(n, m - 1)
                    ans.pop()
                    chk[i] = False
    
    permutation(N, M)
    ```
    

## 중복 순열

n개의 수 중 중복을 허용하여 r개를 뽑아 줄을 세우는 방법의 수

- 라이브러리 사용하는 방법
    
    ```python
    from itertools import product
    
    arr = [0, 1, 2 ,3]
    
    for i in product(arr, repeat = 2):
       print(i)
    ```
    
- 직접 구현하는 방법
    
    ```python
    ans = []
    
    def permutation(n, m):
        if not m:
            print(*ans)
        else:
            for i in range(1, n + 1):
                ans.append(i)
                permutation(n, m - 1)
                ans.pop()
    
    permutation(N, M)
    ```
    

## 조합

n개의 수 중 r개를 뽑는 방법의 수

- 라이브러리 사용하는 방법
    
    ```python
    from itertools import combinations
    
    arr = [0, 1, 2, 3]
    
    for i in combinations(arr, 2):
        print(i)
    ```
    
- 직접 구현하는 방법
    
    ```python
    ans = []
    
    def combination(n, m, idx):
        if not m:
            print(*ans)
        else:
            for i in range(idx + 1, n + 1):
                ans.append(i)
                combination(n, m - 1, i)
                ans.pop()
    
    combination(N, M, 0)
    ```
    

## 중복 조합

n개의 수 중 중복을 허용하여 r개를 뽑는 방법의 수

- 라이브러리 사용하는 방법
    
    ```python
    from itertools import combinations_with_replacement
    
    arr = [0, 1, 2, 3]
    
    for i in combinations_with_replacement(arr, 2):
       print(i)
    ```
    
- 직접 구현하는 방법
    
    ```python
    ans = []
    
    def combination(n, m, idx):
        if not m:
            print(*ans)
        else:
            for i in range(idx, n + 1):
                ans.append(i)
                permutation(n, m - 1, i)
                ans.pop()
    
    combination(N, M, 1)
    ```
    

## DFS

깊이우선탐색

재귀

## BFS

너비우선탐색

큐

```python
# 길찾기 문제
from collections import deque

dy = (0, 1, 0, -1)
dx = (-1, 0, 1, 0)
chk = [[False] * X for _ in range(Y)]

def is_valid_coord(y, x):
	return 0 <= y < Y and 0 <= x < X

def dfs(y, x):
	if adj[y][x] == ans:
    	return
    
    for k in range(4):
    	ny = y + dy[k]
        nx = x + dx[k]
        if is_valid_coord(ny, nx) and not chk[ny][nx]:
        	chk[ny][nx] = True
            dfs(ny, nx)

def bfs(sy, sx):
	q = deque()
    chk[sy][sx] = True
    q.append((sy, sx))
    while q:
    	y, x = q.popleft()
        if adj[y][x] == ans:
        	return
        
        for k in range(4):
        	ny = y + dy[k]
        	nx = x + dx[k]
        	if is_valid_coord(ny, nx) and not chk[ny][nx]:
        		chk[ny][nx] = True
            	q.append((ny, nx))
```

# 이분 탐색

## 선형 탐색

앞에서부터 차례대로 찾는 것

## 이분 탐색

탐색 범위를 절반으로 줄여가면서 찾는 것

배열 안의 값들이 반드시 정렬되어 있어야 한다.

- 라이브러리 사용하는 방법
    
    ```python
    from bisect import bisect_left, bisect_right

    l = bisect_left(arr, key)	#key값 이상인 값의 처음 등장 위치
    r = bisect_right(arr, key)	#key값 초과인 값의 처음 등장 위치

    r - l			#배열에 들어있는 key값의 개수 (리스트의 count 함수보다 빠르다)
    ```
    
    **bisect_left()** : 목표 값보다 같거나 큰 첫 번째 값의 위치 반환
    
    **bisect_right()** : 목표 값도가 큰 첫 번째 값의 위치 반환
    
    **bisect_right() - bisect_left()** : 목표 값이 몇 개 있는지 알 수 있음
    
- 직접 구현하는 방법
    
    ```python
    l = 0
    r = len(arr) - 1
    m = (l + r) // 2

    while l <= r:
        if arr[m] == key:
            break
        elif arr[m] > key:
            r = m - 1
        else:
            l = m + 1
        
        m = (l + r) // 2
    ```
    

## 매개변수 탐색

Parametric Search

최적화 문제를 결정 문제로 바꿔 푸는 탐색 알고리즘

| 최적화 문제Optimization Problem | 결정 문제Decision Problem |
| --- | --- |
| 상황을 만족하는 변수의 최솟값, 최댓값을 구하는 문제 | Yes, No 중 하나로 답할 수 있는 문제 |
- 이분 탐색 방식으로 어떤 두 그룹의 경계선을 찾아냅니다.
- 최종적으로 경계선의 왼쪽 범위를 택할지, 오른쪽 범위를 택할지 여부를 Yes/No 결정 문제의 결과로 정합니다.
- 파라메트릭 서치의 동작 방식은 사실상 이분탐색과 다를 바 없습니다.
- Binary Search와 Parametric Search의 차이점은, Binary Search에서는 배열에서 X와 일치하는 값을 찾으면 바로 함수를 종료하고 위치를 반환하지만, Parametric Search는 함수를 종료하지 않고 더 이상 살펴볼 배열이 남아있지 않을때까지 탐색을 계속합니다.
- 파라메트릭 서치 관련 문제

**[https://beluga9.tistory.com/375](https://beluga9.tistory.com/375)**

# 동적 계획법

Dynamic Programming(DP)

문제를 쪼개고, 부분 문제들의 답을 구하는 과정을 반복하며 푸는 방식

대충 n번째 값을 구하고 싶은데 n번째 값이 앞에서 구해놨던 값들(0~n-1번째 값들)을 활용해서 구하는 문제들을 dp라고 함

점화식을 세우는 문제들이 dp문제

메모이제이션 Memoization

- 한 번 구한 부분 문제의 답을 따로 저장해두고 필요할 때 꺼내쓰는 기법입니다.
- 캐싱(caching)이라고도 합니다.
- 메모이제이션은 DP와는 별개의 개념이긴 하나, DP 문제를 풀 때 시간초과가 나는 경우가 많아 시간 단축을 위해 같이 자주 쓰이는 개념입니다.

## 접근 방식

### Top-down

- 재귀 사용
- 하향식 접근(Top-down) 방식입니다.
- 큰 문제에서 시작하여 점점 작은 부분 문제의 답을 구하기 위해 내려가는 방식입니다.
- 어떤 부분 문제의 답이 필요한 경우에 닥치면 그 때 구합니다. (Lazy-Evaluation 방식)

### Bottom-up

- 반복문 사용
- 상향식 접근(Bottom-up) 방식입니다.
- 작은 부분 문제부터 순차적으로 점점 큰 문제를 풀어가는 방식입니다.
- 모든 부분 문제의 답을 구해 두고 문제를 풉니다. (Eager-Evaluation 방식)
- 이렇게 푸는 방식을 타뷸레이션(Tabulation)이라고도 부릅니다.

### Top-down vs Bottom-up

| 비교 | Top-down | Bottom-up |
| --- | --- | --- |
| 구현 | 재귀 | 반복문 |
| 장점 | 직관적, 코드 가독성 좋음 | 시간, 공간 효율성이 좋음 |
| 단점 | 재귀함수 호출이 많이 느릴 수 있음 | DP테이블을 채워 나가는 순서 파악이 힘듦 |

## 대표 유형

### LIS

Longest Increasing Sequence

가장 긴 증가하는 부분 수열

### Knapsack

# 탐욕법

- 항상 현재 상태에서 최선의 경우만 탐욕스럽게 고르는 전략
- 완전탐색과 달리 모든 경우를 살펴보지는 않는다.
- 그리디 문제들은 특별한 배경지식이 없더도 문제에서 규칙성을 찾으면 풀 수 있는 편이다.
- 다만 난이도를 아주 쉬운 문제부터 매우 어렵게까지, 출제자 마음대로 만들 수 있다.
- 그리디 문제의 진짜 어려운 부분은 바로 '**이 문제가 그리디 문제인지 판별하는 것**'

## 활동 선택 문제

[**[https://www.acmicpc.net/problem/1931](https://www.acmicpc.net/problem/1931)**](https://www.notion.so/https-www-acmicpc-net-problem-1931-b0df1f84c94e4296beea983da8ffedda)

# 소수

# 약수와 배수
최대공약수 / 최소공배수
규칙 1. x와 y의 최대공약수는 y와 x % y의 최대공약수와 같다. (유클리드 호제법)

규칙 2. 두 수의 곱(x * y)는 두 수의 최대공약수와 최소공배수의 곱과 같다.

 

위 두 규칙을 이용하여 아래와 같이 최대공약수와 최소공배수를 구하는 메서드를 짤 수 있습니다.

```python
# x > y
def gcd(x, y):
    while y > 0:
        x, y = y, x % y
    return x

def lcm(x, y):
    return x * y // gcd(x, y)
```
 

아니면 간단하게 math 라이브러리를 import해서 gcd와 lcm 메서드를 쓸 수 있습니다.

(lcm 메서드는 파이썬 버전에 따라 지원하지 않을 수 있습니다. 이 경우, gcd메서드를 이용해서 최소공배수를 구하면 됩니다.)

```python
import math

math.gcd(a, b)
math.lcm(a, b)
```

# 위상정렬

-> bfs 사용

1. 진입차수가 0인 노드(시작점)을 큐에 모두 넣는다
2. 큐에서 진입 차수가 0인 노드를 꺼내어 자신과 인접한 노드의 간선을 제거한다.
3. 간선 제거 후 진입차수가 0이 된 노드를 큐에 넣는다.
- > 큐가 빌 때까지 2-3작업을 반복한다.
- 모든 노드가 처리되었다면 위상정렬 완성
- 모든 노드가 처리되지 않았다면 사이클 발생
