def solution(name, yearning, photo):
    answer = []
    friends=dict(zip(name, yearning))
    
    for p in photo:
        now=0
        for f in p:
            if f in friends.keys():
                now+=(friends[f])
        answer.append(now)
    return answer