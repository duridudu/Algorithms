def solution(answers):
    answer = []
    length = len(answers)
    s1s=[1,2,3,4,5]*(10000//5)
    s2s=[2,1,2,3,2,4,2,5]*(10000//8)
    s3s=[3,3,1,1,2,2,4,4,5,5]*(10000//10)
    a1,a2,a3 = 0,0,0
    for a,s1,s2,s3 in zip(answers, s1s[:length+1], s2s[:length+1], s3s[:length+1]):
        if a==s1 :
            a1+=1
        if a==s2:
            a2+=1
        if a==s3:
            a3+=1
    temp = [a1,a2,a3]
    maxScore = max(temp)
    for i in range(len(temp)):
        if temp[i]==maxScore:
            answer.append(i+1)
    return answer