import math
def solution(n, words):
    answer = [0,0]
    turn=math.ceil(len(words)/n)
    checks=[]
    for i in range(turn):
        for j in range(n):
            idx = i*n + j
            if idx>=len(words):
                break
                
            if idx==0:
                checks.append(words[idx])
                continue
                
            elif len(words[idx])<=1 or words[idx][0]!=words[idx-1][-1] or words[idx] in checks:
                answer=[j+1,i+1]
                return answer
            checks.append(words[idx])
            
    # print(checks)
    return answer