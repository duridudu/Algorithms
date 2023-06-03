from heapq import heappush, heappop
def solution(operations):
    answer = []
    
    ## 최소힙
    minheap=[]
    ## 최대힙
    maxheap=[]
    
    for o in operations:
        oper=o[0]
        if oper=="I":
            heappush(minheap, int(o[2:]))
            heappush(maxheap, -int(o[2:]))
        elif oper=="D":
            if ((o[2:]=="1") and (len(maxheap)>0)):
                maxnum=-heappop(maxheap)
                minheap.remove(maxnum)
            elif (o[2:]=="-1") and len(minheap)>0: 
                minnum=heappop(minheap)
                maxheap.remove(-minnum)
            

    if len(minheap)==0:
        answer=[0,0]
    else:
        answer.append(-maxheap[0])
        answer.append(minheap[0])
        
    return answer