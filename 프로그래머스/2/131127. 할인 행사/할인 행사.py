from collections import Counter
def solution(want, number, discount):
    answer = 0
    temp=dict()
    for w,n in zip(want, number):
        temp[w]=n
        
    for i in range(len(discount)-9):
        mart = Counter(discount[i:i+10])
        if mart==temp:
            answer+=1
            
    return answer