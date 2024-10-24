def solution(k, m, score):
    answer = 0
    score.sort(reverse = True)
    nums = len(score)//m
    idx = 0
    for i in range(nums):
        now = score[idx:idx+m]
        answer += now[-1]*m
        idx = idx+m
    return answer