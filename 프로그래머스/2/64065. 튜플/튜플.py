def solution(s):
    answer = []
    s = s[2:len(s)-2].split("},{")
    temp = []
    for nums in s:
        n = nums.split(",")
        n = list(map(int, n))
        temp.append([len(n),n])
    temp.sort(key=lambda x:x[0])
    answer.append(temp[0][1][0])
    for t in range(1,len(temp)):
        for tt in temp[t][1]:
            if tt not in temp[t-1][1]:
                answer.append(int(tt))

    return answer