def solution(strings, n):
    answer = []
    lst = []
    for st in strings:
        lst.append(list(st))
    lst = sorted(lst, key = lambda x : (x[n],x))
    for l in lst:
        answer.append(''.join(l))
    return answer