def solution(s):
    lst = list(map(int, s.split()))
    a = max(lst)
    b = min(lst)
    
    answer=""
    answer = str(b) + " " + str(a)
    return answer