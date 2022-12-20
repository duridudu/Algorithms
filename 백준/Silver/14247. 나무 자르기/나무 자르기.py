# 정답 코드
n = int(input())
tree = list(map(int, input().split()))
grow = list(map(int, input().split()))

array = []
for i in range(n):
    array.append((tree[i], grow[i]))

array.sort(key=lambda x : x[1]) # 나무가 자라는 순서로 정렬
answer = 0
for i in range(n):
    answer += array[i][0] + array[i][1] * i # 나무의 길이 + 나무가 자라는 속도 * 자르는 순서

print(answer)