

## Double Linked List

#### 입력 예시 1
```
5 ↦ 연산의 개수: 5
A 1 S ↦ add(list, 1, 'S')
A 2 t ↦ add(list, 2, 't')
A 3 r ↦ add(list, 3, 'r')
A 3 a ↦ add(list, 3, 'a')
P ↦ print(list)
```

#### 출력 예시 1
```
Star ↦ 5번째 연산(P)에 의한 출력
```

#### 입력 예시 2
```
9 ↦ 연산의 개수: 9
A 1 D ↦ add(list, 1, 'D')
A 2 a ↦ add(list, 2, 'a')
A 3 y ↦ add(list, 3, 'y')
D 1 ↦ delete(list, 1)
P ↦ print(list)
G 3 ↦ get_entry(list, 3)
A 1 S ↦ add(list, 1, 'S')
P ↦ print(list)
G 3 ↦ get_entry(list, 3)
```

#### 출력 예시 2
```
ay ↦ 5번째 연산(P)에 의한 출력
invalid position↦ 6번째 연산 (G 3)에 의한 출력
Say ↦ 8번째 연산 (P)에 의한 출력
y ↦ 9번째 연산 (G 3)에 의한 출력
```


## BinaryTree Search


#### 입력 예시 1
```
9 ↦ 노드 개수
5 3 9
3 8 15
8 0 2
2 0 0
15 0 0
9 7 10
7 12 0
12 0 0
10 0 0
3 ↦ 탐색 횟수
RLL
LL
LR
```

#### 출력 예시 1
```
□5 9 7 12 ↦ 첫 번째 탐색 결과
□5 3 8 ↦ 두 번째 탐색 결과
□5 3 15 ↦ 두 번째 탐색 결과
```
