from heapq import heappush, heappop
import sys
N = int(sys.stdin.readline())
h=[]

for i in range(N):
    now=int(sys.stdin.readline())
    if now==0:
        if len(h)>0:
            print(heappop(h))
        else:
            print(0)
    else:
        heappush(h, now)

