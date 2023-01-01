from heapq import heappop, heappush, heapify
TC = int(input())
for tc in range(TC):
    N=int(input())
    chaps=list(map(int, input().split()))
    heapify(chaps)
    res=0
    while len(chaps)>=2:
        a=heappop(chaps)
        b=heappop(chaps)
        res+=(a+b)
        heappush(chaps, a+b)
        # print(chaps)
    print(res)