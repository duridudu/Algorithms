from itertools import combinations 
def solution(elements):
    sums = [[0]*len(elements)*2 for _ in range(len(elements)*2)]
    k=1
    num = len(elements)
    elements += elements
    sums[0] = elements
    for i in range(1,num):
        #print(sums)
        for j in range(i,i+num):
           # print(i,j)
            sums[i][j] = sums[i-1][j-1] + elements[j]
        k+=1
    
    answer = []
    for s in sums:
        for ss in s:
            answer.append(ss)
            
    answer = set(answer)
    #print(answer)
    return len(answer)-1