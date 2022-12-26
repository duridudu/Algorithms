N=int(input())
lost=list(map(int, input().split()))
lost=sorted(lost)

## 짝수개이면 
if N%2==0:
    res=0
    for i in range(int(N/2)):
        temp=lost[i]+lost[N-1-i]
        if temp>res:
            res=temp
## 홀수개이면
else:
    res=0
    # print(lost)
    if lost[N-1]>res:
        res=lost[N-1]
    for i in range(int((N-1)/2)):
        # print(N-1-i)
        temp=lost[i]+lost[N-2-i]
        if temp>res:
            res=temp

print(res)