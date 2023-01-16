from collections import deque

N=int(input())
arr=list(range(1,N+1))
q=deque(arr)
i=0
while(len(q)>1):
    # print(q)
    if i%2==0:
        ## 파이썬에서 큐 쓸 때 쌩리스트 비추!!! 
        q.popleft()
    else:
        temp=q.popleft()
        q.append(temp)
    i+=1
print(q.popleft())