from heapq import heappop, heappush

def solution(scoville, K):
    answer = 0
    heap = []
    for s in scoville:
        heappush(heap,s)
    while(True):
        if len(heap)==1 and heap[0]<K:
            answer=-1
            break
        elif heap[0]>=K:
            break
        else:
            h1 = heappop(heap)
            h2 = heappop(heap)
            heappush(heap, h1+h2*2)
            
            answer+=1
    return answer