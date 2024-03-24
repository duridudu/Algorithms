from itertools import permutations
import math

def solution(numbers):
    answer=[]
    temp = []
    for n in numbers : 
        temp.append(n)
    
    for i in range(1,len(temp)+1):
        nPr = list(permutations(temp, i))
        for p in nPr:
            test = int("".join(p))
            isSosu = sosu(test)
            if isSosu  and test not in answer and test!=1 and test!=0:
                answer.append(test)
    
    return len(answer)

def sosu(x):
    for i in range (2, int(math.sqrt(x) + 1)):
    	if x % i == 0:
        	return False
    return True