def solution(brown, yellow):
    answer = []
    ## 가로>=세로
    ## 가로 n, 세로 m (n*m)
    # n=2+1/2*brown-m
    # nm=yellow+brown
    # (2+1/2*brown-m)*m=yellow+brown
    m=1
    while(True):
        if (2+1/2*brown-m)*m==yellow+brown:
            break
        m+=1
    n=2+1/2*brown-m
    answer=[n,m]
    return answer