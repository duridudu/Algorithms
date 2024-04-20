def solution(babbling):
    answer = 0
    a = ['aya','ye','woo','ma']
    for i in babbling:
        if i in a:
            answer += 1
        else:
            s1=''
            s2=''
            for j in i:
                s1 += j
                if s1!=s2 and s1 in a:
                    s2=s1
                    s1=''
            if s1=='':
                answer += 1
    return answer