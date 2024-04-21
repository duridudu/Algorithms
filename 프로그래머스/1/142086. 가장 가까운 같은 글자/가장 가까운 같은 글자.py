def solution(s):
    answer = []
    temp = []
    temp2 = {}
    s = list(s)
    for i in range(len(s)):
        if s[i] in temp:
            answer.append(i-temp2[s[i]])
            temp2[s[i]]=i
        else:
            answer.append(-1)
            temp.append(s[i])
            temp2[s[i]]=i
    return answer