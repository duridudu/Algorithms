import collections

def solution(clothes):
    answer = 0
    c = []
    for cc in zip(clothes):
        for (i,j) in cc:
            c.append(j)
    
    dict_c = collections.Counter(c)
    nums = 0
    if len(dict_c) > 1 :
        nums = 1
        for dc in dict_c:
            num = dict_c[dc]
            nums *= (num+1)
        answer = nums-1
    else:
         answer = len(clothes)
            
    return answer