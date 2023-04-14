from collections import deque

def solution(A, B):
    answer = 0
    A=sorted(A)
    B=sorted(B)
    
    A=deque(A)
    B=deque(B)
    
    i=0
    for _ in range(len(A)):
        ## B팀이 이기면 answer에 추가 
        ## A, B팀 가장 작은 숫자 pop
        if A[0] < B[0]:
            answer+=1
            ## 좋은 경기였다.. A,B 둘 다 나가잇-
            A.popleft()
            B.popleft()
        ## A팀이 B팀보다 더 크면 pop하고 다음 A 선수 데려옴
        else:
            ## 이기지 못하는 B팀은 버려잇-
            B.popleft()
        
    return answer