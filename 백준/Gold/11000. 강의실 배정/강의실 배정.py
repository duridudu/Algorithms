from heapq import heappop, heappush
import sys
input = sys.stdin.readline

N=int(input())
classes=[]
for i in range(N):
    classes.append(list(map(int, input().split())))
classes.sort(key=lambda x:x[0])

heap=[]
heappush(heap, classes[0][1])
for i in range(1, N):
    if heap[0]<=classes[i][0]:
        heappop(heap)
    heappush(heap, classes[i][1])
print(len(heap))