def solution(n):
    answer = 0
    stop_num = n//2
    sum=0
    for i in range(1,stop_num+1):
        sum=0
        for k in range(i,n):
            sum+=k
            
            if sum==n:
                answer+=1
                break
            elif sum>n:
                break
    answer+=1
    return answer