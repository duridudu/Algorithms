from collections import deque

a, b = map(int, input().split())
lst = deque([])
answer = []

for i in range(1,a+1):
    lst.append(i)
    
while(True) :
    for j in range(b):
        if j+1 == b:
            tmp  = lst.popleft()
            answer.append(tmp)
        else:
            tmp = lst.popleft()
            lst.append(tmp)
    if len(lst) == 0 :
        break

print("<" + ', '.join(map(str, answer)) + ">")

