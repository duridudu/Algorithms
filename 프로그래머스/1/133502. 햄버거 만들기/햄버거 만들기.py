def solution(ingredient):
    answer = 0
    temp = []
    ## 빵 야채 고기 빵 
    ## 1231
    for i in ingredient:
        temp.append(i)
        if temp[-4:] == [1,2,3,1]:
            answer+=1
            for _ in range(4):
                temp.pop()
    
    return answer