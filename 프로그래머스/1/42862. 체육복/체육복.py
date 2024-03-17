def solution(n, lost, reserve):
    answer = 0
    students = [1]*(n+1)
    students[0] = 0
    # 체육복 세팅 
    for l in lost:
        students[l] -= 1
    for r in reserve :
        students[r] += 1

    for i in range(1,n+1):
        ## 도난당한 애일 때
        if i==1 and students[i] == 0:
            if students[i+1]-1 >= 1 :
                students[i+1] -= 1
                students[i] = 1
        
        elif i == n and students[i] == 0:
            if students[i-1]-1 >= 1 :
                students[i-1] -= 1
                students[i] = 1
        elif students[i] == 0 :
            if students[i-1]-1 >= 1 :
                students[i-1] -= 1
                students[i] = 1
            elif students[i+1]-1 >= 1 :
                students[i+1] -= 1
                students[i] = 1
                
    for k in range(1, n+1):
        if students[k] != 0:
            answer+=1
    return answer
            
    ## 바로 앞이나 뒤 학생한테만 체육복 빌려줄수잇음
    ## 체육쉅 들을 수 있는 애들 몇명?
    
#     ## 여벌 체육복 가져온 애가 도난당하는 경우 빼주기
#     for l in lost:
#         if l in reserve:
#             lost.remove(l)
#             reserve.remove(l)
#             # answer-=1
            
#     saved=0
#     for l in lost:
#         if (l-1) in reserve:
#             out=l-1
#             ## remove 쓰면 안된다아 
#             reserve.remove(out)
#             saved+=1
#         elif (l+1) in reserve:
#             out=l+1
#             ## remove 쓰면 안된드아 (for문이 상처받음)
#             reserve.remove(out)
#             saved+=1
            
#     ## 여벌 체육복 가져온 학생이 도난?! 
#     ## => n=5, lost=[1,2,4], reserve=[2,5], return=3 (1,2 못 씀~)
#     answer+=(n-(len(lost)-saved))
    
    return answer