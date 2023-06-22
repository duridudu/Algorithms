def solution(n):
    answer = 0
    binary=bin(n)
    nums=list(binary).count("1")
    
    while(True):
        n+=1
        bi=bin(n)
        if list(bi).count("1")==nums:
            return n

    return answer