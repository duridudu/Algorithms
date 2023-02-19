from collections import Counter

def solution(k, tangerine):
    answer = 0
    i=0
    temp=set(tangerine)
    arr=[]
    
    # for t in temp:
    #     ## 먼가 얘때매 시간복잡도가 높아진듯한 . . . 
    #     ## count는 
    #     arr.append(tangerine.count(t))
    mode = Counter(tangerine).most_common()
    # print(mode)
    # arr.sort(reverse=True)
    
    while(True):
        k=k-mode[i][1]
        if k<=0:
            break
        i+=1
        
    answer=i+1
    return answer