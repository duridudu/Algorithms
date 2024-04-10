import heapq
# len(score)<k
def solution(k, score):
    answer = []
    jundang = []
    if len(score)<k:
        for i in range(len(score)):
            heapq.heappush(jundang, score[i])
            answer.append(jundang[0])
        return answer
    else:
        for i in range(k):
            heapq.heappush(jundang,score[i])
            answer.append(jundang[0])
    flag=False
    for j in range(k,len(score)):
        for t in range(k):
            if score[j] > jundang[t]:
                heapq.heappop(jundang)
                heapq.heappush(jundang, score[j])
                answer.append(jundang[0])
                flag=True
                break
        if flag==False:
            answer.append(jundang[0])
        flag=False
            
    return answer