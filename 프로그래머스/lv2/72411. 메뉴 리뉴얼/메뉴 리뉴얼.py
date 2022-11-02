import itertools
def solution(orders, course):
    answer = []
    
    ## 코스 개수 
    for c_num in course:
        menu=dict()
        for o in orders:
            nPr=list(itertools.combinations(o,c_num))
            
            for c in nPr:
                if c_num > len(o):
                    # print("break!")
                    break
                now=''.join(sorted(list(c)))
                if now in menu:
                    menu[now]=menu.get(now)+1
                else:
                    menu[now]=1
        # print(menu)
        if len(list(menu))>0:
            max_v = max(list(menu.values()))    
            # print(max_v)
            for k,v in menu.items():
                if max_v>1 and v == max_v :
                    # print(k)
                    answer.append(k)
        # print(menu)
    # print(sorted(answer))
    answer = sorted(answer)
    return answer