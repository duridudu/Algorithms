def solution(diffs, times, limit):
    answer = 0
    d = diffs.copy()
    d.sort()
    start = 0
    fin = d[-1]
    ans = []
    temp = times[0]
    
    while(start<=fin):
        #now = (d[start]+d[fin]) // 2
        now = (start+fin)//2
        #print("index, start, fin : ", now_idx, start, fin)
        #print("value : ", now)
        temp = times[0]
        #print("first : ", temp)
        for i in range(1,len(diffs)):
            #print(diffs[i], times[i], times[i-1])
            temp += get_time(diffs[i], times[i], times[i-1], now)
        print("sums : ", temp)
        if temp <= limit and now > 0:
            ans.append(now)
            fin = now - 1
        # 시간이 제한보다 오래 걸리면 레벨을 올려야함 -> 오른쪽으로 가야함
        else:
            start = now + 1 
    print(ans)
    return min(ans)

def get_time(diff, time_cur, time_prev, level):
    
    if diff <= level :
        return time_cur
    else:
        return (diff-level)*(time_cur+time_prev)+time_cur
        