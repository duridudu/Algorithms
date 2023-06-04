from collections import Counter
def solution(topping):
    answer = 0
    
    ## 시간초과
    # for i in range(1, len(topping)):
    #     chulsu=topping[:i]
    #     donseng=topping[i:]
    #     if len(set(chulsu))==len(set(donseng)):
    #         answer+=1
    
    철수=(Counter(topping))
    동생={}
    
    for t in topping:
        if len(철수)==len(동생):
            answer+=1
        if t not in 동생:
            동생[t]=1
        철수[t]-=1
        if 철수[t]==0:
            del 철수[t]
            
            
    
    return answer