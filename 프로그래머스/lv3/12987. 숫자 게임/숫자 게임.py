from collections import deque

def solution(A, B):
    answer = 0
    A=sorted(A)
    B=sorted(B)
    
    A=deque(A)
    B=deque(B)
    # print(A,B)
    i=0
    for _ in range(len(A)):
    # while (True):
        # print(A[0], B[i], i)
        ## B팀이 이기면 answer에 추가 
        ## A, B팀 가장 작은 숫자 pop
        if A[0] < B[0]:
            answer+=1
            A.popleft()
            B.popleft()
            # print("--------",A.popleft())
            # print("--------",B.popleft())
            # i+=1
        ## A팀이 B팀보다 더 크면 pop하고 다음 A 선수 데려옴
        else:
            # i+=1
            # print("요기야")
            B.popleft()
            
        
    return answer