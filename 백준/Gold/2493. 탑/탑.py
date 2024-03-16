n = int(input()) # n=5

tower = list(map(int,input().split()))
stack = []
result = []

for i in range(n):
    while stack:
        if stack[-1][1] >= tower[i]: # 수신할 탑 존재
            result.append(stack[-1][0]+1) # 인덱스 값 + 1 해줘야 수신할 탑의 번호가 됨
            break
        else: stack.pop()

    if not stack:
        result.append(0) # 스택이 비어있으면 수신할 탑이 없으므로 0
    
    stack.append((i, tower[i])) # 탑의 인덱스와 높이는 일단 stack에 집어 넣어야 함 

for i in result:
    print(i, end = ' ')